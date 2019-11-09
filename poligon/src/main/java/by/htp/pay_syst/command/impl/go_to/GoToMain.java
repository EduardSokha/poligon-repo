package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;

public class GoToMain implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GO_TO_MAIN);
		dispatcher.forward(request, response);

	}

}
