package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;
import by.htp.pay_syst.entity.User;

public class GoToMainAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		session.removeAttribute("correctionPhoneNumber");
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

		if (session != null && user != null) {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GO_TO_MAIN_ACCOUNT);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GO_TO_MAIN);
			dispatcher.forward(request, response);

		}

	}

}
