package by.htp.pay_syst.service.validation;

import java.util.ResourceBundle;

public class DBResourseRegularExpression {

	private final static DBResourseRegularExpression instance = new DBResourseRegularExpression();

	private String s = "resources.db";
	private ResourceBundle bundle = ResourceBundle.getBundle(s);

	public static DBResourseRegularExpression getInstance() {
		return instance;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}

}
