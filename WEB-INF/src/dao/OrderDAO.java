package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.News;
import model.Order;
import utility.DriverAccessor;

public class OrderDAO extends DriverAccessor {

	public int serchRequestId(int today, Connection connection) {
		try {
			String sql = "select count(req_id) from request_table where req_id >= ?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1,today);
			ResultSet rs = stmt.executeQuery();
			rs.first();

			int count = rs.getInt("count(req_id)");

			stmt.close();
			rs.close();
			int reqId=today+count;
			System.out.println("リクエスト");

			System.out.println(reqId);


			return reqId;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return 0;
	}



	public void registOrder(int reqId, String kind, String goodsname, String author, String isbn, String publisher,
			String fulKeyword, int cost, int number, String reason, String id, Connection connection) {
		try {
			String sql = "insert into request_table (req_id,kind,goodsname,author,isbn,publisher,"
					+ "keyword_1,keyword_2,keyword_3,keyword_4,keyword_5,cost,number,reason,id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			ArrayList<String> keywordList = new ArrayList<String>(5);
			for(int i=0; i<5; i++) keywordList.add(null);
			if(kind.equals("書籍")){
				String[] keywords = fulKeyword.split(",");
				for(int i=0; i<keywords.length; i++) keywordList.add(i,keywords[i]);
			}



			stmt.setInt(1,reqId);
			//System.out.println(reqId);
			stmt.setString(2, kind);
			//System.out.println(kind);
			stmt.setString(3, goodsname);
			//System.out.println(goodsname);
			stmt.setString(4, author);
			//System.out.println(author);
			stmt.setString(5, isbn);
			//System.out.println(isbn);
			stmt.setString(6, publisher);
			//System.out.println(publisher);
			stmt.setString(7, keywordList.get(0));
			stmt.setString(8, keywordList.get(1));
			stmt.setString(9, keywordList.get(2));
			stmt.setString(10, keywordList.get(3));
			stmt.setString(11, keywordList.get(4));
			/*for(int i=0; i<keywordList.size(); i++){
				System.out.println(keywordList.get(i));
			}*/
			stmt.setInt(12,cost);
			//System.out.println(cost);
			stmt.setInt(13,number);
			//System.out.println(number);
			stmt.setString(14, reason);
			//System.out.println(reason);
			stmt.setString(15,id);
			//System.out.println(id);
			stmt.executeUpdate();

			System.out.println("リクエストID" +reqId);
			System.out.println(id);


			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}


	public ArrayList<Order> searchOrder(Order order,String user_id, int min_date,int max_date,Connection connection) {
		try {

			String sql = "select * from request_table where if(?=0,1,req_id=?)"
					+ "AND if(?=0,1,req_id>=?)"
					+ "AND if(?=0,1,req_id<=?)"
					+ "AND if(?=0,1,management_flag=?)"
					+ "AND if(?=0,1,decision=?)"
					+ "AND if(?=0,1,deliveryofgoods=?)"
					+ "AND if(? is NULL,1,kind=?)"
					+ "AND if(? is NULL,1,id=?)"
					+ "AND if(? is NULL,1,goodsname=?)"
					+ "AND if(? is NULL,1,author=?)"
					+ "AND if(? is NULL,1,isbn=?)"
					+ "AND if(? is NULL,1,(keyword_1=? OR keyword_2=? OR keyword_3=? OR keyword_4=? OR keyword_5=?))"
					+ "AND if(? is NULL,1,(keyword_1=? OR keyword_2=? OR keyword_3=? OR keyword_4=? OR keyword_5=?))"
					+ "AND if(? is NULL,1,(keyword_1=? OR keyword_2=? OR keyword_3=? OR keyword_4=? OR keyword_5=?))"
					+ "AND if(? is NULL,1,(keyword_1=? OR keyword_2=? OR keyword_3=? OR keyword_4=? OR keyword_5=?))"
					+ "AND if(? is NULL,1,(keyword_1=? OR keyword_2=? OR keyword_3=? OR keyword_4=? OR keyword_5=?))";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, order.getRequestid());
			stmt.setInt(2, order.getRequestid());
			//System.out.println(order.getRequestid());
			stmt.setInt(3, min_date);
			stmt.setInt(4, min_date);
			stmt.setInt(5, max_date);
			stmt.setInt(6, max_date);
			stmt.setInt(7, order.getManagementflag());
			stmt.setInt(8, order.getManagementflag());
			stmt.setInt(9, order.getDecision());
			stmt.setInt(10, order.getDecision());
			stmt.setInt(11, order.getDeliveryofgoods());
			stmt.setInt(12, order.getDeliveryofgoods());
			stmt.setString(13, order.getKind());
			stmt.setString(14, order.getKind());
			stmt.setString(15, user_id);
			stmt.setString(16, user_id);
			stmt.setString(17, order.getGoodsname());
			stmt.setString(18, order.getGoodsname());
			stmt.setString(19, order.getAuthor());
			stmt.setString(20, order.getAuthor());
			stmt.setString(21, order.getIsbn());
			stmt.setString(22, order.getIsbn());
			stmt.setString(23, order.getKeyword1());
			stmt.setString(24, order.getKeyword1());
			stmt.setString(25, order.getKeyword1());
			stmt.setString(26, order.getKeyword1());
			stmt.setString(27, order.getKeyword1());
			stmt.setString(28, order.getKeyword1());
			stmt.setString(29, order.getKeyword2());
			stmt.setString(30, order.getKeyword2());
			stmt.setString(31, order.getKeyword2());
			stmt.setString(32, order.getKeyword2());
			stmt.setString(33, order.getKeyword2());
			stmt.setString(34, order.getKeyword2());
			stmt.setString(35, order.getKeyword3());
			stmt.setString(36, order.getKeyword3());
			stmt.setString(37, order.getKeyword3());
			stmt.setString(38, order.getKeyword3());
			stmt.setString(39, order.getKeyword3());
			stmt.setString(40, order.getKeyword3());
			stmt.setString(41, order.getKeyword4());
			stmt.setString(42, order.getKeyword4());
			stmt.setString(43, order.getKeyword4());
			stmt.setString(44, order.getKeyword4());
			stmt.setString(45, order.getKeyword4());
			stmt.setString(46, order.getKeyword4());
			stmt.setString(47, order.getKeyword5());
			stmt.setString(48, order.getKeyword5());
			stmt.setString(49, order.getKeyword5());
			stmt.setString(50, order.getKeyword5());
			stmt.setString(51, order.getKeyword5());
			stmt.setString(52, order.getKeyword5());

			ResultSet rs = stmt.executeQuery();
			ArrayList<Order> list = new ArrayList<Order>();

			//rs.first();

			while(rs.next())
			{
				Order resultOrder = new Order();

				resultOrder.setRequestid(rs.getInt("req_id"));
				resultOrder.setKind(rs.getString("kind"));
				resultOrder.setGoodsname(rs.getString("goodsname"));

				list.add(resultOrder);
			}



			stmt.close();
			rs.close();

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}


	public Order readOrder(int orderID, Connection connection) {
		try {
			String sql = "select * from request_table where req_id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,orderID);

			ResultSet rs=stmt.executeQuery();

			rs.first();

			Order order = new Order();
			order.setRequestid(orderID);
			order.setManagementflag(rs.getInt("management_flag"));
			order.setDecision(rs.getInt("decision"));
			order.setDeliveryofgoods(rs.getInt("deliveryofgoods"));
			order.setKind(rs.getString("kind"));
			order.setUserid(rs.getString("id"));
			order.setGoodsname(rs.getString("goodsname"));

			if((rs.getString("kind")).equals("書籍")){
				order.setAuthor(rs.getString("author"));
				order.setIsbn(rs.getString("isbn"));
				order.setPublisher(rs.getString("publisher"));
				order.setKeyword1(rs.getString("keyword_1"));
				order.setKeyword2(rs.getString("keyword_2"));
				order.setKeyword3(rs.getString("keyword_3"));
				order.setKeyword4(rs.getString("keyword_4"));
				order.setKeyword5(rs.getString("keyword_5"));
			}
			order.setCost(rs.getInt("cost"));
			order.setNumber(rs.getInt("number"));
			order.setReason(rs.getString("reason"));
			if((rs.getString("note"))!=null) order.setNote(rs.getString("note"));


			stmt.close();

			//System.out.println(order.getGoodsname());

			return order;


		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<News> getNews(String userid, Connection connection) {
		try {
			String sql = "select * from request_table where delflg_date >= ? OR (id = ? AND (manflg_date >= ? OR decflg_date >= ?))";
			PreparedStatement stmt = connection.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			String monthAgo = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" +cal.get(Calendar.DATE);
			//System.out.println(monthAgo);

			stmt.setString(1,monthAgo);
			stmt.setString(2,userid);
			stmt.setString(3,monthAgo);
			stmt.setString(4,monthAgo);

			ResultSet rs=stmt.executeQuery();
			ArrayList<News> list = new ArrayList<News>();
			//System.out.println("dao");

			while(rs.next())
			{
				News news = new News();

				news.setRequestid(rs.getInt("req_id"));
				news.setUserid(rs.getString("id"));

				try{

					if(rs.getString("manflg_date") != null)news.setMandate(toDate(rs.getString("manflg_date")));
					if(rs.getString("decflg_date") != null)news.setDecdate(toDate(rs.getString("decflg_date")));
					if(rs.getString("delflg_date") != null)news.setDeldate(toDate(rs.getString("delflg_date")));
				} catch (ParseException e){
					System.out.println(e);
				}

				if(news.getDeldate() !=null && news.getDeldate().compareTo(cal) == 1) news.setDelnews(true);
				if(userid.equals(news.getUserid())){
					if(news.getMandate() !=null && news.getMandate().compareTo(cal) == 1) news.setMannews(true);
					if(news.getDecdate() !=null && news.getDecdate().compareTo(cal) == 1) news.setDecnews(true);
				}

				list.add(news);
			}
			stmt.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<Order> getConsider(Connection connection) {
		try {
			String sql = "select * from request_table where management_flag = 1";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			ArrayList<Order> list = new ArrayList<Order>();

			while(rs.next())
			{
				Order order = new Order();
				order.setRequestid(rs.getInt("req_id"));
				order.setGoodsname(rs.getString("goodsname"));
				list.add(order);
			}
			stmt.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public ArrayList<Order> getAccounting(Connection connection) {
		try {
			String sql = "select * from request_table where decision = 1";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			ArrayList<Order> list = new ArrayList<Order>();

			while(rs.next())
			{
				Order order = new Order();
				order.setRequestid(rs.getInt("req_id"));
				order.setGoodsname(rs.getString("goodsname"));
				list.add(order);
			}
			stmt.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

    public Calendar toDate(String str) throws ParseException {

    	String format = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(str);
        Calendar cal = Calendar.getInstance();
		cal.setTime(date);

        return cal;
    }



	public void changeFlag3(int req_id, String flag, String date, int condition, Connection connection) {
		try {
			Calendar cal = Calendar.getInstance();
			String today = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			//System.out.println(today);
			String sql = "update request_table set " + flag + "=?, "+date+"=? where req_id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1,condition);
			stmt.setString(2,today);
			stmt.setInt(3,req_id);



			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}





	public void changeFlag2(int req_id, String flag, String date, String next, Connection connection) {
		try {
			Calendar cal = Calendar.getInstance();
			String today = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			//System.out.println(today);
			String sql = "update request_table set " + flag + "=2, " + date + "=?," + next+ "=1 where req_id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);


			stmt.setString(1,today);
			stmt.setInt(2,req_id);


			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

	}

}
