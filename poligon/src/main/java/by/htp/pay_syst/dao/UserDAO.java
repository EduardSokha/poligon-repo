package by.htp.pay_syst.dao;

import java.util.List;


import by.htp.pay_syst.entity.AddCardParameters;
import by.htp.pay_syst.entity.ListAccountsAndCards;
import by.htp.pay_syst.entity.PaymentParameters;
import by.htp.pay_syst.entity.RegistrationInfo;
import by.htp.pay_syst.entity.User;

public interface UserDAO {
	
	
	
	String payment(PaymentParameters paym) throws DAOException;//платеж
	boolean registrationUser(RegistrationInfo registr) throws DAOException;
	User authorization(String login, String password) throws DAOException; //авторизация 
	String addCard(AddCardParameters param) throws DAOException;
	String correctionData(User user) throws DAOException;//корректир данных
	List<ListAccountsAndCards> getAccountsAndCards (int idUser) throws DAOException;
	
	
	String correctionLogin(String login, int idUser) throws DAOException;
	String correctionPassword(String newPassword, String oldPassw, int idUser) throws DAOException;
	String correctionName(String name, int idUser) throws DAOException;
	String correctionSurname(String surname, int idUser) throws DAOException;
	String correctionAddress(String address, int idUser) throws DAOException;
	String correctionCodeWord(String codeword, int idUser) throws DAOException;
	String correctionPhoneNumber(String phoneNumber, int idUser) throws DAOException;
	String correctionResidenceRegistr(String residenceRegistr, int idUser) throws DAOException;
	String forgetPassword(String identificNumberPassport, String codeWord, String seriesNumberPassport) throws DAOException;
	String transferBetweenUsersCards(int idCardFrom, int idCardTo, int amount, int idUser) throws DAOException;
	
	
	//всего 15 штук
	
	// добавить в карту валюту, мастер карт или виза +
	// тип виза или мастеркард, валюта, пароль, имя карточки+
	// в табл юзер: добавить серии номер паспорта, идентифик номер паспорта, кодовое слово, номер телефона, прописку+
	// добавить открытие депозита+
	// если забыл пароль восстановить, изменить пароль, выписка платеже юзера, отравлять сообщения админу от юзера через бд
	// выводим баланс номер счета номер карточкки
	// добавить постоянное отображение счетов и баланса
	
}
