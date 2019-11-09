package by.htp.pay_syst.dao;

public class InsertsToSQL {
	private InsertsToSQL() {
	}

	// public static final String REGISTR_ADMIN = "UPDATE payment_system.users
	// SET role_idrole = " + role + " WHERE idusers = " + idUser;
	// public static final String LOCK_ACCOUNT = "UPDATE payment_system.account
	// SET status = \"locked\" WHERE idaccount = " + idaccount;
	// public static final String LOCK_CARD = "UPDATE payment_system.card SET
	// status = \"locked\" WHERE account_idaccount = " + idaccount;
	// public static final String DELETE_USER = "db.password";
	// public static final String UNLOCK_ACCOUNT = "UPDATE
	// payment_system.account SET status = \"unlocked\" WHERE idaccount = " +
	// idaccount;
	// public static final String UNLOCK_CARD = "UPDATE payment_system.card SET
	// status = \"unlocked\" WHERE account_idaccount = " + idaccount;
	// //payment
	// public static final String GET_BALANCE_USER = "SELECT
	// payment_system.account.balance FROM payment_system.users INNER JOIN
	// payment_system.users_account ON payment_system.users.idusers =
	// payment_system.users_account.users_idusers INNER JOIN
	// payment_system.account ON payment_system.users_account.account_idaccount
	// = payment_system.account.idaccount WHERE payment_system.account.idaccount
	// = " + paym.getIdaccount() + " and payment_system.users.idusers = " +
	// paym.getIduser();
	// public static final String INSERT_BALANCE_AFTER_PAYMENT = "UPDATE
	// payment_system.account SET balance = " + newBalance + " WHERE idaccount =
	// " + paym.getIdaccount();
	// public static final String INSERT_DATA_FOR_PAY = "INSERT INTO
	// payments(status, date, price, sender, users_idusers, recipient)
	// VALUES(?,?,?,?,?,?)";
	// //accountRefill
	// public static final String GET_BALANCE_ACCONT = "SELECT
	// payment_system.account.balance, payment_system.account.idaccount FROM
	// payment_system.card INNER JOIN payment_system.account ON
	// payment_system.card.account_idaccount = payment_system.account.idaccount
	// WHERE idcard = " + idCard;
	// public static final String BALANCE_AFTER_REFILL = "UPDATE
	// payment_system.account SET balance=" + sum + " WHERE idaccount=" +
	// idaccount;
	// //registration
	// public static final String INSERT_DATA_USER = "INSERT INTO users(login,
	// password, name, surname, address, role_idrole) VALUES(?,?,?,?,?,?)";
	// //authorization
	// public static final String AUTHORIZATION = "SELECT * FROM
	// payment_system.users WHERE login = '" + login + "' and password = '" +
	// password + "'";
	// public static final String ADD_CARD = "db.poolSize";
	// public static final String CORRECTION_DATA_USER = "db.poolSize";
	//
	//
	//
	// public static final String DB_SIZE = "db.poolSize";

}
