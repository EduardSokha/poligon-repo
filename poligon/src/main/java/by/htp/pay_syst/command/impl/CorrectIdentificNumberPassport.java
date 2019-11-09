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

public class CorrectIdentificNumberPassport implements Command {

	final static Logger logger = Logger.getLogger(CorrectIdentificNumberPassport.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		Service servProvider = ServiceProvider.getInstance().getSelectService();

		session.removeAttribute("getAccounts");
		session.removeAttribute("toUnlockAccount");
		session.removeAttribute("registrationAdmin");
		session.removeAttribute("toLockAccount");
		session.removeAttribute("deleteNameCard");
		session.removeAttribute("correctionSeriesNumberPassport");
		session.removeAttribute("addNewNameCard");
		session.removeAttribute("accountRefill");

		String newIdentificNumbPassport;
		String resp;
		int idUser;

		newIdentificNumbPassport = request.getParameter(RequestParameterName.REQ_PARAM_CORRECT_IDENTIFIC_NUMB_PASSPORT);
		idUser = Integer
				.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_CORRECT_IDENTIFIC_NUMB_PASSPORT_ID_USER));

		try {
			resp = servProvider.correctionIdentificNumberPassport(newIdentificNumbPassport, idUser);
			session.setAttribute("correctIdentificNumbPassp", resp);
			response.sendRedirect("controller?command=GO_TO_ADMIN_CORRECTION_DATA");

		} catch (ServiceException e) {
			logger.error("CorrectIdentificNumberPassport exception from service =" + e);
		}

	}

}
