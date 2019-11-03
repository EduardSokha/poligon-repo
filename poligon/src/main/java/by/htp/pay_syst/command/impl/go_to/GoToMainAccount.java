package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;
import by.htp.pay_syst.entity.User;


public class GoToMainAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
	    
	    if (session != null) {
	    	
	      if (session.getAttribute("correctionPhoneNumber") != null) {
	        session.removeAttribute("correctionPhoneNumber");
	      }
	      
	      if (session.getAttribute("correctionPassword") != null) {
		        session.removeAttribute("correctionPassword");
		      }
		      
	      if (session.getAttribute("correctionName") != null) {
		        session.removeAttribute("correctionName");
		      }
		      
	      if (session.getAttribute("correctionLogin") != null) {
		        session.removeAttribute("correctionLogin");
		      }
		      
	      if (session.getAttribute("correctionCodeWord") != null) {
		        session.removeAttribute("correctionCodeWord");
		      }
		      
	      if (session.getAttribute("correctionAddress") != null) {
		        session.removeAttribute("correctionAddress");
		      }
		      
	      if (session.getAttribute("addCard") != null) {
		        session.removeAttribute("addCard");
		      }
		      
	      if (session.getAttribute("correctionResidenceRegistr") != null) {
		        session.removeAttribute("correctionResidenceRegistr");
		      }
		      
	      if (session.getAttribute("correctionSurname") != null) {
		        session.removeAttribute("correctionSurname");
		      }
	      
	      if (session.getAttribute("getAccountsAndCards") != null) {
		        session.removeAttribute("getAccountsAndCards");
		      }
	      
	      if (session.getAttribute("payment") != null) {
		        session.removeAttribute("payment");
		      }
	      
	      if (session.getAttribute("transferBetweenUsersCards") != null) {
		        session.removeAttribute("transferBetweenUsersCards");
		      }
	      
	      
		}
		
		
		if(session!=null && user!=null) {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.GO_TO_MAIN_ACCOUNT);
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.GO_TO_MAIN);
			dispatcher.forward(request, response);
			
		}
		
//		System.out.println("вошел в комманду");
//		RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.GO_TO_MAIN_ACCOUNT);
//		System.out.println("ща отправит страницу");
//		dispatcher.forward(request, response);
		
		
//		HttpSession session = request.getSession();
//		User user = (User)session.getAttribute("user");
//		
//				
//				session.setAttribute("user", user);
//				System.out.println("ща отправит страницу1");
//				response.sendRedirect("http://localhost:8080/Poligon/controller");
//				System.out.println("ща отправит страницу2");
////				http://localhost:8080/Poligon/
		
		
		
	}

}
