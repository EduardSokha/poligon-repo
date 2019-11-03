package by.htp.pay_syst.controller;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


public class ProjectRequestListner implements ServletRequestListener {

	final static Logger logger = Logger.getLogger(ProjectRequestListner.class.getName());
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		
		HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
		logger.info("Request from " + request.getContextPath() + "was destroyed.");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		
		HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
		logger.info("Request from " + request.getContextPath() + "was created.");
		
	}

}
