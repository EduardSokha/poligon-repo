package by.htp.pay_syst.service;



import java.util.List;


import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.entity.AddCardParameters;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.NameCard;
import by.htp.pay_syst.entity.PaymentParameters;
import by.htp.pay_syst.entity.RegistrationInfo;
import by.htp.pay_syst.entity.User;

public interface Service { 
	//User
	
	String payment (PaymentParameters paym) throws ServiceException;//+
	boolean registrationUser(RegistrationInfo registr) throws ServiceException;//+
	User authorization (String login, String password) throws ServiceException;//+
	String addCard(AddCardParameters param) throws ServiceException;//+
	String correctionData(User user) throws ServiceException;//+
	List<ListAccountsAndCards> getAccountsAndCards (int idUser) throws ServiceException;//+
	
	
	String correctionLogin(String login, int idUser) throws ServiceException;
	String correctionPassword(String newPassword, String oldPassw, int idUser) throws ServiceException;
	String correctionName(String name, int idUser) throws ServiceException;
	String correctionSurname(String surname, int idUser) throws ServiceException;
	String correctionAddress(String address, int idUser) throws ServiceException;
	String correctionCodeWord(String codeword, int idUser) throws ServiceException;
	String correctionPhoneNumber(String phoneNumber, int idUser) throws ServiceException;
	String correctionResidenceRegistr(String residenceRegistr, int idUser) throws ServiceException;
	String forgetPassword(String identificNumberPassport, String codeWord, String seriesNumberPassport ) throws ServiceException;
	String transferBetweenUsersCards(int idCardFrom, int idCardTo, int amount, int idUser) throws ServiceException;
	
	
	//User
	//-------------------------------------------------------------------
	//Admin
	
	
	boolean registrationAdmin(int idUser, int role) throws ServiceException;//+
	boolean toLockAccount(int idAccount) throws ServiceException;//заблокировать +
	String deleteUser(User user) throws ServiceException;//удалить пользователя -
	boolean toUnlockAccount(int idAccount) throws ServiceException;//разблокирование +
	String accountFerill (int idCard, int amount) throws ServiceException;//+
	
	
	
	
	String correctionSeriesNumberPassport(String newSeriesNumbPassport, int idUser) throws ServiceException;;
	String correctionIdentificNumberPassport(String newIdentificNumbPassport, int idUser) throws ServiceException;;
	List<Account> getAccounts() throws ServiceException;;
	List<Card> getCards() throws ServiceException;;
	List<User> getUsers() throws ServiceException;;
	String addNewNameCard (String newName) throws ServiceException;;
	String deleteNameCard (int idNameCard) throws ServiceException;;
	List<NameCard> getAllNameCard () throws ServiceException;;

	//Admin
	
}
