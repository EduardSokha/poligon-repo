package by.htp.WebProjectPaymentSystem.start;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import by.htp.pay_syst.command.impl.GetAccountsAndCards;
import by.htp.pay_syst.connection_pool.ConnectionPool;
import by.htp.pay_syst.connection_pool.DBResourceManager;
import by.htp.pay_syst.dao.DAOException;
import by.htp.pay_syst.dao.DAOProvider;
import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.entity.AddCardParameters;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.NameCard;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.ServiceProvider;
import by.htp.pay_syst.service.validation.DBParamemetersValidation;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
//		DAOProvider dao = DAOProvider.getInstance();
//		ServiceProvider serv = ServiceProvider.getInstance();
//		Date date = new Date();
//	       System.out.println(date.toString());
//	       System.out.println("-------------------------");
//	       String time = date.toString();
//	       System.out.println(time);

		int x = 33;
		System.out.println(x+3);
		String amount = String.valueOf(x);
		System.out.println(amount + 777);
		String input = "\\d";
		Pattern patter = Pattern.compile(amount);

		Matcher matcher = patter.matcher(input);

		if (matcher.find()) {

			System.out.println("true");
		}
		
		
//		logger.debug("hhhhhhhhhhhhhhh");
		
		
//		try {
//			System.out.println(serv.getSelectService().authorization("Dmןנא", "11ןנא"));
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			System.out.println("mistake");
//		}
		
		
		
//		ConnectionPool con = ConnectionPool.getInstance();
//		try {
//			con.take();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		dao.getpaymentSystemDAO().registrationUser("dmit", "360", "Dmitry", "Yushko", "Ozernaya, 30");
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().accountRefill(6, 38));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("dfgsdgsdg");
//		}
		
		
//		try {
//			System.out.println( dao.getPaymentSystemUserDAO().payment(12, 6, 3, 527, "yuriy"));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("dfgsdgsdg");
//		}
		
		
//		try {
//			System.out.println( dao.getPaymentSystemAdminDAO().registrationAdmin(4, 2));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("dfgsdgsdg");
//		}
		
		
		
//		try {
//			System.out.println( dao.getPaymentSystemAdminDAO().toLockAccount(8));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("dfgsdgsdg");
//		}
		
		
		
//			AddCardParameters add = new AddCardParameters();
//			add.setLogin("Nilik");
//			add.setPassword("3860");
//		try {
//			System.out.println( dao.getPaymentSystemUserDAO().addCard(add));
//		} catch (DAOException e) {
//		
//			System.out.println("dfgsdgsdg");
//		}
		
		
//		User user = new User();
//		user.setId(9);
//		user.setLogin("olhud");
//		user.setName("Oleg");
//		user.setSurname("Hudnickiy");
//		user.setAddress("Dolgobrodskaya 8, flat 3");
//		user.setRole(2);
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionData(user));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
		
//		User user = new User();
//		user.setId(8);
//		try {
//			System.out.println(dao.getPaymentSystemAdminDAO().deleteUser(user));
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
//		List<ListAccountsAndCards> accaunts;
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			accaunts = dao.getPaymentSystemUserDAO().getAccountsAndCards(2);
//			for (ListAccountsAndCards b : accaunts) {
//				System.out.println(b);
//			}
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
//		-----------------------------------------------------------------
		
//		List<NameCard> namesCards = new ArrayList<NameCard>();
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			namesCards = dao.getPaymentSystemAdminDAO().getAllNameCard();
//			for (NameCard b : namesCards) {
//				System.out.println(b);
//			}
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
//		List<NameCard> namesCards = new ArrayList<NameCard>();
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			namesCards = serv.getSelectService().getAllNameCard();
//			for (NameCard b : namesCards) {
//				System.out.println(b);
//			}
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
//		List<User> users = new ArrayList<User>();
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			users = dao.getPaymentSystemAdminDAO().getUsers();
//			for (User b : users) {
//				System.out.println(b);
//			}
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
		
//		List<Account> accounts = new ArrayList<Account>();
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			accounts = dao.getPaymentSystemAdminDAO().getAccounts();
//			for (Account b : accounts) {
//				System.out.println(b);
//			}
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
		
