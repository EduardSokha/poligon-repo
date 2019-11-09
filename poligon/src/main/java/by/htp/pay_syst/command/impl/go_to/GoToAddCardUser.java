package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.command.impl.GetAccountsAndCards;
import by.htp.pay_syst.controller.JSPPageName;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;

public class GoToAddCardUser implements Command {

	final static Logger logger = Logger.getLogger(GetAccountsAndCards.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();

		User user;
		List<ListAccountsAndCards> resp;
		int idUser;

		user = (User) session.getAttribute("user");
		idUser = user.getId();

		try {
			resp = servProvider.getAccountsAndCards(idUser);
			request.setAttribute("getAccountsAndCards", resp);

			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_ADDCARD_PAGE);
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			logger.error("GetAccountsAndCards exception from service =" + e);
		}

	}

}
