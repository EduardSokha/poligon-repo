package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.RequestParameterName;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class LockAccount implements Command {

	final static Logger logger = Logger.getLogger(LockAccount.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		int idAccount;
		boolean resp1;
		String resp2;

		resp2 = "error, try again";
		idAccount = Integer.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_LOCK_ACCOUNT_IDACCOUNT));

		try {
			resp1 = servProvider.toLockAccount(idAccount);
			if (resp1) {
				resp2 = "account successfully locked";
			}

			session.setAttribute("toLockAccount", resp2);
			response.sendRedirect("controller?command=GO_TO_LOCK_ACCOUNT");

		} catch (ServiceException e) {
			logger.error("LockAccount exception from service =" + e);

		}

	}

}
