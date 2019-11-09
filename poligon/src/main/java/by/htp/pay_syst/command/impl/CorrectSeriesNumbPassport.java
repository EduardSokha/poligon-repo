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

public class CorrectSeriesNumbPassport implements Command {

	final static Logger logger = Logger.getLogger(CorrectSeriesNumbPassport.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		session.removeAttribute("getAccounts");
		session.removeAttribute("toUnlockAccount");
		session.removeAttribute("registrationAdmin");
		session.removeAttribute("toLockAccount");
		session.removeAttribute("deleteNameCard");
		session.removeAttribute("correctIdentificNumbPassp");
		session.removeAttribute("addNewNameCard");
		session.removeAttribute("accountRefill");

		String newSeriesNumbPassport;
		String resp;
		int idUser;

		newSeriesNumbPassport = request.getParameter(RequestParameterName.REQ_PARAM_CORRECT_SERIES_NUMB_PASSPORT);
		idUser = Integer
				.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_CORRECT_SERIES_NUMB_PASSPORT_ID_USER));

		try {
			resp = servProvider.correctionSeriesNumberPassport(newSeriesNumbPassport, idUser);
			session.setAttribute("correctionSeriesNumberPassport", resp);
			response.sendRedirect("controller?command=GO_TO_ADMIN_CORRECTION_DATA");

		} catch (ServiceException e) {
			logger.error("CorrectSeriesNumbPassport exception from service =" + e);
		}

	}

}
