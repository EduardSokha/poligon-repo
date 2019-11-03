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
import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class GetAllAccounts implements Command {

	final static Logger logger = Logger.getLogger(GetAllAccounts.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Service servProvider = ServiceProvider.getInstance().getSelectService();
		List<Account> resp;
		
		
		
		
		try{
			
			resp = servProvider.getAccounts();
			request.setAttribute("getAccounts", resp);
			
			RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.ADMIN_LIST_ALL_ACCOUNTS);
			dispatcher.forward(request, response);
			
		}catch(ServiceException e){

			logger.error("GetAllAccounts exception from service =" + e);
		}
		
		
		
	}

}
