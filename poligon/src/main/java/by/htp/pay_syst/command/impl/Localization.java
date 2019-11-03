package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.RequestParameterName;

public class Localization implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		indexPage
//		userPage
//		adminPage
//		forgetPasswPage
//		registrPage
//		if(true) {
//			throw new RuntimeException();
//		}
		
		HttpSession session = request.getSession(true);
		String languageName;
		String pageName;
		
		
//		String respLocalization = "en";
		pageName = request.getParameter(RequestParameterName.REQ_PARAM_LOCALIZATION_PAGE_NAME);
		languageName = request.getParameter(RequestParameterName.REQ_PARAM_LOCALIZATION);
		session.setAttribute("local", languageName);
		
		if (pageName.equals("indexPage")) {
			
			response.sendRedirect("controller?command=GO_TO_MAIN_LOC");

		}
		if (pageName.equals("userPage")) {
			
			response.sendRedirect("controller?command=GO_TO_MAIN_ACCOUNT");

		}
		if (pageName.equals("adminPage")) {
			
			response.sendRedirect("controller?command=GO_TO_ADMIN_MAIN_ACCOUNT");

		}
		if (pageName.equals("forgetPasswPage")) {
			
			response.sendRedirect("controller?command=GO_TO_FORGET_PASSWORD");
			
		}
		if (pageName.equals("registrPage")) {
			
			response.sendRedirect("controller?command=GO_TO_REGISTRATION");
			
		}
	}
}
