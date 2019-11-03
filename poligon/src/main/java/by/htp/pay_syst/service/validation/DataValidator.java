package by.htp.pay_syst.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.pay_syst.entity.RegistrationInfo;


public class DataValidator {
	private static final DataValidator instance = new DataValidator();
	DBResourseRegularExpression instanceDB = new DBResourseRegularExpression();
	private DataValidator(){}
	
	
	public boolean phoneNumberValidate (String phoneNumber){
		
		
		String input = instanceDB.getValue(DBParamemetersValidation.DB_PHONE_NUMBER);
		
		Pattern patter = Pattern.compile(phoneNumber);
		
		Matcher matcher = patter.matcher(input);
		
		if(!matcher.find()) {
		
			return false;
		}
		
		
		return true;
	}
	
	
	
	public boolean onlyNumbers(String number){
		
		String input = instanceDB.getValue(DBParamemetersValidation.DB_ONLY_NUMBER);
		
		Pattern patter = Pattern.compile(number);
		
		Matcher matcher = patter.matcher(input);
		
		if(!matcher.find()) {
		
			return false;
		}
		
		
		return true;
	}
	
	
	public boolean onlyLetters (String word) {

		String input = instanceDB.getValue(DBParamemetersValidation.DB_ONLY_LETTERS);

		Pattern patter = Pattern.compile(word);

		Matcher matcher = patter.matcher(input);

		if (!matcher.find()) {

			return false;
		}

		return true;
	}
	
	
	public boolean withoutSpacing (String word) {

		String input = instanceDB.getValue(DBParamemetersValidation.DB_WITHOUT_SPACING);

		Pattern patter = Pattern.compile(word);

		Matcher matcher = patter.matcher(input);

		if (!matcher.find()) {

			return false;
		}

		return true;
	}

	

	public static DataValidator getInstance() {
		return instance;
	}
	
	

}
