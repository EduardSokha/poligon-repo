package by.htp.pay_syst.dao;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = -6915707023072963723L;
	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
