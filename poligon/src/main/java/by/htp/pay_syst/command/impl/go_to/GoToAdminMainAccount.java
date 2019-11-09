package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;

public class GoToAdminMainAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);

		session.removeAttribute("getAccounts");
		session.removeAttribute("toUnlockAccount");
		session.removeAttribute("registrationAdmin");
		session.removeAttribute("toLockAccount");
		session.removeAttribute("deleteNameCard");
		session.removeAttribute("correctionSeriesNumberPassport");
		session.removeAttribute("correctIdentificNumbPassp");
		session.removeAttribute("addNewNameCard");
		session.removeAttribute("accountRefill");

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GO_TO_ADMIN_MAIN_ACCOUNT);
		dispatcher.forward(request, response);

	}

}
