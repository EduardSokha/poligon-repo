package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.RequestParameterName;
import by.htp.pay_syst.entity.PaymentParameters;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class Payment implements Command {

	final static Logger logger = Logger.getLogger(Payment.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();
		PaymentParameters paym = new PaymentParameters();

		String resp;
		User user;

		user = (User) session.getAttribute("user");
		paym.setPaymentAmount(Integer.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_AMOUNT)));
		paym.setIdAccount(Integer.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_ID_ACCOUNT)));
		paym.setIdUser(user.getId());
		paym.setIdAccountRecipient(Integer.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_RECIPIENT)));
		paym.setSender(request.getParameter(RequestParameterName.REQ_PARAM_ID_SENDER));

		try {
			resp = servProvider.payment(paym);
			session.setAttribute("payment", resp);
			response.sendRedirect("controller?command=GO_TO_PAYMENT");

		} catch (ServiceException e) {
			logger.error("Payment exception from service =" + e);

		}

	}

}
