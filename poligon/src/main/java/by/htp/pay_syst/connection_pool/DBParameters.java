package by.htp.pay_syst.connection_pool;



public final class DBParameters {
	
//	private static DBResourceManager dbManag;
	
	
	
	private DBParameters(){
//		dbManag = DBResourceManager.getInstance();
	}
	
	
	
	public static final String DB_DRIVER = "db.driver";
	public static final String DB_URL = "db.url";
	public static final String DB_USER = "db.user";
	public static final String DB_PASSWORD = "db.password";
	public static final String DB_SIZE = "db.poolSize";
	


}



//public static final String DB_URL = dbManag.getValue("db.url");
//public static final String DB_USER = dbManag.getValue("db.user");
//public static final String DB_PASSWORD = dbManag.getValue("db.password");
//public static final int DB_SIZE = Integer.parseInt (dbManag.getValue("db.poolSize"));
