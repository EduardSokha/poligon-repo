package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;
import by.htp.pay_syst.controller.RequestParameterName;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class UnlockAccount implements Command {

	final static Logger logger = Logger.getLogger(UnlockAccount.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();
		
		int idAccount;
		boolean resp1;
		String resp2;
		
		resp2 = "error, try again";
		idAccount = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_UNLOCK_ACCOUNT_IDACCOUNT));
		
		try {
			resp1 = servProvider.toUnlockAccount(idAccount);
			if(resp1) {
				resp2 = "account successfully unlocked";
			}
			
			session.setAttribute("toUnlockAccount", resp2);
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_UNLOCK_ACCOUNT");
			
	
		} catch (ServiceException e) {
			

			logger.error("UnlockAccount exception from service =" + e);
			
		}
		
		
		
		
//		try {
//			resp1 = servProvider.toUnlockAccount(idAccount);
//			if(resp1) {
//				resp2 = " successfully unlocked";
//			}
//			
//			request.setAttribute("resp", resp2);
//		
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ADMIN_UNLOCK_ACCOUNT_PAGE);
//		dispatcher.forward(request, response);
//			
//		} catch (ServiceException e1) {
//			
//			e1.printStackTrace();
//			
//		}
		
		
		
		
	}

}