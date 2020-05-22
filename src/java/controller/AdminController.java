package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.mysql.UserRepository;

public class AdminController extends HttpServlet
{

	private final String loginSessionKey = "admin";
	private final UserRepository userRepository = new UserRepository();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
		HttpSession session = request.getSession();
		Admin user1 = (Admin) session.getAttribute("user");
		if (user1 == null)
		{
			user1 = new Admin();
			session.setAttribute("user1", user1);
		}

		String menu = "home";
		menu = request.getParameter("menu");

		if (menu == null)
		{
			System.out.println("menu is null");
			menu = "home";
		}
		switch (menu)
		{
			case "Login":
				gotoPage("/adminlogin.jsp", request, response);
				break;
			case "SignUp":
				gotoPage("/adminSignup.jsp", request, response);
				break;
			case "Save":
				ProcessSave(request, session);
				gotoPage("/AdminHomepage.jsp", request, response);
				break;
			case "Logout":
				session.invalidate();
				System.out.println("logout");
				gotoPage("/home.jsp", request, response);
				break;
			case "Update":
				ProcessUpdate(request, session, user1);
				gotoPage("/manageUsers.jsp", request, response);
				break;
			case "updateUser":
				gotoPage("/detailedUserView.jsp", request, response);
				break;
			case "DeleteUser":
				String snid = request.getParameter("user_id");
				int nid = Integer.parseInt(snid);
				Admin user2 = new Admin();
				boolean worked = userRepository.deleteUserById(nid);

				ArrayList<User> allusers2 = userRepository.getUsers();

				session.setAttribute("allusers", allusers2);
				gotoPage("/manageUsers.jsp", request, response);
				break;

			case "Process Login":
				boolean validLogin = ProcessLogin(request, session);
				if (!validLogin)
				{
					String message = "invalid logon details.. try again";
					session.setAttribute("message", message);
					gotoPage("/adminlogin.jsp", request, response);
				}
				else
				{

					gotoPage("/adminHome.jsp", request, response);
				}
				break;

			case "getUserView":

				String userid = request.getParameter("user_id");
				int user_id = Integer.parseInt(userid);
				System.out.println("user_id" + user_id);

				User s = userRepository.getUserById(user_id);

				if (s != null)
				{

					session.setAttribute("user", s);
					System.out.println("sesion contents" + session.getAttribute("user"));
					User u;
					System.out.println("get user details " + s.getUserid());
					u = userRepository.getUserById(s.getUserid());
					if (u != null)
					{
						System.out.println("user" + u.getUsername());
						session.setAttribute("user", u);
					}
					else
					{
						System.out.println("user details null");
					}

				}
				gotoPage("/detailedUserView.jsp", request, response);
				break;

			case "home":

				User users = new User();
				ArrayList<User> allusers = new ArrayList<>();
				allusers = userRepository.getUsers();
				session.setAttribute("allusers", allusers);
				gotoPage("/manageUsers.jsp", request, response);
				System.out.println("in switch");
				break;

			case "Save User Details":
				boolean worked1 = ProcessUserUpdate(request, user1, session);
				gotoPage("/profile_Admin.jsp", request, response);
				break;

			default:
				gotoPage("/invalid.jsp", request, response);
				break;

		}
	}

	private boolean ProcessLogin(HttpServletRequest request, HttpSession session) throws SQLException
	{

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User us = new User(username, password);
		userRepository.getUserByCredentials(username, password);
		session.setAttribute("user", us);

		if (us.getUserid() != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private void ProcessSave(HttpServletRequest request, HttpSession session)
	{

		String f_name = request.getParameter("f_name");
		String l_name = request.getParameter("l_name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String profile_pic = request.getParameter("profile_pic");
		String password = request.getParameter("password");

		String bio = request.getParameter("bio");

		System.out.println(f_name);
		User us = new User(f_name, l_name, email, username, profile_pic, password, bio);
		try
		{
			userRepository.insertUser(us);
		}
		catch (Exception ex)
		{
			Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
		}

		session.setAttribute("user", us);
	}

	private void gotoPage(String url,
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher
				= getServletContext().getRequestDispatcher(url);
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
		try
		{
			processRequest(request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
		}
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
		try
		{
			processRequest(request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
		}
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

	public void ProcessUpdate(HttpServletRequest request, HttpSession session, Admin user) throws SQLException
	{
		mapRequestParametersIntoUser(request, user);

		userRepository.updateUser(user);
		SessionManager.setSessionUserValue(session, user);
	}

	private void mapRequestParametersIntoUser(HttpServletRequest request, User user)
	{
		user.setBio(request.getParameter("bio"));
		user.setEmail(request.getParameter("email"));
		user.setfName(request.getParameter("f_name"));
		user.setlName(request.getParameter("l_name"));
		user.setProfilePic(request.getParameter("profile_pic"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));
	}

	private void ProcessDelete(HttpServletRequest request, HttpSession session, Admin user) throws SQLException
	{
		userRepository.deleteUser(user);
		session.setAttribute("user", user);
		System.out.println("userid" + user.getUserid());
	}

	private boolean ProcessUserUpdate(HttpServletRequest request, Admin user, HttpSession session) throws SQLException
	{
		String fName = request.getParameter("f_name");
		String lName = request.getParameter("l_name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String profilePic = request.getParameter("profile_pic");
		String password = request.getParameter("password");
		String bio = request.getParameter("bio");

		int UserID = user.getUserid();

		User user1 = new User(fName, lName, email, username, profilePic, password, bio);
		System.out.println("in process update");

		userRepository.updateUser(user1);

		System.out.println("after update");
		session.setAttribute("user", user1);
		return true;
	}
}
