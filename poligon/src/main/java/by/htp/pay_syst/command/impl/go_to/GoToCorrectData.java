package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;

public class GoToCorrectData implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		HttpSession session = request.getSession(false);
	    
//	    if (session != null) {
//	    	
//		      if (session.getAttribute("correctionPhoneNumber") != null) {
//		        session.removeAttribute("correctionPhoneNumber");
//		      }
//		      
//		      if (session.getAttribute("correctionPassword") != null) {
//			        session.removeAttribute("correctionPassword");
//			      }
//			      
//		      if (session.getAttribute("correctionName") != null) {
//			        session.removeAttribute("correctionName");
//			      }
//			      
//		      if (session.getAttribute("correctionLogin") != null) {
//			        session.removeAttribute("correctionLogin");
//			      }
//			      
//		      if (session.getAttribute("correctionCodeWord") != null) {
//			        session.removeAttribute("correctionCodeWord");
//			      }
//			      
//		      if (session.getAttribute("correctionAddress") != null) {
//			        session.removeAttribute("correctionAddress");
//			      }
//			      
//		      if (session.getAttribute("addCard") != null) {
//			        session.removeAttribute("addCard");
//			      }
//			      
//		      if (session.getAttribute("correctionResidenceRegistr") != null) {
//			        session.removeAttribute("correctionResidenceRegistr");
//			      }
//			      
//		      if (session.getAttribute("correctionSurname") != null) {
//			        session.removeAttribute("correctionSurname");
//			      }
//		      
//		      if (session.getAttribute("getAccountsAndCards") != null) {
//			        session.removeAttribute("getAccountsAndCards");
//			      }
//		      
//		      if (session.getAttribute("payment") != null) {
//			        session.removeAttribute("payment");
//			      }
//		      
//		      if (session.getAttribute("transferBetweenUsersCards") != null) {
//			        session.removeAttribute("transferBetweenUsersCards");
//			      }
//		      
//		      
//			}
		
		
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.GO_TO_CORRECT_DATA);
		dispatcher.forward(request, response);
		
	}

}
