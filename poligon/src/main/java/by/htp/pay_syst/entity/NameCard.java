package by.htp.pay_syst.entity;

import java.io.Serializable;

public class NameCard implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idNameCard;
	private String nameCard;

	public NameCard() {
	}

	public int getIdNameCard() {
		return idNameCard;
	}

	public void setIdNameCard(int idNameCard) {
		this.idNameCard = idNameCard;
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
		result = prime * result + idNameCard;
		result = prime * result + ((nameCard == null) ? 0 : nameCard.hashCode());
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
		NameCard other = (NameCard) obj;
		if (idNameCard != other.idNameCard)
			return false;
		if (nameCard == null) {
			if (other.nameCard != null)
				return false;
		} else if (!nameCard.equals(other.nameCard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameCard [idNameCard=" + idNameCard + ", nameCard=" + nameCard + "]";
	}

}
