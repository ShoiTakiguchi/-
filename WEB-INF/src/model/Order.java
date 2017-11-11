package model;

public class Order {
	private int requestid;
	private int reqId;
	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getFulKeyword() {
		return fulKeyword;
	}

	public void setFulKeyword(String fulKeyword) {
		this.fulKeyword = fulKeyword;
	}

	private String kind;
	private String fulKeyword;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	private String keyword5;
	private String author;
	private String isbn;
	private String publisher;
	private String dateofpub;
	private String goodsname;
	private int cost;
	private int number;
	private String reason;
	private String note;
	private int managementflag;
	private int decision;
	private int deliveryofgoods;
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Order(){

	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	public String getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDateofpub() {
		return dateofpub;
	}

	public void setDateofpub(String dateofpub) {
		this.dateofpub = dateofpub;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getManagementflag() {
		return managementflag;
	}

	public void setManagementflag(int managementflag) {
		this.managementflag = managementflag;
	}

	public int getDecision() {
		return decision;
	}

	public void setDecision(int decision) {
		this.decision = decision;
	}

	public int getDeliveryofgoods() {
		return deliveryofgoods;
	}

	public void setDeliveryofgoods(int deliveryofgoods) {
		this.deliveryofgoods = deliveryofgoods;
	}
}
