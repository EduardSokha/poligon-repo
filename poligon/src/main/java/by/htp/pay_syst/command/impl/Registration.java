package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.RequestParameterName;
import by.htp.pay_syst.entity.RegistrationInfo;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class Registration implements Command {

	final static Logger logger = Logger.getLogger(Registration.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession(true);
		RegistrationInfo reg = new RegistrationInfo();

		String resp;

		reg.setLogin(request.getParameter(RequestParameterName.REQ_PARAM_REG_LOG));
		reg.setPassword(request.getParameter(RequestParameterName.REQ_PARAM_REG_PASS));
		reg.setName(request.getParameter(RequestParameterName.REQ_PARAM_REG_NAME));
		reg.setSurname(request.getParameter(RequestParameterName.REQ_PARAM_REG_SURNAME));
		reg.setAddress(request.getParameter(RequestParameterName.REQ_PARAM_REG_ADDRESS));
		reg.setSeriesNumberPassport(request.getParameter(RequestParameterName.REQ_PARAM_SERIES_NUMB_PASSPORT));
		reg.setIdentificNumberPassport(request.getParameter(RequestParameterName.REQ_PARAM_IDENTIF_NUMB_PASSPORT));
		reg.setCodeWord(request.getParameter(RequestParameterName.REQ_PARAM_CODE_WORD));
		reg.setPhoneNumber(request.getParameter(RequestParameterName.REQ_PARAM_PHONE_NUMBER));
		reg.setResidenceRegistr(request.getParameter(RequestParameterName.REQ_PARAM_RESIDENCE_REGISTR));

		resp = "error, try again";

		try {
			if (servProvider.registrationUser(reg)) {
				resp = "successfully registration";
			}

			session.setAttribute("registrationUser", resp);
			response.sendRedirect("controller?command=GO_TO_REGISTRATION");

		} catch (ServiceException e) {
			logger.error("Registration exception from service =" + e);

		}

	}

}
