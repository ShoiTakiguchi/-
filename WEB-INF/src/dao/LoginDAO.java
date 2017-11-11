package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import utility.DriverAccessor;

public class LoginDAO extends DriverAccessor {
	public User certifyUser(String id, Connection connection) {
		try {
			String sql = "select name,password,mail_address,role,per_mail from user_table inner join user_role "
					+ "on user_table.id=user_role.id where user_table.id =?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.first();

			User user = new User();
			user.setId(id);
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("name"));
			user.setMailaddress(rs.getString("mail_address"));
			user.setRole(rs.getInt("role"));
			user.setPer_mail(rs.getInt("per_mail"));

			stmt.close();
			rs.close();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public String searchID(String name, Connection connection){

		try{

		String sql = "select id from user_table where name = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		rs.first();

		String user_id = rs.getString("id");

		stmt.close();
		rs.close();

		return user_id;

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}

	}

	public String searchName(String id, Connection connection){

		try{

		String sql = "select name from user_table where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		rs.first();

		String user_id = rs.getString("name");

		stmt.close();
		rs.close();

		return user_id;

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}

	}

	public void changeMail(String id, int perMail, Connection connection) {

		try{
			String sql = "update user_role set per_mail = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, perMail);
			//System.out.println("dao"+perMail);
			stmt.setString(2, id);
			//System.out.println(id);

			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
		}
	}

	public ArrayList<String> getmanagerAddress(Connection connection) {

		try {
			String sql = "select mail_address,role,per_mail from user_table inner join user_role "
					+ "on user_table.id=user_role.id where user_role.role =1 AND user_role.per_mail =1";
			PreparedStatement stmt = connection.prepareStatement(sql);
			//stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> addr = new ArrayList<String>();

			while(rs.next()){
				addr.add(rs.getString("mail_address"));
			}

			stmt.close();
			rs.close();

			return addr;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	public ArrayList<String> getAddress(Connection connection) {

		try {
			String sql = "select mail_address,role,per_mail from user_table inner join user_role "
					+ "on user_table.id=user_role.id where user_role.per_mail =1";
			PreparedStatement stmt = connection.prepareStatement(sql);
			//stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> addr = new ArrayList<String>();

			while(rs.next()){
				addr.add(rs.getString("mail_address"));
			}

			stmt.close();
			rs.close();

			return addr;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

}

