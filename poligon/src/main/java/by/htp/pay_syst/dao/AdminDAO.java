package by.htp.pay_syst.dao;

import java.util.List;

import by.htp.pay_syst.entity.Account;
import by.htp.pay_syst.entity.Card;
import by.htp.pay_syst.entity.NameCard;
import by.htp.pay_syst.entity.User;

public interface AdminDAO {
	
	boolean registrationAdmin(int idUser, int role) throws DAOException;
	boolean toLockAccount(int idAccount) throws DAOException;//������������� ����
	String deleteUser(User user) throws DAOException;//������� ������������ 	
	boolean toUnlockAccount(int idAccount) throws DAOException;//������� ����
	String accountRefill(int idCard, int amount) throws DAOException;//���������� �����
	
	
	
	String correctionSeriesNumberPassport(String newSeriesNumbPassport, int idUser) throws DAOException;//+
	String correctionIdentificNumberPassport(String newIdentificNumbPassport, int idUser) throws DAOException;//+
	List<Account> getAccounts() throws DAOException;//+
	List<Card> getCards() throws DAOException;//+
	List<User> getUsers() throws DAOException;//+
	String addNewNameCard (String newName) throws DAOException;//+
	String deleteNameCard (int idNameCard) throws DAOException;//+
	List<NameCard> getAllNameCard() throws DAOException;//+
	
	}


//String addNewCurrency (String currency) throws DAOException;
//String deleteCurrency (String currency) throws DAOException;
//String getAllCurrency (String currency) throws DAOException;


//����� 15 ���� 
	//��������� ������
	//�������� ���������� ����� � ��������� ������������ ������� � ����	+
	//������� � ����� ����� �� �������� ��������, �������� �� ��������
	//����� ���� ��������, ������ � ������ � �������� ������+
	//�������������� ������ ��������, ���� ����� ������ ������ ���������� ������
	
	//	boolean toLockAccount(String name, String surname, int idAccount) throws DAOException;//�������������
	//	String toUnlockAccount(String name, String surname, int idAccount) throws DAOException;//��������������� 
