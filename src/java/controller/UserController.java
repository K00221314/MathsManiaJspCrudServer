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
import repository.mysql.UserRepository;

public class UserController extends HttpServlet
{

	private final UserRepository userRepository = new UserRepository();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null)
		{
			System.out.println("no user object");
			user = new User();
			session.setAttribute("user", user);
		}

		String menu = request.getParameter("menu");
		System.out.println("menu" + menu);
		switch (menu)
		{
			case UserControllerCommands.LOGIN:
				System.out.println("go to logon page");
				gotoPage("/login.jsp", request, response);
				break;

			case "SignUp":
				gotoPage("/" + WebsiteMap.AddUser, request, response);
				break;
			case "Save":
				ProcessSave(request, session);
				user = new User();
				ArrayList<User> alluser2 = user.getAllUsers();
				session.setAttribute("allUsers", alluser2);
				gotoPage("/userHome.jsp", request, response);
				break;

			case "Logout":
				session.invalidate();
				gotoPage("/home.jsp", request, response);
				break;

			case "Process Login":
				boolean validLogin = ProcessLogin(request, session);
				System.out.println("in process login");
				User use = (User) session.getAttribute("user");
				System.out.println(use.getAccountType());

				if (!validLogin)
				{
					System.out.println("not valid login");
					String message = "invalid logon details.. try again";
					session.setAttribute("message", message);
					gotoPage("/login.jsp", request, response);
				}
				else
				{

					if ("Student".equals(use.getAccountType()))
					{
						user = new User();
						ArrayList<User> alluser = new ArrayList<>();
						alluser = user.getAllUsers();
						session.setAttribute("allUser", alluser);
						gotoPage("/userHome.jsp", request, response);
					}
				}
				break;

			case "Update User Details":
				gotoPage("/UpdateUser.jsp", request, response);
				break;

			case "About":
				gotoPage("/about.jsp", request, response);
				break;

			case "Save User Details":
				boolean worked = ProcessUserUpdate(request, user, session);
				gotoPage("/profile.jsp", request, response);
				break;

//            case "Delete User Check":
//                System.out.println("case delete");
//                gotoPage("/deleteProfile.jsp", request, response);
//                break;
			case "Delete User":
				ProcessDelete(request, user, session);
				session.invalidate();
				gotoPage("/home.jsp", request, response);
				break;

			case "Get User Details":
				UserDetails(request, user, session);
				gotoPage("/userHome.jsp", request, response);
				break;

			case "Profile":
				gotoPage("/userProfile.jsp", request, response);
				break;

			case "Home":
				System.out.println("Home");
				user = new User();
				ArrayList<User> alluser = new ArrayList<>();
				alluser = user.getAllUsers();
				session.setAttribute("allUser", alluser);

				gotoPage("/userHome.jsp", request, response);
				break;

			default:
				gotoPage("/invalid.jsp", request, response);
				break;
		}
	}

	private boolean ProcessUserUpdate(HttpServletRequest request, User user, HttpSession session)
	{
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String profilePic = request.getParameter("profilePic");
		String password = request.getParameter("password");
		String bio = request.getParameter("bio");

		int UserID = user.getUserid();
		System.out.println("in process update");

		User u = user.updateDatabase(UserID, fName, lName, email, username, profilePic, password, bio);
		// put it back in the sesssion
		System.out.println("after update");
		session.setAttribute("user", u);
		return true;
	}

	private boolean ProcessLogin(HttpServletRequest request, HttpSession session)
	{
		System.out.println("in process login method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		User us = new User(username, password);
		us.Login(username, password);
		session.setAttribute("user", us);
		System.out.println("User id: " + us.getUserid());
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
		System.out.println("in Process save");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String profile_pic = request.getParameter("profile_pic");
		String password = request.getParameter("password");
		String bio = request.getParameter("bio");

		User us = new User(fName, lName, email, username, profile_pic, password, bio);
		us.saveToDatabase();

		session.setAttribute("user", us);
		System.out.println("useridss" + us.getUserid());
	}

	private void ProcessDelete(HttpServletRequest request, User user, HttpSession session)
	{
		int UserID = user.getUserid();
		System.out.println("in  delete");

		User u = new User(user.getUserid());
		u.deleteDateabase(UserID);
		// put it back in the sesssion
		System.out.println("after delete");
		session.setAttribute("user", u);
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

	private void UserDetails(HttpServletRequest request, User user, HttpSession session)
	{
		int UserID = user.getUserid();
		User u = new User(user.getUserid());
		u.getUserDetails(UserID);
		session.setAttribute("user", u);
	}

//	 private String doFileUpload(List<FileItem> items,
//            HttpServletResponse response) {
//
//        String fileName = null;
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        try {
//            //  List items = upload.parseRequest(request);
//            Iterator iterator = items.iterator();
//            while (iterator.hasNext()) {
//                FileItem item = (FileItem) iterator.next();
//
//                if (!item.isFormField()) {
//
//                    fileName = item.getName();
//                    System.out.println("file name " + fileName);
//                    String root = getServletContext().getRealPath("/");
//                    File path = new File(root + "/img");
//                    if (!path.exists()) {
//                        boolean status = path.mkdirs();
//                    }
//
//                    File uploadedFile = new File(path + "/" + fileName);
//                    System.out.println(uploadedFile.getAbsolutePath());
//                    
//                    item.write(uploadedFile);
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileName;
//    }
//
//    private String getMultiRequest(List<FileItem> items, String fieldnameRequired) {
//        System.out.println("in mult request form");
//        String fname = null;
//
//        for (FileItem uploadItem : items) {
//
//            String fieldName = uploadItem.getFieldName();
//
//            if (fieldnameRequired.equals(fieldName)) {
//                System.out.println(uploadItem.getString());
//                return uploadItem.getString();
//            }
//
//        }
//
//        return fname;
//    }
}
