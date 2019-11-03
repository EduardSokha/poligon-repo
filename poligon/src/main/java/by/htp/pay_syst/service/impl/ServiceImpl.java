package by.htp.pay_syst.service.impl;

import java.util.List;

import by.htp.pay_syst.dao.AdminDAO;
import by.htp.pay_syst.dao.DAOException;
import by.htp.pay_syst.dao.DAOProvider;
import by.htp.pay_syst.dao.UserDAO;
import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.entity.AddCardParameters;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.NameCard;
import by.htp.pay_syst.entity.PaymentParameters;
import by.htp.pay_syst.entity.RegistrationInfo;
import by.htp.pay_syst.entity.User;
import by.htp.pay_syst.service.Service;
import by.htp.pay_syst.service.ServiceException;
import by.htp.pay_syst.service.validation.DataValidator;

public class ServiceImpl implements Service {
	
	private static final DataValidator validator = DataValidator.getInstance();
	private static final UserDAO providerDAO = DAOProvider.getInstance().getPaymentSystemUserDAO();
	private static final AdminDAO providerDAOAdmin = DAOProvider.getInstance().getPaymentSystemAdminDAO();
	
	
	@Override
	public String payment(PaymentParameters paym) throws ServiceException {
		
		String resp;
		String paymentAmount = String.valueOf(paym.getPaymentAmount());
		String idAccount = String.valueOf(paym.getIdAccount());
		String idAccountRecipient = String.valueOf(paym.getIdAccountRecipient());
		String sender = paym.getSender();
		
//		if(!validator.onlyNumbers(paymentAmount)){
//			resp = "Amount enter incorrect";
//			return resp;
//		}
		
//		if(!validator.onlyNumbers(idAccount)){
//			resp = "Id account enter incorrect";
//			return resp;
//		}
		
//		if(!validator.onlyNumbers(idAccountRecipient)){
//			resp = "Id account recipient enter incorrect";
//			return resp;
//		}
		
//		if(!validator.onlyLetters(sender)){
//			resp = "Id sender enter incorrect";
//			return resp;
//		}
		
		
		
		try {
			resp = providerDAO.payment(paym);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
	}
	@Override
	public boolean registrationUser(RegistrationInfo registr) throws ServiceException {
		
		
		
//		if(!validator.registrationUserPhoneNumb(registr.getPhoneNumber())){
//			resp = "Phone number incorrect";
//			return resp;
//		}
		
		boolean resp;
		try {
			resp = providerDAO.registrationUser(registr);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
		
	}
	@Override
	public User authorization(String login, String password) throws ServiceException {
		
		
		User user;
		
		try{
			user = providerDAO.authorization(login, password);
		} catch(DAOException e){
			throw new ServiceException(e); 			
		}
		
		return user;
	}
	@Override
	public String addCard(AddCardParameters param) throws ServiceException {
		
		String resp;
		
		try {
			resp = providerDAO.addCard(param);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String correctionData(User user) throws ServiceException {

		String resp;
		try {
			resp = providerDAO.correctionData(user);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public List<ListAccountsAndCards> getAccountsAndCards(int idUser) throws ServiceException {
		List<ListAccountsAndCards> resp;
		try {
			resp = providerDAO.getAccountsAndCards(idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	
	
	
	@Override
	public String correctionLogin(String login, int idUser) throws ServiceException {

		String resp;
		
		if(!validator.withoutSpacing(login)){
			resp = "Login with spacing";
			return resp;
		}
		
		
		try {
			resp = providerDAO.correctionLogin(login, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
	}
	@Override
	public String correctionPassword(String newPassword, String oldPassw, int idUser) throws ServiceException {
		
		String resp;
		
		if(!validator.withoutSpacing(newPassword)){
			resp = "New password with spacing";
			return resp;
		}
		
		try {
			resp = providerDAO.correctionPassword(newPassword, oldPassw, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
	}
	@Override
	public String correctionName(String name, int idUser) throws ServiceException {
		
		String resp;
		
//		if(!validator.onlyLetters(name)){
//			resp = "Incorrect name with spacing and symbols";
//			return resp;
//		}
		
		try {
			resp = providerDAO.correctionName(name, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String correctionSurname(String surname, int idUser) throws ServiceException {
		
		String resp;
		
//		if(!validator.onlyLetters(surname)){
//			resp = "Incorrect surname with spacing and symbols";
//			return resp;
//		}
		
		try {
			resp = providerDAO.correctionSurname(surname, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
		
	}
	@Override
	public String correctionAddress(String address, int idUser) throws ServiceException {
		String resp;
		try {
			resp = providerDAO.correctionAddress(address, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String correctionCodeWord(String codeword, int idUser) throws ServiceException {
		
		String resp;
		
//		if(!validator.onlyLetters(codeword)){
//			resp = "Incorrect codeword with spacing and symbols";
//			return resp;
//		}
		
		try {
			resp = providerDAO.correctionCodeWord(codeword, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
	}
	@Override
	public String correctionPhoneNumber(String phoneNumber, int idUser) throws ServiceException {
		
		String resp;
		
//		if(!validator.phoneNumberValidate(phoneNumber)){
//			resp = "Enter phoneNumber incorrect";
//			return resp;
//		}
		
		try {
			resp = providerDAO.correctionPhoneNumber(phoneNumber, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
		
	}
	@Override
	public String correctionResidenceRegistr(String residenceRegistr, int idUser) throws ServiceException {
		
		String resp;
		
		try {
			resp = providerDAO.correctionResidenceRegistr(residenceRegistr, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String forgetPassword(String identificNumberPassport, String codeWord, String seriesNumberPassport)
			throws ServiceException {
		
		String resp;
		
		if(!validator.withoutSpacing(identificNumberPassport)){
			resp = "Identification number passport with spacing";
			return resp;
		}
		
		if(!validator.withoutSpacing(codeWord)){
			resp = "Codeword with spacing";
			return resp;
		}
		
		if(!validator.withoutSpacing(seriesNumberPassport)){
			resp = "Series number of passport with spacing";
			return resp;
		}
		
		try {
			resp = providerDAO.forgetPassword(identificNumberPassport, codeWord, seriesNumberPassport);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String transferBetweenUsersCards(int idCardFrom, int idCardTo, int amount, int idUser) throws ServiceException {
		String resp;
		
		String idCardFr = String.valueOf(idCardFrom);
		String iidCardTo = String.valueOf(idCardTo);
		String paymentAmount = String.valueOf(amount);
		
//		if(!validator.onlyNumbers(idCardFr)){
//			resp = "Should be only numbers in id card";
//			return resp;
//		}
//		
//		if(!validator.onlyNumbers(iidCardTo)){
//			resp = "Should be only numbers in id card";
//			return resp;
//		}
//		
//		if(!validator.onlyNumbers(paymentAmount)){
//			resp = "Should be only numbers in amount";
//			return resp;
//		}
		
		try {
			resp = providerDAO.transferBetweenUsersCards(idCardFrom, idCardTo, amount, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	
	
	//User
	//---------------------------------------------------
	//ADMIN
	
	
	@Override
	public boolean registrationAdmin(int idUser, int role) throws ServiceException {
		boolean resp;
		try {
			resp = providerDAOAdmin.registrationAdmin(idUser, role);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public boolean toLockAccount(int idAccount) throws ServiceException {
		boolean resp;
		try {
			resp = providerDAOAdmin.toLockAccount(idAccount);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String deleteUser(User user) throws ServiceException {
		String resp;
		try {
			resp = providerDAOAdmin.deleteUser(user);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public boolean toUnlockAccount(int idAccount) throws ServiceException {
		
		boolean resp;
		try {
			resp = providerDAOAdmin.toUnlockAccount(idAccount);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
		
	}
	@Override
	public String accountFerill(int idCard, int amount) throws ServiceException {
		
		String resp;
		String iidCard = String.valueOf(idCard);
		String paymentAmount = String.valueOf(amount);
		
//		if(!validator.onlyNumbers(iidCard)){
//			resp = "Should be only numbers in id card";
//			return resp;
//		}
//		
//		
//		if(!validator.onlyNumbers(paymentAmount)){
//			resp = "Should be only numbers in amount";
//			return resp;
//		}
		
		
		
		try {
			resp = providerDAOAdmin.accountRefill(idCard, amount);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;	
	}
	
	
	
	@Override
	public String correctionSeriesNumberPassport(String newSeriesNumbPassport, int idUser) throws ServiceException {
		
		String resp;
		
		if(!validator.withoutSpacing(newSeriesNumbPassport)){
			resp = "Incorrect, series number passport with spacing";
			return resp;
		}
		
		try {
			resp = providerDAOAdmin.correctionSeriesNumberPassport(newSeriesNumbPassport, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String correctionIdentificNumberPassport(String newIdentificNumbPassport, int idUser) throws ServiceException {
		String resp;
		
		if(!validator.withoutSpacing(newIdentificNumbPassport)){
			resp = "Incorrect, identification number passport with spacing";
			return resp;
		}
		
		try {
			resp = providerDAOAdmin.correctionIdentificNumberPassport(newIdentificNumbPassport, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public List<Account> getAccounts() throws ServiceException {
		List<Account> resp;
		try {
			resp = providerDAOAdmin.getAccounts();
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public List<Card> getCards() throws ServiceException {
		List<Card> resp;
		try {
			resp = providerDAOAdmin.getCards();
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public List<User> getUsers() throws ServiceException {
		List<User> resp;
		try {
			resp = providerDAOAdmin.getUsers();
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String addNewNameCard(String newName) throws ServiceException {
		String resp;
		
//		if(!validator.onlyLetters(newName)){
//			resp = "Incorrect, name card with spacing and symbols";
//			return resp;
//		}
		
		try {
			resp = providerDAOAdmin.addNewNameCard(newName);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public String deleteNameCard(int idNameCard) throws ServiceException {
		String resp;
		String iidCard = String.valueOf(idNameCard);
		
//		if(!validator.onlyNumbers(iidCard)){
//			resp = "Should be only numbers in id card";
//			return resp;
//		}
		
		try {
			resp = providerDAOAdmin.deleteNameCard(idNameCard);
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	@Override
	public List<NameCard> getAllNameCard() throws ServiceException {
		List<NameCard> resp;
		try {
			resp = providerDAOAdmin.getAllNameCard();
		} catch (DAOException e) {
			throw new ServiceException(e); 	
		}
		
		return resp;
	}
	
	

	
		

}
