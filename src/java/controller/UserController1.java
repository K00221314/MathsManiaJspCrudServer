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
import repository.mysql.UserRepository;
import entities.User;

public class UserController1 extends HttpServlet
{

	private final UserRepository userRepository = new UserRepository();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = SessionManager.getSessionUserValue(session);

		String menu = getMenuSelction(request);

		switch (menu)
		{
			case "deleteusers":
				processDelete(request, session, response);
				processGetAll(session, request, response);
				break;
			case "getusersview":
				proeessGetOne(request, session, response);
				break;
			case "home":
				processGetAll(session, request, response);
				break;
			case "save":
				processCreate(request, session);
				processGetAll(session, request, response);
				break;
			case "update"://case "SaveUserDetails":
				processUpdate(request, session, user);
				processGetAll(session, request, response);
				break;
			case "updateusers":
				gotoPage("/detailedUsersView.jsp", request, response);
				break;
			default:
				gotoPage("/invalid.jsp", request, response);
				break;

		}
	}

	private String getMenuSelction(HttpServletRequest request)
	{
		String menu = request.getParameter("menu");
		if (menu == null)
		{
			menu = "home";
		}
		return menu.toLowerCase();
	}

	private void processGetAll(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ArrayList<User> users = UserRepository.getUsers();
			session.setAttribute("users", users);
			gotoPage("/" + WebsiteMap.ManageUsers, request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void processDelete(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException, NumberFormatException, ServletException
	{
		String idString = request.getParameter("id");
		int userId = Integer.parseInt(idString);
		try
		{
			UserRepository.deleteUserById(userId);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void proeessGetOne(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException, ServletException, NumberFormatException
	{
		String idParameterString = request.getParameter("id");
		int userId = Integer.parseInt(idParameterString);
		try
		{
			User user = UserRepository.getUserById(userId);
			SessionManager.setSessionUserValue(session, user);
			session.setAttribute("users", user);
			String[] incorrectAnswers = user.getIncorrect_answers1().split(" ");
			session.setAttribute("incorrect_answer1", incorrectAnswers[0]);
			session.setAttribute("incorrect_answer2", incorrectAnswers[1]);
			session.setAttribute("incorrect_answer3", incorrectAnswers[2]);

			gotoPage("/" + WebsiteMap.DetailedUsersView, request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
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
		User res = new User(category, type, difficulty, question, correct_answer, incorrect_answers1);
		try
		{
			UserRepository.insertUser(res);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (Exception ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
		}

		SessionManager.setSessionUserValue(session, res);
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

	private boolean processUpdate(HttpServletRequest request, HttpSession session, User user)
	{
		User newUser = transformRequestParametersIntoUser(request);
		newUser.setId(user.getId());

		try
		{
			UserRepository.updateUser(newUser);
			SessionManager.setSessionUserValue(session, user);
			System.out.println("saving");

			System.out.println("ID " + newUser.getId());
			System.out.println("worked");
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}

	private User transformRequestParametersIntoUser(HttpServletRequest request)
	{
		String difficulty = request.getParameter("difficulty");
		String question = request.getParameter("question");
		String correct_answer = request.getParameter("correct_answer");

		String incorrect_answer1 = request.getParameter("incorrect_answer1");
		String incorrect_answer2 = request.getParameter("incorrect_answer2");
		String incorrect_answer3 = request.getParameter("incorrect_answer3");

		String incorrect_answers1 = incorrect_answer1 + " " + incorrect_answer2 + " " + incorrect_answer3;

		User user = new User();
		user.setCategory(request.getParameter("category"));
		user.setType(request.getParameter("type"));
		user.setDifficulty(difficulty);
		user.setQuestion(question);
		user.setCorrect_answer(correct_answer);
		user.setIncorrect_answers1(incorrect_answers1);

		return user;
	}
}
