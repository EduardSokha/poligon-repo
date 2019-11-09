package by.htp.pay_syst.command.impl.go_to;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.controller.JSPPageName;

public class GoToCorrectionPassword implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_CORRECTION_PASSWORD);
		dispatcher.forward(request, response);

	}

}
