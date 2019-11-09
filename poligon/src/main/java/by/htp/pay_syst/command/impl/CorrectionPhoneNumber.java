package by.htp.pay_syst.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.RequestParameterName;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class CorrectionPhoneNumber implements Command {

	final static Logger logger = Logger.getLogger(CorrectionPhoneNumber.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		session.removeAttribute("correctionPassword");
		session.removeAttribute("correctionName");
		session.removeAttribute("correctionLogin");
		session.removeAttribute("correctionCodeWord");
		session.removeAttribute("correctionAddress");
		session.removeAttribute("addCard");
		session.removeAttribute("correctionResidenceRegistr");
		session.removeAttribute("correctionSurname");
		session.removeAttribute("getAccountsAndCards");
		session.removeAttribute("payment");
		session.removeAttribute("transferBetweenUsersCards");

		User user;
		String resp;
		String newPhoneNumber;
		int idUser;

		user = (User) session.getAttribute("user");
		idUser = user.getId();
		newPhoneNumber = request.getParameter(RequestParameterName.REQ_PARAM_CORRECT_PHONE_NUMBER);

		try {
			resp = servProvider.correctionPhoneNumber(newPhoneNumber, idUser);
			session.setAttribute("correctionPhoneNumber", resp);
			response.sendRedirect("controller?command=GO_TO_CORRECT_DATA");

		} catch (ServiceException e) {
			logger.error("CorrectionPhoneNumber exception from service =" + e);
		}

	}

}
