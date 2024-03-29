package by.htp.pay_syst.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.command.CommandProvider;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final CommandProvider provider = CommandProvider.getInstance();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String requestURI = request.getRequestURI();
		// StringBuffer requestURL = request.getRequestURL();
		String commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
		Command command = provider.getCommand(commandName);
		command.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String requestURI = request.getRequestURI();
		// StringBuffer requestURL = request.getRequestURL();
		//
		// String contextPath = request.getServletContext().getContextPath();
		//
		// String commandUri = requestURI.replaceAll(contextPath, "");

		String commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}

}
