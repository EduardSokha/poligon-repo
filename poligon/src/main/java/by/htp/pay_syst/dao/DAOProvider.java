package by.htp.pay_syst.dao;

import by.htp.pay_syst.dao.impl.MySQLDAO;

public class DAOProvider {
private static final DAOProvider instance = new DAOProvider();
	
	private MySQLDAO paymentSystemDAO = new MySQLDAO();
	
	private DAOProvider() {		
	}
	
	public static DAOProvider getInstance() {		
		return instance;
	}

	public UserDAO getPaymentSystemUserDAO() {
		return paymentSystemDAO;
	}
	
	public AdminDAO getPaymentSystemAdminDAO() {
		return paymentSystemDAO;
	}
	

}
