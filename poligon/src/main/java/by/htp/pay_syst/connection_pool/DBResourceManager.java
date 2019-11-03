package by.htp.pay_syst.connection_pool;

import java.util.ResourceBundle;



public class DBResourceManager {
	private final static DBResourceManager instance = new DBResourceManager();

	private String s = "resources.db";
	private ResourceBundle bundle = ResourceBundle.getBundle(s);
	
	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key) {
		return bundle.getString(key);
	}
	
	
}



//Locale locale = Locale.ENGLISH;
//private String d = "db.properties";
//private String s1 = "resources.db";


