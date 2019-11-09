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

public class AddNewNameCard implements Command {

	final static Logger logger = Logger.getLogger(AddNewNameCard.class);

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
		session.removeAttribute("correctIdentificNumbPassp");
		session.removeAttribute("accountRefill");

		String newNameCard;
		String resp;

		newNameCard = request.getParameter(RequestParameterName.REQ_PARAM_NEW_NAME_CARD);

		try {
			resp = servProvider.addNewNameCard(newNameCard);
			session.setAttribute("addNewNameCard", resp);
			response.sendRedirect("controller?command=GET_ALL_NAME_CARD");

		} catch (ServiceException e) {
			logger.error("AddNewNameCard exception =" + e);
		}

	}

}
