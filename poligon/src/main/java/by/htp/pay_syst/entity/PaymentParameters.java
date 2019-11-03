package by.htp.pay_syst.entity;



public class PaymentParameters {
	
	private int paymentAmount;
	private int idAccount;
	private int idUser; 
	private int idAccountRecipient; 
	private String sender;
	
	public PaymentParameters(){}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdAccountRecipient() {
		return idAccountRecipient;
	}

	public void setIdAccountRecipient(int idAccountRecipient) {
		this.idAccountRecipient = idAccountRecipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAccount;
		result = prime * result + idAccountRecipient;
		result = prime * result + idUser;
		result = prime * result + paymentAmount;
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
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
		PaymentParameters other = (PaymentParameters) obj;
		if (idAccount != other.idAccount)
			return false;
		if (idAccountRecipient != other.idAccountRecipient)
			return false;
		if (idUser != other.idUser)
			return false;
		if (paymentAmount != other.paymentAmount)
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentParameters [paymentAmount=" + paymentAmount + ", idAccount=" + idAccount + ", idUser=" + idUser
				+ ", idAccountRecipient=" + idAccountRecipient + ", sender=" + sender + "]";
	}

	

	
	
	
	

}
