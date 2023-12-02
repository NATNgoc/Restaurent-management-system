package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

import model.User;
import view.HomePage;

public class DAO {
	private static DAO instance=null;
	private Connection conn;
	private DAO() {
		conn=DAO.createConnection();
	}

	public static DAO getDAO() {
		if (instance==null) {
			instance=new DAO();
		}
		return instance;
	}

	public Connection getConnection() {
		return this.conn;
	}
	
	public static Connection createConnection() {
		Connection c=null;
		try {
			DriverManager.registerDriver(new Driver());
			String url="jdbc:mysql://localhost:3306/quanlynhahang";
			String username="root";
			String password="";
			c= DriverManager.getConnection(url, username, password);
			System.out.println("Ket noi thanh cong!");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return c;
	}
	
	public static boolean addUser(User us) {
		Connection conn =DAO.getDAO().getConnection();
		String sql="INSERT INTO USER "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, us.getId());
			ps.setString(2, us.getName());
			ps.setString(3, us.getPassword());
			ps.setString(4, us.getEmail());
			ps.setString(5, us.getPhoneNumber());
			ps.setString(6,"");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public static boolean Login(String UserName, String UserPassword) {
		Connection conn = DAO.getDAO().getConnection();
		String sql="Select * from user where name=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, UserName);
			ps.setString(2, UserPassword);
			ResultSet rs=ps.executeQuery();
			if (rs.next()&&rs.getString(3).equals(UserPassword)) {
				User userUsing=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
				HomePage.userUsing=userUsing;
				return true;
			} else {
				return false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public static ArrayList<User> getList() {
		Connection conn = DAO.getDAO().getConnection();
		ArrayList<User> list=new ArrayList<>();
		try {
			String sql="select * from user";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User tmp=new User();
				tmp.setId(rs.getInt(1));
				tmp.setName(rs.getString(2));
				tmp.setPassword(rs.getString(3));
				tmp.setEmail(rs.getString(4));
				tmp.setPhoneNumber(rs.getString(5));
				tmp.setPosition(rs.getString(6));
				list.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
