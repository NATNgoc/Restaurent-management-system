package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JApplet;

import controller.DAO;

public class Order {
	private String idOrder;
	private String idTable;
	private java.util.Date dateOfOrder;
	private int status;
	
	
	
	public Order() {
		
	}
	public Order(String idOrder, String idTable, java.util.Date dateOfOrder, int status) {
	
		this.idOrder = idOrder;
		this.idTable = idTable;
		this.dateOfOrder = dateOfOrder;
		this.status = status;
	}
	
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdTable() {
		return idTable;
	}
	public void setIdTable(String idTable) {
		this.idTable = idTable;
	}
	public java.util.Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(java.util.Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public static ResultSet getListOfOrder() {
		ResultSet rs=null;
		String sql="select * from phieuyeucau";
		Connection conn=DAO.getDAO().getConnection();
		try {	
			PreparedStatement ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static boolean  addOrder(Order tmp) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="insert into phieuyeucau \n"+
					"Value (?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tmp.getIdOrder());
			ps.setString(2, tmp.getIdTable());
			java.util.Date date=new java.util.Date();
			String date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			ps.setString(3,date1);
			ps.setInt(4, tmp.getStatus());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static int findNumberNotExsits() {
		int viTri = 1;
		ResultSet ds = Order.getListOfOrder();
		try {
			while (ds.next()) {
				int id=Integer.parseInt(ds.getString(1));
				if (id==viTri) {
					viTri++; 
				} else { 
					break;
				}
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viTri;
	}
	
	public static String findOrderByIdTable(String id) {
		String sql="SELECT p.IDPYC\r\n"
				+ "FROM phieuyeucau p\r\n"
				+ "JOIN banan b\r\n"
				+ "ON p.IDBA=b.IDBA\r\n"
				+ "WHERE b.IDBA=? AND p.`Status`=0";
		String tmp=null;
		Connection connec=DAO.getDAO().getConnection();
		try {
			PreparedStatement ps=connec.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			;
			while (rs.next()) {
				tmp=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("Bi loi tim mon");
			e.printStackTrace();
		}
		return tmp;
	}
	
	public static boolean deleteOrderById(String id) {
		String sql="delete from phieuyeucau where idpyc=?";
		try {
			Connection conn=DAO.getDAO().getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static double getRevenue() {
		String sql="Select sum(sotien) from phieuthanhtoan";
		Connection conn=DAO.getDAO().getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
	
}
