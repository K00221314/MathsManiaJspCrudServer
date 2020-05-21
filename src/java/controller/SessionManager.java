package controller;

import entities.Result;
import entities.User;
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

}
