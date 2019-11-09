package by.htp.pay_syst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import by.htp.pay_syst.connection_pool.ConnectionPool;
import by.htp.pay_syst.dao.DAOException;
import by.htp.pay_syst.dao.UserDAO;
import by.htp.pay_syst.entity.AddCardParameters;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.PaymentParameters;
import by.htp.pay_syst.entity.RegistrationInfo;
import by.htp.pay_syst.entity.User;

public class MySqlUserDao implements UserDAO {

	private final ConnectionPool cp = ConnectionPool.getInstance();
	final static Logger logger = Logger.getLogger(MySQLDAO.class);

	// USER

	@Override
	public String payment(PaymentParameters paym) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		Statement st = null;
		String resp;
		Date date = new Date();
		try {

			con = cp.getConnection();

			con.setAutoCommit(false);
			st = con.createStatement();

			String sq1 = "SELECT payment_system.account.balance FROM payment_system.users INNER JOIN payment_system.users_account ON payment_system.users.idusers = payment_system.users_account.users_idusers INNER JOIN payment_system.account ON payment_system.users_account.account_idaccount = payment_system.account.idaccount WHERE payment_system.account.idaccount = "
					+ paym.getIdAccount() + " and payment_system.users.idusers = " + paym.getIdUser();
			rs = st.executeQuery(sq1);
			rs.next();
			int balance = rs.getInt(1);
			int newBalance = balance - paym.getPaymentAmount();
			String price = "" + paym.getPaymentAmount();

			String sq2 = "UPDATE payment_system.account SET balance = " + newBalance + " WHERE idaccount = "
					+ paym.getIdAccount();
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

			String sq3 = "INSERT INTO payments(status, date, price, sender, users_idusers, recipient) VALUES(?,?,?,?,?,?)";
			ps2 = con.prepareStatement(sq3);

			ps2.setString(1, "approved");
			ps2.setString(2, date.toString());
			ps2.setString(3, price);
			ps2.setString(4, paym.getSender());
			ps2.setInt(5, paym.getIdUser());
			ps2.setInt(6, paym.getIdAccountRecipient());
			ps2.executeUpdate();

			resp = "status = approved, balace = " + newBalance;
			con.commit();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.fatal("RollbackRunTimeException DAO" + e1);
				throw new RuntimeException(e);
			}
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseStatement(ps2);
			cp.releaseDbResourses(con, ps);
		}
		return resp;

	}

	@Override
	public boolean registrationUser(RegistrationInfo registr) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = cp.getConnection();
			con.setAutoCommit(false);
			String sq1 = "INSERT INTO users(login, password, name, surname, address, role_idrole, series_number_passport, identification_number_passport, codeword, phone_number, residence_registr_data_passport) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sq1);

			ps.setString(1, registr.getLogin());
			ps.setString(2, registr.getPassword());
			ps.setString(3, registr.getName());
			ps.setString(4, registr.getSurname());
			ps.setString(5, registr.getAddress());
			ps.setInt(6, registr.getROLE());
			ps.setString(7, registr.getSeriesNumberPassport());
			ps.setString(8, registr.getIdentificNumberPassport());
			ps.setString(9, registr.getCodeWord());
			ps.setString(10, registr.getPhoneNumber());
			ps.setString(11, registr.getResidenceRegistr());
			ps.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.fatal("RollbackRunTimeException DAO" + e1);
				throw new RuntimeException(e1);
			}
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		return true;

	}

	@Override
	public User authorization(String login, String password) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		User user = new User();

		try {
			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT * FROM payment_system.users WHERE login = '" + login + "' and  password = '" + password
					+ "'";
			rs = st.executeQuery(sq1);
			if (!rs.next()) {
				return null;
			}

			user.setId(rs.getInt(1));
			user.setLogin(rs.getString(2));
			user.setName(rs.getString(4));
			user.setSurname(rs.getString(5));
			user.setAddress(rs.getString(6));
			user.setRole(rs.getInt(7));
			user.setSeriesNumberPassport(rs.getString(8));
			user.setIdentificNumberPassport(rs.getString(9));
			user.setCodeWord(rs.getString(10));
			user.setPhoneNumber(rs.getString(11));
			user.setResidenceRegistr(rs.getString(12));

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return user;
	}

	@Override
	public String addCard(AddCardParameters param) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		Statement st = null;
		String resp = null;

		try {

			con = cp.getConnection();
			st = con.createStatement();
			con.setAutoCommit(false);

			String sq1 = "INSERT INTO account(balance, creation_date, status, currency_idcurrency) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sq1);
			ps.setInt(1, param.getBalance());
			ps.setString(2, param.getCreationDate());
			ps.setString(3, param.getStatus());
			ps.setInt(4, param.getCurrency());
			ps.executeUpdate();

			rs = st.executeQuery("SELECT * FROM account WHERE idaccount = LAST_INSERT_ID()");
			rs.next();
			int accountNumber = rs.getInt(1);
			cp.releaseResultSet(rs);

			String sq2 = "INSERT INTO card(creation_date, status, account_idaccount, payment_system_card_idpayment_system_card, name_card_idname_card) VALUES(?,?,?,?,?)";
			ps2 = con.prepareStatement(sq2);
			ps2.setString(1, param.getCreationDate());
			ps2.setString(2, param.getStatus());
			ps2.setInt(3, accountNumber);
			ps2.setInt(4, param.getPaySystCard());
			ps2.setInt(5, param.getNameCard());
			ps2.executeUpdate();

			rs = st.executeQuery("SELECT * FROM card WHERE idcard = LAST_INSERT_ID()");
			rs.next();
			int idCard = rs.getInt(1);

			String sq4 = "INSERT INTO users_account(users_idusers, account_idaccount) VALUES(?,?)";
			ps3 = con.prepareStatement(sq4);

			ps3.setInt(1, param.getIdUser());
			ps3.setInt(2, accountNumber);
			ps3.executeUpdate();

			resp = "successfully, your balance = " + param.getBalance() + "; id new Card = " + idCard
					+ "; id new account = " + accountNumber;
			con.commit();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.fatal("RollbackRunTimeException DAO" + e1);
				throw new RuntimeException(e1);
			}
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(ps2);
			cp.releaseStatement(ps3);
			cp.releaseDbResourses(con, ps);
		}

		return resp;
	}

	@Override
	public String correctionData(User user) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = null;

		try {
			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET login = '" + user.getLogin() + "', name = '" + user.getName()
					+ "', surname = '" + user.getSurname() + "', address = '" + user.getAddress() + "', role_idrole = "
					+ user.getRole() + " WHERE idusers = " + user.getId();
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}

		resp = "your data successfully saved";
		return resp;
	}

	@Override
	public List<ListAccountsAndCards> getAccountsAndCards(int idUser) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		List<ListAccountsAndCards> accaunts = new ArrayList<ListAccountsAndCards>();

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT payment_system.account.idaccount, payment_system.account.balance, payment_system.account.status, payment_system.account.creation_date, payment_system.currency.name_currency, payment_system.card.idcard, payment_system.payment_system_card.type_paym_syst_card, payment_system.name_card.name_card FROM payment_system.users_account INNER JOIN payment_system.account ON payment_system.users_account.account_idaccount = payment_system.account.idaccount INNER JOIN payment_system.currency ON payment_system.account.currency_idcurrency = payment_system.currency.idcurrency INNER JOIN payment_system.card ON  payment_system.account.idaccount = payment_system.card.account_idaccount INNER JOIN payment_system.payment_system_card ON payment_system.card.payment_system_card_idpayment_system_card = payment_system.payment_system_card.idpayment_system_card INNER JOIN payment_system.name_card ON  payment_system.card.name_card_idname_card = payment_system.name_card.idname_card WHERE payment_system.users_account.users_idusers = "
					+ idUser + " ORDER BY payment_system.card.idcard";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return null;
			}

			rs.beforeFirst();

			while (rs.next()) {
				ListAccountsAndCards getAccount = new ListAccountsAndCards();
				getAccount.setIdAccount(rs.getInt(1));
				getAccount.setBalance(rs.getInt(2));
				getAccount.setStatusAccount(rs.getString(3));
				getAccount.setCreationDateAccount(rs.getString(4));
				getAccount.setCurrency(rs.getString(5));
				getAccount.setIdCard(rs.getInt(6));
				getAccount.setTypePaySyst(rs.getString(7));
				getAccount.setNameCard(rs.getString(8));

				accaunts.add(getAccount);

			}

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return accaunts;
	}

	@Override
	public String correctionLogin(String login, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET login = '" + login + "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String correctionPassword(String newPassword, String oldPassw, int idUser) throws DAOException {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps = null;
		Statement st = null;
		String resp = "";

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT payment_system.users.password FROM payment_system.users WHERE idusers = " + idUser;
			rs = st.executeQuery(sq1);
			rs.next();
			String oldPassword = rs.getString(1);

			if (oldPassword.equals(oldPassw)) {

				String sq2 = "UPDATE payment_system.users SET password = '" + newPassword + "' WHERE idusers = "
						+ idUser;
				ps = con.prepareStatement(sq2);
				ps.executeUpdate();

				resp = "successful";
			} else {
				resp = "old password incorrect, try again";
			}

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return resp;
	}

	@Override
	public String correctionName(String name, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET name = '" + name + "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String correctionSurname(String surname, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET surname = '" + surname + "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String correctionAddress(String address, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET address = '" + address + "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";
		return resp;
	}

	@Override
	public String correctionCodeWord(String codeword, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET codeword = '" + codeword + "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String correctionPhoneNumber(String phoneNumber, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET phone_number = '" + phoneNumber + "' WHERE idusers = "
					+ idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String correctionResidenceRegistr(String residenceRegistr, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET residence_registr_data_passport = '" + residenceRegistr
					+ "' WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}
		resp = "successful";

		return resp;
	}

	@Override
	public String forgetPassword(String identificNumberPassport, String codeWord, String seriesNumberPassport)
			throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		String resp = "";
		String password;

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT password FROM payment_system.users WHERE identification_number_passport = '"
					+ identificNumberPassport + "' AND codeword = '" + codeWord + "' AND series_number_passport = '"
					+ seriesNumberPassport + "'";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return "try again";
			}

			rs.beforeFirst();

			rs.next();
			password = rs.getString(1);

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {

			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}
		resp = "your password = " + password;

		return resp;
	}

	@Override
	public String transferBetweenUsersCards(int idCardFrom, int idCardTo, int amount, int idUser) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		Statement st = null;
		String resp;

		try {

			con = cp.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();

			String sq1 = "SELECT payment_system.account.balance, payment_system.account.idaccount FROM payment_system.card INNER JOIN payment_system.account ON payment_system.card.account_idaccount = payment_system.account.idaccount WHERE idcard = "
					+ idCardFrom;
			rs = st.executeQuery(sq1);
			rs.next();
			int balanceCardFrom = rs.getInt(1);
			int idaccountCardFrom = rs.getInt(2);
			int newBalanceCardFrom = balanceCardFrom - amount;
			cp.releaseResultSet(rs);

			String sq2 = "SELECT payment_system.account.balance, payment_system.account.idaccount FROM payment_system.card INNER JOIN payment_system.account ON payment_system.card.account_idaccount = payment_system.account.idaccount WHERE idcard = "
					+ idCardTo;
			rs = st.executeQuery(sq2);
			rs.next();
			int balanceCardTo = rs.getInt(1);
			int idaccountCardTo = rs.getInt(2);
			int newBalanceCardTo = balanceCardTo + amount;

			String sq3 = "UPDATE payment_system.account SET balance=" + newBalanceCardFrom + " WHERE idaccount="
					+ idaccountCardFrom;
			ps = con.prepareStatement(sq3);
			ps.executeUpdate();

			String sq4 = "UPDATE payment_system.account SET balance=" + newBalanceCardTo + " WHERE idaccount="
					+ idaccountCardTo;
			ps2 = con.prepareStatement(sq4);
			ps2.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.fatal("RollbackRunTimeException DAO" + e1);
				throw new RuntimeException(e1);
			}
			throw new DAOException(e);
		} finally {

			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseStatement(ps2);
			cp.releaseDbResourses(con, ps);
		}

		resp = "successful";

		return resp;
	}

}
