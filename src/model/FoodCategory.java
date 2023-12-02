package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.DAO;

public class FoodCategory {
	private String id;
	private String name;
	public FoodCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public FoodCategory() {
	
	}
	
	public static ArrayList<FoodCategory> getListOfFoodCategoriesAR() {
		ArrayList<FoodCategory> ds=new ArrayList<>();
		Connection conn=DAO.getDAO().getConnection();
		String sql="select * from nhommonan";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				FoodCategory tmp=new FoodCategory();
				tmp.setId(rs.getString(1));
				tmp.setName(rs.getString(2));
				ds.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
	public static ResultSet getListOfFoodCategoriesRS() {
		ResultSet rs=null;
		Connection conn=DAO.getDAO().getConnection();
		String sql="select * from nhommonan";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static boolean AddFoodCategory(FoodCategory tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql ="insert into nhommonan\n"+
				"value (?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,tmp.getId());
			ps.setString(2,tmp.getName());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean UpdateFoodCategory(FoodCategory tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql ="update nhommonan\n"+
				"set tennhomma=?\n"
				+ "where IDNhomma=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,tmp.getName());
			ps.setString(2,tmp.getId());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteById(String id) {
		// TODO Auto-generated method stub
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="delete from nhommonan where idNhomMA=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return false;
	}
	
	public static String findFoodCategoryIDByName(String name) {
		String id="";
		Connection conn=DAO.getDAO().getConnection();
		String sql="Select IDNhomMA from nhommonan where TenNhomMA=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				id=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
