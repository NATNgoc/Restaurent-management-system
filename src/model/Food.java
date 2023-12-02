package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import controller.DAO;

public class Food {
	private String id;
	private String idCategory;
	private String name;
	private String unit;
	private double price;
	
	
	public Food(String id, String idCategory, String name, String unit, double price) {
		this.id = id;
		this.idCategory = idCategory;
		this.name = name;
		this.unit = unit;
		this.price = price;
	}


	public Food() {
		
	}
	
	
	
	//
	// Thêm thức ăn
	//
	public static boolean addFood(Food tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql="Insert into monan\n"+
		"Values (?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tmp.getId());
			ps.setString(2, tmp.getIdCategory());
			ps.setString(3, tmp.getName());
			ps.setString(4, tmp.getUnit());
			ps.setDouble(5, tmp.getPrice());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi cho add Food");
			e.printStackTrace();
		} 
		return false;
	}
	//
	// Tìm thức ăn theo id category
	//
	public static ResultSet findFoodByNameCategory(String name) {
		// TODO Auto-generated method stub
		ResultSet rs = null; 
		Connection conn=DAO.getDAO().getConnection();
		String sql="SELECT m.TenMA,m.IDMA from monan m\n"+
				"Join Nhommonan nm\n"
				+ "where nm.tennhomma = ? and m.Idnhomma=nm.idnhomma";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name.trim());
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//
	// xóa thức ăn theo id
	//
	public static boolean deleteFoodById(String id) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="DELETE FROM monan WHERE IDMA=?";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(1, id);
			return pr.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	//
	// Lấy danh sách thức ăn
	//
	public static ArrayList<Food> getListOfFood() {
		ArrayList<Food> ds=new ArrayList<>();
		Connection conn=DAO.getDAO().getConnection();
		String sql="select * from monan";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Food tmp=new Food(); 
				tmp.setId(rs.getString(1));
				tmp.setIdCategory(rs.getString(2));
				tmp.setName(rs.getString(3));
				tmp.setUnit(rs.getString(4));
				tmp.setPrice(rs.getDouble(5));
				ds.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	//
	// Phương thức tìm thức ăn theo Tên
	//
	public static ResultSet findFoodByName(String name) {
		// TODO Auto-generated method stub
		ResultSet rs = null; 
		Connection conn=DAO.getDAO().getConnection();
		String sql="SELECT m.IDMA,m.TenMA,nm.TenNhomMA,m.DonViTinh,m.DonGiaMA from monan m\n"+
				"Join Nhommonan nm\n"
				+ "where TenMA like ? and m.Idnhomma=nm.idnhomma";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//
	// Phương thức cập nhật thức ăn
	//
	public static boolean updateFood(Food tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql="UPDATE monan\n"
				+ "SET IDNhomMA=?, TenMA=?,DonViTinh=?,DonGiaMA=?\n"
				+ "WHERE IDMA=?";
		try {
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(5, tmp.getId());
			pr.setString(1, tmp.getIdCategory());
			pr.setString(2, tmp.getName());
			pr.setString(3, tmp.getUnit());
			pr.setDouble(4, tmp.getPrice());
			return pr.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	//
	//Getter và Setter các thuộc tính
	//
	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public static double findPriceById(String id) {
		String sql="Select dongiaMA\n"+
				"from monan\n"+
				"where idMA=?";
		double tmp=0;
		Connection conn=DAO.getDAO().getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				tmp=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}


	
}
