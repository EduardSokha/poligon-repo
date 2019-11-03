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

public class RegistrationAdmin implements Command {

	final static Logger logger = Logger.getLogger(RegistrationAdmin.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();
		
		int idUser;
		int role;
		boolean resp1;
		String resp2;
		
		resp2 = "error, try again";
		idUser = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_REG_ADMIN_ID_USER));
		role = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_REG_ADMIN_ROLE));
		
		

		try {
			resp1 = servProvider.registrationAdmin(idUser, role);
			
			if(resp1) {
				resp2 = "successfully registration";
			}
			
		
			session.setAttribute("registrationAdmin", resp2);
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_REGISTRATION_ADMIN");
			
			
		} catch (ServiceException e) {
			

			logger.error("RegistrationAdmin exception from service =" + e);
			
		}
		
		
		
		
//		try {
//			resp1 = servProvider.registrationAdmin(idUser, role);
//			if(resp1) {
//				resp2 = "successfully registration";
//			}
//			
//			request.setAttribute("resp", resp2);
//		
//		
//		RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.ADMIN_REGISTR_ADMIN_PAGE);
//		dispatcher.forward(request, response);
//			
//		} catch (ServiceException e1) {
//			
//			e1.printStackTrace();
//			
//		}
		
		
	}

}
