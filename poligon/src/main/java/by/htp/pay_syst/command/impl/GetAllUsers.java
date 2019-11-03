package by.htp.pay_syst.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class GetAllUsers implements Command {

	final static Logger logger = Logger.getLogger(GetAllUsers.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Service servProvider = ServiceProvider.getInstance().getSelectService();
		List<User> resp;
	
		try{
			resp = servProvider.getUsers();
			request.setAttribute("getUsers", resp);
			
			RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.ADMIN_LIST_ALL_USERS);
			dispatcher.forward(request, response);
			
		}catch(ServiceException e){

			logger.error("GetAllUsers exception from service =" + e);
		}
		
		
		
	}

}
