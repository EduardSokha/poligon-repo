package by.htp.pay_syst.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String address;
	private int role;
	private String roleStr;
	private String seriesNumberPassport;
	private String identificNumberPassport;
	private String codeWord;
	private String phoneNumber;
	private String residenceRegistr;

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSeriesNumberPassport() {
		return seriesNumberPassport;
	}

	public void setSeriesNumberPassport(String seriesNumberPassport) {
		this.seriesNumberPassport = seriesNumberPassport;
	}

	public String getIdentificNumberPassport() {
		return identificNumberPassport;
	}

	public void setIdentificNumberPassport(String identificNumberPassport) {
		this.identificNumberPassport = identificNumberPassport;
	}

	public String getCodeWord() {
		return codeWord;
	}

	public void setCodeWord(String codeWord) {
		this.codeWord = codeWord;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getResidenceRegistr() {
		return residenceRegistr;
	}

	public void setResidenceRegistr(String residenceRegistr) {
		this.residenceRegistr = residenceRegistr;
	}

	public String getRoleStr() {
		return roleStr;
	}

	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((codeWord == null) ? 0 : codeWord.hashCode());
		result = prime * result + id;
		result = prime * result + ((identificNumberPassport == null) ? 0 : identificNumberPassport.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((residenceRegistr == null) ? 0 : residenceRegistr.hashCode());
		result = prime * result + role;
		result = prime * result + ((roleStr == null) ? 0 : roleStr.hashCode());
		result = prime * result + ((seriesNumberPassport == null) ? 0 : seriesNumberPassport.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (codeWord == null) {
			if (other.codeWord != null)
				return false;
		} else if (!codeWord.equals(other.codeWord))
			return false;
		if (id != other.id)
			return false;
		if (identificNumberPassport == null) {
			if (other.identificNumberPassport != null)
				return false;
		} else if (!identificNumberPassport.equals(other.identificNumberPassport))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (residenceRegistr == null) {
			if (other.residenceRegistr != null)
				return false;
		} else if (!residenceRegistr.equals(other.residenceRegistr))
			return false;
		if (role != other.role)
			return false;
		if (roleStr == null) {
			if (other.roleStr != null)
				return false;
		} else if (!roleStr.equals(other.roleStr))
			return false;
		if (seriesNumberPassport == null) {
			if (other.seriesNumberPassport != null)
				return false;
		} else if (!seriesNumberPassport.equals(other.seriesNumberPassport))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", address=" + address + ", role=" + role + ", seriesNumberPassport=" + seriesNumberPassport
				+ ", identificNumberPassport=" + identificNumberPassport + ", codeWord=" + codeWord + ", phoneNumber="
				+ phoneNumber + ", residenceRegistr=" + residenceRegistr + ", roleStr=" + roleStr + "]";
	}

}
