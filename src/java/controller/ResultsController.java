package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.mysql.ResultRepository;
import entities.Results;

public class ResultsController extends HttpServlet
{

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Results result = SessionManager.getSessionResultValue(session);
//		if (result == null)
//		{
//			result = new Results();
//			SessionManager.setSessionResultValue(session, result);
//		}

		String menu = request.getParameter("menu");

		if (menu == null)
		{
			menu = "home";
		}
		switch (menu.toLowerCase())
		{
			case "deleteresults":
				processDelete(request, session, response);
				processGetAll(session, request, response);
				break;
			case "getresultsview":
				proeessGetOne(request, session, response);
				break;
			case "home":
				processGetAll(session, request, response);
				break;
			case "save":
				processCreate(request, session);
				processGetAll(session, request, response);
				break;
			case "update"://case "SaveResultDetails":
				processUpdate(request, session, result);
				processGetAll(session, request, response);
				break;
			case "updateresults":
				gotoPage("/detailedResultsView.jsp", request, response);
				break;

			default:
				gotoPage("/invalid.jsp", request, response);
				break;

		}
	}

	private void processGetAll(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ArrayList<Results> allresults = ResultRepository.getResults();
			session.setAttribute("allresults", allresults);
			gotoPage("/" + WebsiteMap.ManageResults, request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void processDelete(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException, NumberFormatException, ServletException
	{
		String idString = request.getParameter("id");
		int resultId = Integer.parseInt(idString);
		try
		{
			ResultRepository.deleteResultById(resultId);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void proeessGetOne(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException, ServletException, NumberFormatException
	{
		String idParameterString = request.getParameter("id");
		int resultId = Integer.parseInt(idParameterString);
		try
		{
			Results result = ResultRepository.getResultById(resultId);
			SessionManager.setSessionResultValue(session, result);
			session.setAttribute("results", result);
			gotoPage("/detailedResultsView.jsp", request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void processCreate(HttpServletRequest request, HttpSession session)
	{

		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String difficulty = request.getParameter("difficulty");
		String question = request.getParameter("question");
		String correct_answer = request.getParameter("correct_answer");
		String incorrect_answer1 = request.getParameter("incorrect_answer1");
		String incorrect_answer2 = request.getParameter("incorrect_answer2");
		String incorrect_answer3 = request.getParameter("incorrect_answer3");

		String incorrect_answers1 = incorrect_answer1 + " " + incorrect_answer2 + " " + incorrect_answer3;
		System.out.println(category);
		Results res = new Results(category, type, difficulty, question, correct_answer, incorrect_answers1);
		try
		{
			ResultRepository.insertResult(res);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (Exception ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}

		SessionManager.setSessionResultValue(session, res);
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo()
	{
		return "Short description";
	}// </editor-fold>

	private boolean processUpdate(HttpServletRequest request, HttpSession session, Results result)
	{
		Results newResult = transformRequestParametersIntoResult(request);
		newResult.setId(result.getId());

		try
		{
			ResultRepository.updateResult(newResult);
			SessionManager.setSessionResultValue(session, result);
			System.out.println("saving");

			System.out.println("ID " + newResult.getId());
			System.out.println("worked");
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}

	private Results transformRequestParametersIntoResult(HttpServletRequest request)
	{
		String difficulty = request.getParameter("difficulty");
		String question = request.getParameter("question");
		String correct_answer = request.getParameter("correct_answer");
		String incorrect_answers1 = request.getParameter("incorrect_answers1");

		Results result = new Results();
		result.setCategory(request.getParameter("category"));
		result.setType(request.getParameter("type"));
		result.setDifficulty(difficulty);
		result.setQuestion(question);
		result.setCorrect_answer(correct_answer);
		result.setIncorrect_answers1(incorrect_answers1);

		return result;
	}
}
