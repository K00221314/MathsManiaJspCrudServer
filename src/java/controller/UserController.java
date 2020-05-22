package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.mysql.UserRepository;

public class UserController extends HttpServlet
{

	private final UserRepository userRepository = new UserRepository();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = SessionManager.getSessionUserValue(session);
		User activeUser = SessionManager.getSessionActiveUserValue(session);

		String menu = getMenuSelction(request);

		switch (menu)
		{
			case UserControllerCommands.About:
				processAbout(request, response);
				break;
			case UserControllerCommands.DeleteUserRequest:
				processDeleteUserRequest(request, response, session);
				break;
			case UserControllerCommands.DeleteActiveUserRequest:
				processDeleteActiveUserRequest(request, response, session);
				break;
			case UserControllerCommands.Login:
				processLogin(request, response);
				break;
			case UserControllerCommands.InsertRequest:
				processInsertRequest(request, response, session);
				break;
			case UserControllerCommands.LoginRequest:
				processLoginReuest(request, response, session);
				break;
			case UserControllerCommands.LogoutRequest:
				processLogoutRequest(request, response, session);
				break;
			case UserControllerCommands.Profile:
				processViewUser(request, response);
				break;
			case UserControllerCommands.SignUp:
				processSignUp(request, response);
				break;
			case UserControllerCommands.Update:
				processUserUpdate(request, response);
				break;
			case UserControllerCommands.UpdateRequest:
				processUserUpdateRequest(request, response, session, user);
				break;
			case UserControllerCommands.ViewAll:
				processViewAll(session, request, response);
				break;
			case UserControllerCommands._ViewUser:
				processViewAll(session, request, response);
				break;
			default:
				gotoPage("/invalid.jsp", request, response);
				break;
		}
	}

	private String getMenuSelction(HttpServletRequest request)
	{
		String menu = request.getParameter("menu");

		return menu.toLowerCase();
	}

	private void processAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		gotoPage("/about.jsp", request, response);
	}

	private void processDeleteUserRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		int userId = Integer.parseInt(request.getParameter("user_id"));
		try
		{
			userRepository.deleteUserById(userId);
			processLogoutRequest(request, response, session);
		}
		catch (SQLException | IOException | ServletException ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void processDeleteActiveUserRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User activeUser = SessionManager.getSessionActiveUserValue(session);

		try
		{
			userRepository.deleteUser(activeUser);
			processLogoutRequest(request, response, session);
		}
		catch (SQLException | IOException | ServletException ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		gotoPage("/login.jsp", request, response);
	}

	private void processLoginReuest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try
		{
			User activeUser = userRepository.getUserByCredentials(username, password);
			if (activeUser == null)
			{
				String message = "Invalid logon details. Please try again.";
				session.setAttribute("message", message);
				gotoPage("/login.jsp", request, response);
			}
			else
			{
				SessionManager.setSessionActiveUserValue(session, activeUser);

				directUserToUserTypeArea(activeUser, session, request, response);
			}
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void directUserToUserTypeArea(User activeUser, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String userType = activeUser.getAccountType();

		if ("Admin".equals(userType))
		{
//TODO Add ADmin code to navigate site
		}
		else
		{
			processViewAll(session, request, response);//TODO: change to go to only one user
		}
	}

	private void processInsertRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		User user = new User();
		mapRequestParametersIntoUser(request, user);
		try
		{
			userRepository.insertUser(user);
			processLogin(request, response);
		}
		catch (Exception ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
		SessionManager.setSessionUserValue(session, user);

	}

	private void processSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		gotoPage("/" + WebsiteMap.AddUser, request, response);
	}

	private void processLogoutRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException
	{
		session.invalidate();
		gotoPage("/home.jsp", request, response);
	}

	private void processUserUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		gotoPage("/UpdateUser.jsp", request, response);
	}

	private void processUserUpdateRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session, User user)
	{
		mapRequestParametersIntoUser(request, user);

		try
		{
			userRepository.updateUser(user);
			SessionManager.setSessionUserValue(session, user);
			//TODO : consider active user
			gotoPage("/profile.jsp", request, response);
		}
		catch (SQLException | ServletException | IOException ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void processViewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//TODO: RD: Look up by id
//		String idParameterString = request.getParameter("id");
//		int userId = Integer.parseInt(idParameterString);
//		try
//		{
//			User user = userRepository.getUserById(userId);
//			SessionManager.setSessionUserValue(session, user);
//			gotoPage("/" + WebsiteMap.DetailedUsersView, request, response);
//		}
//		catch (SQLException ex)
//		{
//			Logger.getLogger(UserController1.class.getName()).log(Level.SEVERE, null, ex);
//		}

		gotoPage("/userProfile.jsp", request, response);
	}

	private void processViewAll(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		try
		{
			ArrayList<User> users = userRepository.getUsers();
			session.setAttribute(SessionKeys.USERS, users);
			gotoPage("/userHome.jsp", request, response);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void mapRequestParametersIntoUser(HttpServletRequest request, User user)
	{
		user.setBio(request.getParameter("bio"));
		user.setEmail(request.getParameter("email"));
		user.setfName(request.getParameter("fName"));
		user.setlName(request.getParameter("lName"));
		user.setProfilePic(request.getParameter("profile_pic"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	@Override
	public String getServletInfo()
	{
		return "Short description";
	}
}
