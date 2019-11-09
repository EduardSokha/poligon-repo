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

public class DeleteNameCard implements Command {

	final static Logger logger = Logger.getLogger(DeleteNameCard.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		session.removeAttribute("getAccounts");
		session.removeAttribute("toUnlockAccount");
		session.removeAttribute("registrationAdmin");
		session.removeAttribute("toLockAccount");
		session.removeAttribute("correctionSeriesNumberPassport");
		session.removeAttribute("correctIdentificNumbPassp");
		session.removeAttribute("addNewNameCard");
		session.removeAttribute("accountRefill");

		String resp;
		int idNameCard;

		idNameCard = Integer.parseInt(request.getParameter(RequestParameterName.REQ_PARAM_DELETE_NAME_CARD));

		try {
			resp = servProvider.deleteNameCard(idNameCard);
			session.setAttribute("deleteNameCard", resp);
			response.sendRedirect("controller?command=GET_ALL_NAME_CARD");

		} catch (ServiceException e) {
			logger.error("DeleteNameCard exception from service =" + e);
		}

	}

}
