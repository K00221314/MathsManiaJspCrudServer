package web.session.management;

import entities.Result;
import entities.User;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class SessionManager
{

	public static User getSessionActiveUserValue(HttpSession session)
	{
		return (User) session.getAttribute(SessionKeys.ACTIVE_USER);
	}

	public static void setSessionActiveUserValue(HttpSession session, User user)
	{
		session.setAttribute(SessionKeys.ACTIVE_USER, user);
	}

	public static Result getSessionResultValue(HttpSession session)
	{
		return (Result) session.getAttribute(SessionKeys.RESULT);
	}

	public static void setSessionResultValue(HttpSession session, Result result)
	{
		session.setAttribute(SessionKeys.RESULT, result);
	}

	public static User getSessionUserValue(HttpSession session)
	{
		return (User) session.getAttribute(SessionKeys.USER);
	}

	public static void setSessionUserValue(HttpSession session, User user)
	{
		session.setAttribute(SessionKeys.USER, user);
	}

	public static ArrayList<User> getSessionUsersValue(HttpSession session)
	{
		return (ArrayList<User>) session.getAttribute(SessionKeys.USERS);
	}

	public static void setSessionUsersValue(HttpSession session, ArrayList<User> users)
	{
		session.setAttribute(SessionKeys.USERS, users);
	}
}
