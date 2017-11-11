package model;

public class User {
	private String id;
	private String username;
	private String password;
	private String mailaddress;
	private int role;
	private int per_mail;

	public int getPer_mail() {
		return per_mail;
	}

	public void setPer_mail(int per_mail) {
		this.per_mail = per_mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
