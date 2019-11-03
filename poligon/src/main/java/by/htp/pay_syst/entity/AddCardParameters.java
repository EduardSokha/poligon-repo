package by.htp.pay_syst.entity;

import java.util.Date;

public class AddCardParameters {
	
	private String login;
	private String password;
	private int idUser; 
	private Date date = new Date();
	private final String creationDate = date.toString();
	private final int balance = 0;
	private final String status = "unlocked";
	private int currency;
	
	private int paySystCard;
	private int nameCard;
	
	
	public AddCardParameters() {}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getCurrency() {
		return currency;
	}


	public void setCurrency(int currency) {
		this.currency = currency;
	}


	public int getPaySystCard() {
		return paySystCard;
	}


	public void setPaySystCard(int paySystCard) {
		this.paySystCard = paySystCard;
	}


	public int getNameCard() {
		return nameCard;
	}


	public void setNameCard(int nameCard) {
		this.nameCard = nameCard;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public int getBalance() {
		return balance;
	}


	public String getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + currency;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + nameCard;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + paySystCard;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddCardParameters other = (AddCardParameters) obj;
		if (balance != other.balance)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (currency != other.currency)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idUser != other.idUser)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nameCard != other.nameCard)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (paySystCard != other.paySystCard)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AddCardParameters [login=" + login + ", password=" + password + ", idUser=" + idUser + ", date=" + date
				+ ", creationDate=" + creationDate + ", balance=" + balance + ", status=" + status + ", currency="
				+ currency + ", paySystCard=" + paySystCard + ", nameCard=" + nameCard + "]";
	}

	
	
	
	

	
	

}
