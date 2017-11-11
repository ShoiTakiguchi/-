package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.LoginDAO;
import dao.OrderDAO;
import model.News;
import model.Order;

public class OrderController {
	private Connection connection = null;

	public int serchRequestId(int today) {
		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();
		int reqId = dao.serchRequestId(today,this.connection);
		dao.closeConnection(this.connection);
		this.connection = null;

		return reqId;

	}

	public ArrayList<Order> searchOrder(int req_id,String kind,String name,ArrayList<String> keywordList,int min_date,int max_date,
				int managementFlag, int decision, int delivery,String username){
		ArrayList<Order> list = new ArrayList<Order>();

		Order order = new Order();
		if(req_id != 0) order.setRequestid(req_id);
		if(kind != null) order.setKind(kind);
		if(name != null) order.setGoodsname(name);
		if(keywordList.get(0) != null){
			order.setKeyword1(keywordList.get(0));
			if(keywordList.get(1) != null) order.setKeyword2(keywordList.get(1));
			if(keywordList.get(2) != null) order.setKeyword3(keywordList.get(2));
			if(keywordList.get(3) != null) order.setKeyword4(keywordList.get(3));
			if(keywordList.get(4) != null) order.setKeyword5(keywordList.get(4));
		}
		if(managementFlag != 0) order.setManagementflag(managementFlag);
		if(decision != 0) order.setDecision(decision);
		if(delivery != 0) order.setDeliveryofgoods(delivery);

		String user_id = null;
		if(username != null){
			//System.out.println("username");
			LoginDAO loginDao = new LoginDAO();
			this.connection = loginDao.createConnection();
			user_id = loginDao.searchID(username, connection);
			loginDao.closeConnection(this.connection);
		}

		OrderDAO orderDao = new OrderDAO();
		this.connection = orderDao.createConnection();
		list = orderDao.searchOrder(order,user_id,min_date,max_date,this.connection);
		orderDao.closeConnection(this.connection);

		return list;
	}

	public Order readOrder(int orderID){

		OrderDAO dao =new OrderDAO();
		this.connection = dao.createConnection();

		Order order = dao.readOrder(orderID,this.connection);
		dao.closeConnection(this.connection);
		this.connection=null;

		return order;
	}
	public String namecheck(String id){

		LoginDAO dao = new LoginDAO();
		this.connection = dao.createConnection();

		String username = dao.searchName(id, connection);
		dao.closeConnection(this.connection);

		return username;
	}

	public ArrayList<News> getNews(String userid){


		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();
		ArrayList<News> list = new ArrayList<News>();
		list = dao.getNews(userid,connection);
		dao.closeConnection(connection);

		return list;
	}

	public ArrayList<Order> getConsider() {

		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();
		ArrayList<Order> list = new ArrayList<Order>();
		list = dao.getConsider(connection);
		dao.closeConnection(connection);

		return list;
	}

	public ArrayList<Order> getAccounting() {

		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();
		ArrayList<Order> list = new ArrayList<Order>();
		list = dao.getAccounting(connection);
		dao.closeConnection(connection);

		return list;
	}


	public void registOrder(int reqId, String kind, String goodsname, String author, String isbn, String publisher,
			String fulKeyword, int cost, int number, String reason, String id) {

		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();
		dao.registOrder(reqId, kind, goodsname, author, isbn, publisher, fulKeyword, cost, number, reason, id,
				this.connection);
		dao.closeConnection(this.connection);
		this.connection = null;

	}

	public void changeflag(int req_id, String flag, int condition) {

		String Flag = null;
		String date = null;
		String next = null;

		if(flag.equals("manflg")){
			Flag="management_flag";
			date="manflg_date";
			next = "decision";
		}else if(flag.equals("decflg")){
			Flag="decision";
			date="decflg_date";
			next = "deliveryofgoods";
		}else if(flag.equals("delflg")){
			Flag="deliveryofgoods";
			date="delflg_date";
		}else{
			System.out.println("error");
		}

		OrderDAO dao = new OrderDAO();
		this.connection = dao.createConnection();

		if(condition==3 || flag.equals("delflg")){
			dao.changeFlag3(req_id,Flag,date,condition,this.connection);
		}else{
			dao.changeFlag2(req_id,Flag,date,next,this.connection);
		}

		dao.closeConnection(this.connection);
		this.connection = null;

	}



}
