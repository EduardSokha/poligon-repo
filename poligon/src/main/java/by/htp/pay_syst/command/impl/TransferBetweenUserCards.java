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

public class TransferBetweenUserCards implements Command {
	final static Logger logger = Logger.getLogger(TransferBetweenUserCards.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Service servProvider = ServiceProvider.getInstance().getSelectService();
		HttpSession session = request.getSession();
		
		
		User user;		
		String resp;
		int idUser;
		int cardFrom;
		int cardTo;
		int amount;
		
		user = (User)session.getAttribute("user");
		idUser = user.getId();		
		cardFrom = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_TRANSFER_BETWEEN_CARDS_CARD_FROM));
		cardTo = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_TRANSFER_BETWEEN_CARDS_CARD_TO));
		amount = Integer.parseInt (request.getParameter(RequestParameterName.REQ_PARAM_TRANSFER_BETWEEN_CARDS_AMOUNT));
		
		
		try{
			resp = servProvider.transferBetweenUsersCards(cardFrom, cardTo, amount, idUser);
			session.setAttribute("transferBetweenUsersCards", resp);
			response.sendRedirect("http://localhost:8080/Poligon/controller?command=GO_TO_TRANSFER_BETWEEN_CARDS");
			
			
//			request.setAttribute("resp2", resp);			
//			RequestDispatcher dispatcher= request.getRequestDispatcher(JSPPageName.ADMIN_GET_NAME_CARDS);
//			dispatcher.forward(request, response);
			
			
		}catch(ServiceException e){

			logger.error("TransferBetweenUserCards exception from service =" + e);
		}
		
		
	}

}
