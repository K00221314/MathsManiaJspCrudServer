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
		Results result = (Results) session.getAttribute("result");
		if (result == null)
		{
			result = new Results();
			session.setAttribute("result", result);
		}

		String menu = request.getParameter("menu");

		if (menu == null)
		{
			menu = "home";
		}
		switch (menu)
		{

			case "Save":
				processCreate(request, session);
				gotoPage("/AdminControllPage.jsp", request, response);
				break;

			case "updateResults":
				gotoPage("/detailedResultsView.jsp", request, response);
				break;
			case "DeleteResults":
				processDelete(request, session, response);
				break;

			case "Update":
				processUpdate(request, session, result);
				gotoPage("/manageResults.jsp", request, response);
				break;
			case "getResultsView":
				proeessGetOne(request, session, response);
				break;

			case "home":
				processGetAll(session, request, response);
				break;

			case "SaveResultDetails":
				boolean worked1 = processResultsUpdate(request, result, session);
				gotoPage("/manageResults.jsp", request, response);
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
			gotoPage("/manageResults.jsp", request, response);
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
		ArrayList<Results> allresults2;
		try
		{
			allresults2 = ResultRepository.getResults();
			session.setAttribute("allresults", allresults2);
			gotoPage("/manageResults.jsp", request, response);
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
			if (result != null)
			{
				session.setAttribute("results", result);
			}
			else
			{
				System.out.println("results details null");
			}
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
		String incorrect_answers1 = request.getParameter("incorrect_answers1");

//        
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

		session.setAttribute("result", res);

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

	private void processUpdate(HttpServletRequest request, HttpSession session, Results result)
	{
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String difficulty = request.getParameter("difficulty");
		String question = request.getParameter("question");
		String correct_answer = request.getParameter("correct_answer");
		String incorrect_answers1 = request.getParameter("incorrect_answers1");

		System.out.println("category");
		Results res = new Results(result.getId(), category, type, difficulty, question, correct_answer, incorrect_answers1);

		ResultRepository.updateResult(res);
		System.out.println("saving");
		session.setAttribute("res", res);
		System.out.println("ID " + result.getId());
		System.out.println("worked");

	}

	private boolean processResultsUpdate(HttpServletRequest request, Results result, HttpSession session)
	{
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String difficulty = request.getParameter("difficulty");
		String question = request.getParameter("question");
		String correct_answer = request.getParameter("correct_answer");
		String incorrect_answers1 = request.getParameter("incorrect_answers1");

		int Id = result.getId();
		System.out.println("in process update");

		Results newResult = new Results();

		newResult.setCategory(category);
		newResult.setType(type);
		newResult.setDifficulty(difficulty);
		newResult.setQuestion(question);
		newResult.setCorrect_answer(correct_answer);
		newResult.setIncorrect_answers1(incorrect_answers1);

		Results results = ResultRepository.updateResult(newResult);
		// put it back in the sesssion
		System.out.println("after update");
		session.setAttribute("results", newResult);
		return true;
	}
}
