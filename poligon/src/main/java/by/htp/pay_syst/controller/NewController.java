package by.htp.pay_syst.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.pay_syst.command.Command;
import by.htp.pay_syst.command.CommandProvider;

public class NewController {
	private static final long serialVersionUID = 1L;
	private static final CommandProvider provider = CommandProvider.getInstance();

	public NewController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		String commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
		// System.out.println("���������� commandName = " +
		// commandName);
		Command command = provider.getCommand(commandName);
		command.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();

		String contextPath = request.getServletContext().getContextPath();

		String commandUri = requestURI.replaceAll(contextPath, "");

		String commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
		Command command = provider.getCommand(commandName);
		// String page = null;
		// try{
		command.execute(request, response);
		// }catch(CommandExeption e){
		//
		// }catch

		// doGet(request, respons e);
	}
}
