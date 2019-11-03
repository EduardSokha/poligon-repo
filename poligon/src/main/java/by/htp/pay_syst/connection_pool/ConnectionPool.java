package by.htp.pay_syst.connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	private int size;
	
	private static final ConnectionPool instance = new ConnectionPool();
	private BlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(5);

	public ConnectionPool() {
		DBResourceManager db = DBResourceManager.getInstance();
		driver = db.getValue(DBParameters.DB_DRIVER); 
		url = db.getValue(DBParameters.DB_URL);
		user = db.getValue(DBParameters.DB_USER);
		password = db.getValue(DBParameters.DB_PASSWORD);
		size = Integer.parseInt(db.getValue(DBParameters.DB_SIZE));
		
		
		try {
			
			

			Class.forName(driver);
			for (int i = 0; i < size; i++) {
				Connection coni = DriverManager.getConnection(url, user, password);
				
				connections.add(coni);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
//			System.err.println();
//			System.out.println("dssdf");
		}
	}

	public Connection take() throws InterruptedException {

		return connections.take();
	}

	public void release(Connection con) {

		try {
			if (con != null) {
				con.setAutoCommit(true);
				connections.add(con);
			} else {
				// log
			}
		} catch (SQLException e) {
			System.err.println();
		}

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

}

//public Connection take() throws DAOException {
//
//	Connection con = null;
//	try {
//		con = connections.take();
//	} catch (InterruptedException e) {
//		throw new DAOException("");
//	}
//	
//	return con;
//} старый тэйк до исправления
