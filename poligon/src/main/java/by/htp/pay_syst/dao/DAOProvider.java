package by.htp.pay_syst.dao;

import by.htp.pay_syst.dao.impl.MySqlAdminDao;
import by.htp.pay_syst.dao.impl.MySqlUserDao;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private MySqlUserDao mySQLUserDAO = new MySqlUserDao();
	private MySqlAdminDao mySQLAdminDAO = new MySqlAdminDao();
	// private MySQLDAO paymentSystemDAO = new MySQLDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getPaymentSystemUserDAO() {
		return mySQLUserDAO;
	}

	public AdminDAO getPaymentSystemAdminDAO() {
		return mySQLAdminDAO;
	}

}
