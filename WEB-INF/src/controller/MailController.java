package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import dao.LoginDAO;
import utility.DeliveryReportMail;
import utility.OrderReportMail;

public class MailController {
	private Connection connection = null;

	public void registMail(int reqId, String goodsname, String mailaddress, int per_mail, String username) throws IOException {
		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();

		ArrayList<String> addr = dao.getmanagerAddress(this.connection);
		this.connection = null;

		if(per_mail == 1) addr.add(mailaddress);

		if(addr != null){
			OrderReportMail mailler = new OrderReportMail();
			mailler.Mail(username, addr, reqId, goodsname);
		}

	}

	public void deliveryMail(int reqId, String goodsname, String mailaddress, int per_mail, String username) throws IOException {
		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();

		ArrayList<String> addr = dao.getAddress(this.connection);

		dao.closeConnection(this.connection);
		this.connection = null;

		if(per_mail == 1) addr.add(mailaddress);

		if(addr != null){
			DeliveryReportMail mailler = new DeliveryReportMail();
			mailler.Mail(username, addr, reqId, goodsname);
		}

	}

}
