package by.htp.pay_syst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.htp.pay_syst.connection_pool.ConnectionPool;
import by.htp.pay_syst.dao.AdminDAO;
import by.htp.pay_syst.dao.DAOException;
import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.NameCard;
import by.htp.pay_syst.entity.User;

public class MySqlAdminDao implements AdminDAO {

	private final ConnectionPool cp = ConnectionPool.getInstance();
	final static Logger logger = Logger.getLogger(MySQLDAO.class);

	// ADMIN

	@Override
	public boolean registrationAdmin(int idUser, int role) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET role_idrole = " + role + " WHERE idusers = " + idUser;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseDbResourses(con, ps);
		}

		return true;

	}

	@Override
	public boolean toLockAccount(int idAccount) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {

			con = cp.getConnection();
			con.setAutoCommit(false);

			String sq2 = "UPDATE payment_system.account SET status = \"locked\" WHERE idaccount = " + idAccount;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

			String sq3 = "UPDATE payment_system.card SET status = \"locked\" WHERE account_idaccount = " + idAccount;
			ps1 = con.prepareStatement(sq3);
			ps1.executeUpdate();

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
			cp.releaseStatement(ps1);
			cp.releaseStatement(ps);
			cp.releaseConnection(con);
		}

		return true;
	}

	@Override
	public String deleteUser(User user) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp;

		try {
			con = cp.getConnection();
			con.setAutoCommit(false);

			String sq1 = "DELETE FROM users WHERE idusers = " + user.getId();
			ps = con.prepareStatement(sq1);

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
			;
		}
		resp = "delete ";
		return resp;
	}

	@Override
	public boolean toUnlockAccount(int idAccount) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		try {

			con = cp.getConnection();
			con.setAutoCommit(false);

			String sq2 = "UPDATE payment_system.account SET status = \"unlocked\" WHERE idaccount = " + idAccount;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();

			String sq3 = "UPDATE payment_system.card SET status = \"unlocked\" WHERE account_idaccount = " + idAccount;
			ps1 = con.prepareStatement(sq3);
			ps1.executeUpdate();

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
			cp.releaseStatement(ps);
			cp.releaseDbResourses(con, ps1);
		}

		return true;
	}

	@Override
	public String accountRefill(int idCard, int amount) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		String resp;
		try {

			con = cp.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();

			String sq1 = "SELECT payment_system.account.balance, payment_system.account.idaccount FROM payment_system.card INNER JOIN payment_system.account ON payment_system.card.account_idaccount = payment_system.account.idaccount WHERE idcard = "
					+ idCard;
			rs = st.executeQuery(sq1);
			rs.next();
			int balance = rs.getInt(1);
			int idaccount = rs.getInt(2);
			int sum = balance + amount;

			String sq2 = "UPDATE payment_system.account SET balance=" + sum + " WHERE idaccount=" + idaccount;
			ps = con.prepareStatement(sq2);
			ps.executeUpdate();
			resp = "status = approved, balace = " + sum;
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
			cp.releaseDbResourses(con, ps);
		}
		return resp;

	}

	@Override
	public String correctionSeriesNumberPassport(String newSeriesNumbPassport, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET series_number_passport = '" + newSeriesNumbPassport
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
	public String correctionIdentificNumberPassport(String newIdentificNumbPassport, int idUser) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {
			con = cp.getConnection();

			String sq2 = "UPDATE payment_system.users SET identification_number_passport = '" + newIdentificNumbPassport
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
	public List<Account> getAccounts() throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;

		List<Account> accounts = new ArrayList<Account>();
		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT payment_system.account.idaccount, payment_system.account.balance, payment_system.account.creation_date, payment_system.account.status, payment_system.currency.name_currency FROM payment_system.account INNER JOIN payment_system.currency ON payment_system.account.currency_idcurrency = payment_system.currency.idcurrency";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return null;
			}

			rs.beforeFirst();

			while (rs.next()) {

				Account account = new Account();

				account.setIdAccount(rs.getInt(1));
				account.setBalance(rs.getInt(2));
				account.setCreationDate(rs.getString(3));
				account.setStatus(rs.getString(4));
				account.setCurrency(rs.getString(5));

				accounts.add(account);

			}
		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return accounts;
	}

	@Override
	public List<Card> getCards() throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;

		List<Card> cards = new ArrayList<Card>();

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT payment_system.card.idcard, payment_system.card.creation_date, payment_system.card.status, payment_system.card.account_idaccount, payment_system.payment_system_card.type_paym_syst_card, payment_system.name_card.name_card FROM payment_system.card INNER JOIN payment_system.payment_system_card ON payment_system.card.payment_system_card_idpayment_system_card = payment_system.payment_system_card.idpayment_system_card INNER JOIN payment_system.name_card ON payment_system.card.name_card_idname_card = payment_system.name_card.idname_card";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return null;
			}

			rs.beforeFirst();

			while (rs.next()) {

				Card card = new Card();

				card.setIdCard(rs.getInt(1));
				card.setCreationDate(rs.getString(2));
				card.setStatus(rs.getString(3));
				card.setIdAccount(rs.getInt(4));
				card.setTypePaymSystCard(rs.getString(5));
				card.setNameCard(rs.getString(6));

				cards.add(card);

			}

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return cards;
	}

	@Override
	public List<User> getUsers() throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		List<User> users = new ArrayList<User>();

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT payment_system.users.idusers, payment_system.users.login, payment_system.users.password, payment_system.users.name, payment_system.users.surname, payment_system.users.address, payment_system.role.title, payment_system.users.series_number_passport, payment_system.users.identification_number_passport, payment_system.users.codeword, payment_system.users.phone_number, payment_system.users.residence_registr_data_passport FROM payment_system.users INNER JOIN payment_system.role ON payment_system.users.role_idrole = payment_system.role.idrole";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return null;
			}

			rs.beforeFirst();

			while (rs.next()) {

				User user = new User();

				user.setId(rs.getInt(1));
				user.setLogin(rs.getString(2));
				user.setName(rs.getString(4));
				user.setSurname(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setRoleStr(rs.getString(7));
				user.setSeriesNumberPassport(rs.getString(8));
				user.setIdentificNumberPassport(rs.getString(9));
				user.setCodeWord(rs.getString(10));
				user.setPhoneNumber(rs.getString(11));
				user.setResidenceRegistr(rs.getString(12));

				users.add(user);

			}

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return users;
	}

	@Override
	public String addNewNameCard(String newName) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq1 = "INSERT INTO name_card(name_card) VALUES(?)";
			ps = con.prepareStatement(sq1);

			ps.setString(1, newName);
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
	public String deleteNameCard(int idNameCard) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		String resp = "try again";

		try {

			con = cp.getConnection();

			String sq1 = "DELETE FROM payment_system.name_card WHERE idname_card = " + idNameCard;
			ps = con.prepareStatement(sq1);
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
	public List<NameCard> getAllNameCard() throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement st = null;
		List<NameCard> namesCards = new ArrayList<NameCard>();

		try {

			con = cp.getConnection();
			st = con.createStatement();

			String sq1 = "SELECT * FROM payment_system.name_card";
			rs = st.executeQuery(sq1);

			if (!rs.next()) {
				return null;
			}

			rs.beforeFirst();

			while (rs.next()) {

				NameCard nameCard = new NameCard();

				nameCard.setIdNameCard(rs.getInt(1));
				nameCard.setNameCard(rs.getString(2));

				namesCards.add(nameCard);

			}

		} catch (SQLException e) {
			logger.debug("SQLException DAO" + e);
			throw new DAOException(e);
		} finally {
			cp.releaseResultSet(rs);
			cp.releaseStatement(st);
			cp.releaseDbResourses(con, ps);
		}

		return namesCards;
	}

}
