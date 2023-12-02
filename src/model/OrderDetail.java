package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.DAO;

public class OrderDetail {
	String idOrder;
	String idMA;
	Date dateOfOrder;
	int SL;
	Double money;
	
	
	
	public OrderDetail(String idOrder, String idMA, Date dateOfOrder, int sL) {
		super();
		this.idOrder = idOrder;
		this.idMA = idMA;
		this.dateOfOrder = dateOfOrder;
		SL = sL;
	}
	public int getSL() {
		return SL;
	}
	public void setSL(int sL) {
		SL = sL;
	}
	public OrderDetail() {
		
	}
	public OrderDetail(String idOrder, String idMA, int SL, Date dateOfOrder, Double money) {
		this.SL=SL;
		this.idOrder = idOrder;
		this.idMA = idMA;
		this.dateOfOrder = dateOfOrder;
		this.money = money;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdMA() {
		return idMA;
	}
	public void setIdMA(String idMA) {
		this.idMA = idMA;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	public static boolean addOrderDetail(OrderDetail tmp) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="insert into ctphieuyeucau  \n"+
					"Value (?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tmp.getIdOrder());
			ps.setString(2, tmp.getIdMA());
			ps.setInt(3, tmp.getSL());
			String date =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			ps.setString(4, date);
			ps.setDouble(5, tmp.getMoney());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 
	public static  ResultSet getListOfOrderDetailByIdOrder(String idOrder) {
		ResultSet rs=null;
		String sql="select p.IDPYC, p.IDMA,mn.tenMA,p.SL,p.sotien from ctphieuyeucau p\n"+
				"join monan mn\n"+
				"on mn.IDMA=p.IDMA\n"+
						"where p.idpyc=?";
		Connection conn=DAO.getDAO().getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, idOrder);
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static boolean updateOrderDetail(String idMA,String idPYC, int sl) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="update ctphieuyeucau\n"+
					"set SL=?\n"+
					"where idMA=? and idPYC=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, sl);
			ps.setString(2, idMA);
			ps.setString(3, idPYC);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteOrderDetail(String idMA,String idPYC) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="Delete from ctphieuyeucau\n"+
						"where idMA=? and idPYC=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, idMA);
			ps.setString(2, idPYC);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
