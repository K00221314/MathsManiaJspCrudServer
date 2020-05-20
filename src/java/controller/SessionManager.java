package controller;

import entities.Results;
import javax.servlet.http.HttpSession;

public class SessionManager
{

	public static Results getSessionResultValue(HttpSession session)
	{
		return (Results) session.getAttribute(SessionKeys.RESULT);
	}

	public static void setSessionResultValue(HttpSession session, Results result)
	{
		session.setAttribute(SessionKeys.RESULT, result);
	}
}
