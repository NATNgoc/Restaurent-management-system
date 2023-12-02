package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DAO;

public class Bill {
private	String idPTT;
private	String idPYC;
private String date;
private Double money;
private int discount;
public Bill(String idPTT, String idPYC, String date, Double money, int discount) {
	
	this.idPTT = idPTT;
	this.idPYC = idPYC;
	this.date = date;
	this.money = money;
	this.discount = discount;
}


public Bill() {
	
}


public String getIdPTT() {
	return idPTT;
}
public void setIdPTT(String idPTT) {
	this.idPTT = idPTT;
}
public String getIdPYC() {
	return idPYC;
}
public void setIdPYC(String idPYC) {
	this.idPYC = idPYC;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Double getMoney() {
	return money;
}
public void setMoney(Double money) {
	this.money = money;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}

public static ResultSet getListOfBill() {
	String sql ="select * from phieuthanhtoan";
	Connection conn=DAO.getDAO().getConnection();
	ResultSet rs=null;
	try {
		PreparedStatement ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}
public static int getSizeOfBill() {
	String sql="Select count(*) from phieuthanhtoan";
	try {
		Connection con=DAO.getDAO().getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) return rs.getInt(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
public static int findNumberNotExsits() {
	int viTri = 1;
	ResultSet ds =Bill.getListOfBill();
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

public static boolean addBill(Bill tmp) {
	Connection conn=DAO.getDAO().getConnection();
	String sql= "insert into phieuthanhtoan"+
	"\n value(?,?,?,?,?)";
	try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, tmp.getIdPTT());
		ps.setString(2, tmp.getIdPYC());
		ps.setString(3, tmp.getDate());
		ps.setDouble(4, tmp.getMoney());
		ps.setInt(5, tmp.getDiscount());
		return ps.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return false;
}

public static ResultSet getResultBetween2Day(String dateFrom,String dateTo) {
	ResultSet rs=null;
	String sql="select * from phieuthanhtoan\n"+
			"where ngaythanhtoan>=? and ngaythanhtoan<=?";
	Connection conn=DAO.getDAO().getConnection();
	try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, dateFrom);
		ps.setString(2, dateTo);
		rs = ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

public static int getSizeOfPage() {
		String sql="Select count(*) from phieuthanhtoan";
		try {
			Connection con=DAO.getDAO().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}

@Override
public String toString() {
	return "Bill [idPTT=" + idPTT + ", idPYC=" + idPYC + ", date=" + date + ", money=" + money + ", discount="
			+ discount + "]";
}

}
