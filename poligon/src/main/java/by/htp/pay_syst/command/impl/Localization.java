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
		
		
		HttpSession session = request.getSession(true);
		String languageName;
		String pageName;
		
		
//		String respLocalization = "en";
		pageName = request.getParameter(RequestParameterName.REQ_PARAM_LOCALIZATION_PAGE_NAME);
		languageName = request.getParameter(RequestParameterName.REQ_PARAM_LOCALIZATION);
		session.setAttribute("local", languageName);
		
		if (pageName.equals("indexPage")) {
			
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_MAIN_LOC");

		}
		if (pageName.equals("userPage")) {
			
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_MAIN_ACCOUNT");

		}
		if (pageName.equals("adminPage")) {
			
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_ADMIN_MAIN_ACCOUNT");

		}
		if (pageName.equals("forgetPasswPage")) {
			
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_FORGET_PASSWORD");
			
		}
		if (pageName.equals("registrPage")) {
			
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_REGISTRATION");
			
		}

		
		
		
		
//			if(localizationName.equals(respLocalization)){
//				
////				request.setAttribute("local", "en");
////				RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.START_PAGE_INDEX);
////				dispatcher.forward(request, response);
//				
//				session.setAttribute("local", "en");
//				response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_MAIN_ACCOUNT");
////				http://localhost:8080/Poligon/controller
//			}else {
////				request.setAttribute("local", "ru");
////				RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.START_PAGE_INDEX);
////				dispatcher.forward(request, response);
//				
//				session.setAttribute("local", "ru");
//				response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_MAIN_ACCOUNT");
//				
//			}

		
	}

}
