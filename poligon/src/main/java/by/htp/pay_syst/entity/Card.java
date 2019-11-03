package by.htp.pay_syst.entity;

public class Card {
	
	private int idCard;
	private String creationDate;
	private String status;
	private int idAccount;
	private String typePaymSystCard;
	private String nameCard;
	
	
	public Card(){}


	public int getIdCard() {
		return idCard;
	}


	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}


	public String getTypePaymSystCard() {
		return typePaymSystCard;
	}


	public void setTypePaymSystCard(String typePaymSystCard) {
		this.typePaymSystCard = typePaymSystCard;
	}


	public String getNameCard() {
		return nameCard;
	}


	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + idAccount;
		result = prime * result + idCard;
		result = prime * result + ((nameCard == null) ? 0 : nameCard.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((typePaymSystCard == null) ? 0 : typePaymSystCard.hashCode());
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
		Card other = (Card) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (idAccount != other.idAccount)
			return false;
		if (idCard != other.idCard)
			return false;
		if (nameCard == null) {
			if (other.nameCard != null)
				return false;
		} else if (!nameCard.equals(other.nameCard))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (typePaymSystCard == null) {
			if (other.typePaymSystCard != null)
				return false;
		} else if (!typePaymSystCard.equals(other.typePaymSystCard))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Card [idCard=" + idCard + ", creationDate=" + creationDate + ", status=" + status + ", idAccount="
				+ idAccount + ", typePaymSystCard=" + typePaymSystCard + ", nameCard=" + nameCard + "]";
	}
	
	
	
	
	

}
