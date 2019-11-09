package by.htp.pay_syst.controller;

public final class RequestParameterName {

	private RequestParameterName() {
	}

	// authorization

	public static final String REQ_PARAM_COMMAND_NAME = "command";
	public static final String REQ_PARAM_LOGIN = "login";
	public static final String REQ_PARAM_PASS = "pass";

	// payment

	public static final String REQ_PARAM_PAYMENT = "payment";
	public static final String REQ_PARAM_AMOUNT = "paymentAmount";
	public static final String REQ_PARAM_ID_ACCOUNT = "idaccount";
	public static final String REQ_PARAM_ID_USER = "iduser";
	public static final String REQ_PARAM_RECIPIENT = "idAccountRecipient";
	public static final String REQ_PARAM_ID_SENDER = "sender";

	// refill account

	public static final String REQ_PARAM_REFILL = "accountRefill";
	public static final String REQ_PARAM_REFILL_ID_CARD = "idCard";
	public static final String REQ_PARAM_REFILL_ID_AMOUNT = "amount";

	// registration

	public static final String REQ_PARAM_REG_LOG = "login";
	public static final String REQ_PARAM_REG_PASS = "pass";
	public static final String REQ_PARAM_REG_NAME = "name";
	public static final String REQ_PARAM_REG_SURNAME = "surname";
	public static final String REQ_PARAM_REG_ADDRESS = "address";
	public static final String REQ_PARAM_SERIES_NUMB_PASSPORT = "seriesNumberPassport";
	public static final String REQ_PARAM_IDENTIF_NUMB_PASSPORT = "identificNumberPassport";
	public static final String REQ_PARAM_CODE_WORD = "codeWord";
	public static final String REQ_PARAM_PHONE_NUMBER = "phoneNumber";
	public static final String REQ_PARAM_RESIDENCE_REGISTR = "residenceRegistr";

	// addCard

	public static final String REQ_PARAM_ADDCARD_LOGIN = "login";
	public static final String REQ_PARAM_ADDCARD_PASSW = "password";
	public static final String REQ_PARAM_ADDCARD_CURRENCY = "currency";
	public static final String REQ_PARAM_ADDCARD_PAYM_SYST_CARD = "paySystCard";
	public static final String REQ_PARAM_ADDCARD_NAME_CARD = "nameCard";

	// delete user

	public static final String REQ_PARAM_DELETE_USER_NAME = "name";
	public static final String REQ_PARAM_DELETE_USER_SURNAME = "surname";

	// registration_admin

	public static final String REQ_PARAM_REG_ADMIN_ID_USER = "idUser";
	public static final String REQ_PARAM_REG_ADMIN_ROLE = "role";

	// lock_account

	public static final String REQ_PARAM_LOCK_ACCOUNT_NAME = "name";
	public static final String REQ_PARAM_LOCK_ACCOUNT_SURNAME = "surname";
	public static final String REQ_PARAM_LOCK_ACCOUNT_IDACCOUNT = "idAccount";

	// unlock_account

	public static final String REQ_PARAM_UNLOCK_ACCOUNT_NAME = "name";
	public static final String REQ_PARAM_UNLOCK_ACCOUNT_SURNAME = "surname";
	public static final String REQ_PARAM_UNLOCK_ACCOUNT_IDACCOUNT = "idAccount";

	// correction_data

	public static final String REQ_PARAM_CORRECTION_DATA_LOGIN = "login";
	public static final String REQ_PARAM_CORRECTION_DATA_NAME = "name";
	public static final String REQ_PARAM_CORRECTION_DATA_SURNAME = "surname";
	public static final String REQ_PARAM_CORRECTION_DATA_ADDRESS = "address";
	public static final String REQ_PARAM_CORRECTION_DATA_CODEWORD = "codeword";
	public static final String REQ_PARAM_CORRECTION_DATA_PHONE_NUMBER = "phoneNumber";
	public static final String REQ_PARAM_CORRECTION_DATA_RESIDENCE_REGISTR = "residenceRegistr";

	// getAccountsAndCards

	public static final String REQ_PARAM_GET_ACCOUNTS_CARDS_IDUSER = "iduser";

	// correct login

	public static final String REQ_PARAM_CORRECT_LOGIN = "newLogin";

	// correct password

	public static final String REQ_PARAM_CORRECT_NEW_PASSW_1 = "newPassword1";
	public static final String REQ_PARAM_CORRECT_NEW_PASSW_2 = "newPassword2";
	public static final String REQ_PARAM_CORRECT_OLD_PASSW = "oldPassword";

	// correct name

	public static final String REQ_PARAM_CORRECT_NAME = "newName";

	// correct surname

	public static final String REQ_PARAM_CORRECT_SURNAME = "newSurname";

	// correctionAddress

	public static final String REQ_PARAM_CORRECT_ADDRESS = "newAddress";

	// correctionCodeWord

	public static final String REQ_PARAM_CORRECT_CODEWORD = "newCodeword";

	// correctionPhoneNumber

	public static final String REQ_PARAM_CORRECT_PHONE_NUMBER = "newPhoneNumber";

	// correctionResidenceRegistr

	public static final String REQ_PARAM_CORRECT_RESIDENCE_REGISTR = "newResidenceRegistr";

	// forgetPassword

	public static final String REQ_PARAM_FORGET_PASSW_IDENTIC_NUMB_PASSPORT = "identificNumberPassport";
	public static final String REQ_PARAM_FORGET_PASSW_SERIES_NUMBER_PASSPORT = "seriesNumberPassport";
	public static final String REQ_PARAM_FORGET_PASSW_CODEWORD = "codeword";

	// transferBetweenUsersCards

	public static final String REQ_PARAM_TRANSFER_BETWEEN_CARDS_CARD_FROM = "cardFrom";
	public static final String REQ_PARAM_TRANSFER_BETWEEN_CARDS_CARD_TO = "cardTo";
	public static final String REQ_PARAM_TRANSFER_BETWEEN_CARDS_AMOUNT = "amount";

	// correctionSeriesNumberPassport

	public static final String REQ_PARAM_CORRECT_SERIES_NUMB_PASSPORT = "newSeriesNumbPassport";
	public static final String REQ_PARAM_CORRECT_SERIES_NUMB_PASSPORT_ID_USER = "idUser";

	// correctionIdentificNumberPassport

	public static final String REQ_PARAM_CORRECT_IDENTIFIC_NUMB_PASSPORT = "newIdentificNumbPassport";
	public static final String REQ_PARAM_CORRECT_IDENTIFIC_NUMB_PASSPORT_ID_USER = "idUser";

	// addNewNameCard

	public static final String REQ_PARAM_NEW_NAME_CARD = "newNameCard";

	// deleteNameCard

	public static final String REQ_PARAM_DELETE_NAME_CARD = "idNameCard";

	// localization

	public static final String REQ_PARAM_LOCALIZATION = "local";
	public static final String REQ_PARAM_LOCALIZATION_PAGE_NAME = "page";

}
