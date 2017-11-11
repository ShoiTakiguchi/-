package controller;

import java.sql.Connection;

import dao.LoginDAO;
import model.User;

public class LoginController {
	private Connection connection = null;

	public User certifyUser(String id, String password) {
		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();
		User user = dao.certifyUser(id, this.connection);

		this.connection = null;


		if(user==null)
			return null;
		else if(password.equals(user.getPassword())) {
			return user;
		}else
			return null;

	}

	public void changeMail(String id,int perMail) {
		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();

		dao.changeMail(id,perMail,connection);
		this.connection = null;

	}

}