//		List<Card> cards = new ArrayList<Card>();
//		try {
////			System.out.println(dao.getPaymentSystemUserDAO().getAccountsAndCards(8));
//			cards = dao.getPaymentSystemAdminDAO().getCards();
//			for (Card b : cards) {
//				System.out.println(b);
//			}
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
		
//		try {
//			System.out.println(dao.getPaymentSystemAdminDAO().correctionSeriesNumberPassport("GG33333", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}	
		
		
//		try {
//			System.out.println(dao.getPaymentSystemAdminDAO().correctionIdentificNumberPassport("22289v33", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}	
		
		
//		try {
//			System.out.println(dao.getPaymentSystemAdminDAO().addNewNameCard("FRIEND"));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ");
//		}
		
		
//	try {
//		System.out.println(dao.getPaymentSystemAdminDAO().deleteNameCard(5));
//		
//	} catch (DAOException e) {
//		// TODO Auto-generated catch block
//		System.out.println("מרטבךא ג האמ");
//	}
		
		
		
//		try {
//		System.out.println(dao.getPaymentSystemUserDAO().correctionLogin("Dmitr", 2));
//		
//	} catch (DAOException e) {
//		// TODO Auto-generated catch block
//		System.out.println("מרטבךא ג האמ");
//	}
	
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionName("Dmitriy", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionSurname("Yushko", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionAddress("Deriglazova, 20 flat 27", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionCodeWord("venom", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionPhoneNumber("+375336897422", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().correctionResidenceRegistr("Deriglazova, 20 flat 27", 2));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
//		try {
//		System.out.println(dao.getPaymentSystemUserDAO().correctionPassword("222", "2121", 2));
//		
//	} catch (DAOException e) {
//		// TODO Auto-generated catch block
//		System.out.println("מרטבךא ג האמ"); 
//	}
		
		
//		try {
//			System.out.println(dao.getPaymentSystemUserDAO().forgetPassword("22289v33", "venom", "GG33333"));
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("מרטבךא ג האמ"); 
//		}
		
		
//		try {
//		System.out.println(dao.getPaymentSystemUserDAO().transferBetweenUsersCards(2, 3, 20, 0));
//		
//	} catch (DAOException e) {
//		// TODO Auto-generated catch block
//		System.out.println("מרטבךא ג האמ"); 
//	}
		
		
		
		
		
		
		
		
//		-----------------------------------------------------------------
		
		
		
//		ConnectionPool cp = ConnectionPool.getInstance();		
		
//		String d = DBResourceManager.getInstance().getValue("db.driver");
//		System.out.println(d);
		
		
//		DBResourceManager db = DBResourceManager.getInstance();
//		
//		System.out.println(db.getValue(DBParameters.DB_DRIVER) + db.getValue(DBParameters.DB_URL) + 
//				db.getValue(DBParameters.DB_USER) + db.getValue(DBParameters.DB_PASSWORD) +
//				Integer.parseInt(db.getValue(DBParameters.DB_SIZE)));  

		
		

		
		
		
		
		
//		ConnectionPool cp = ConnectionPool.getInstance();
//		Connection con = null;
//		ResultSet rs = null;
//		PreparedStatement ps = null;
//		Statement st = null;
//		int idCard = 1;
//		
//		try {
//			
//			con = cp.take();
//			st = con.createStatement();
//			
//			String sq1 = "SELECT account_idaccount FROM card WHERE idcard=" + idCard;
//			System.out.println(sq1);
//			
//			rs = st.executeQuery(sq1);
//			rs.next();
//			int f = rs.getInt(1);
//			System.out.println("idaccount=" + f);
//			int b = 600;
//			String sq2 = "UPDATE payment_system.account SET balance=" + b + " WHERE idaccount=" + f;
//			System.out.println(sq2);
//			ps = con.prepareStatement(sq2);
//			ps.executeUpdate();
////			while(rs.next()) {
////				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
////			}
//			
//		
//			
//		} catch (SQLException e) {
//			System.out.println("SQLException e");
//		} catch (InterruptedException e) {
//			System.out.println("InterruptedException e");
//		} finally {
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					// log
//					System.err.println();
//				}
//			}
//			
//			cp.release(con);
//		}
		
	}

}
