package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;

public class GoToAdminMainAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
	    
	    if (session != null) {
	    	
	      if (session.getAttribute("getAccounts") != null) {
	        session.removeAttribute("getAccounts");
	      }
	      
	      if (session.getAttribute("toUnlockAccount") != null) {
		        session.removeAttribute("toUnlockAccount");
		      }
		      
	      if (session.getAttribute("registrationAdmin") != null) {
		        session.removeAttribute("registrationAdmin");
		      }
		      
	      if (session.getAttribute("toLockAccount") != null) {
		        session.removeAttribute("toLockAccount");
		      }
		      
	      if (session.getAttribute("deleteNameCard") != null) {
		        session.removeAttribute("deleteNameCard");
		      }
		      
	      if (session.getAttribute("correctionSeriesNumberPassport") != null) {
		        session.removeAttribute("correctionSeriesNumberPassport");
		      }
		      
	      if (session.getAttribute("correctIdentificNumbPassp") != null) {
		        session.removeAttribute("correctIdentificNumbPassp");
		      }
		      
	      if (session.getAttribute("addNewNameCard") != null) {
		        session.removeAttribute("addNewNameCard");
		      }
		      
	      if (session.getAttribute("accountRefill") != null) {
		        session.removeAttribute("accountRefill");
		      }
		}
	    
		RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.GO_TO_ADMIN_MAIN_ACCOUNT);
		dispatcher.forward(request, response);
		
		
		
	}

}
