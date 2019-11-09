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

public class ForgetPassword implements Command {

	final static Logger logger = Logger.getLogger(ForgetPassword.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		String resp;
		String identifNumbPassport;
		String seriesNumPassport;
		String codeword;

		identifNumbPassport = request.getParameter(RequestParameterName.REQ_PARAM_FORGET_PASSW_IDENTIC_NUMB_PASSPORT);
		seriesNumPassport = request.getParameter(RequestParameterName.REQ_PARAM_FORGET_PASSW_SERIES_NUMBER_PASSPORT);
		codeword = request.getParameter(RequestParameterName.REQ_PARAM_FORGET_PASSW_CODEWORD);

		try {
			resp = servProvider.forgetPassword(identifNumbPassport, codeword, seriesNumPassport);
			session.setAttribute("forgetPassword", resp);
			response.sendRedirect("controller?command=GO_TO_FORGET_PASSWORD");

		} catch (ServiceException e) {
			logger.error("ForgetPassword exception from service =" + e);
		}

	}

}
