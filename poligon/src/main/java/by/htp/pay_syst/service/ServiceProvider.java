package by.htp.pay_syst.service;

import by.htp.pay_syst.service.impl.ServiceImpl;

public class ServiceProvider {
	
private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private Service selectService = new ServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public Service getSelectService() {
		return selectService;
	}

}
