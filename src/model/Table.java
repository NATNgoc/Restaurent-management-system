package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DAO;

public class Table {
	String id;
	int status;
	public static final int heightTable=85;
	public static final int widthTable=90;
	public Table() {

	}

	public Table(String id, int status) {

		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static boolean closeTable(String idTB) {
		Connection con=DAO.getDAO().getConnection();
		try {
			String sql="update banan set status=0 where idBA=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, idTB);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean openTable(String idTB) {
		Connection con=DAO.getDAO().getConnection();
		try {
			String sql="update banan set status=1 where idBA=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, idTB);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static ResultSet getListOfTable() {
		Connection conn=DAO.getDAO().getConnection();
		ResultSet rs=null;
		try {
			String sql="select * from banan";
			PreparedStatement ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static boolean checkStatus(String idTable) {
		String sql="select count(*) from banan where idBA=? and status = 0";
		try {
			Connection con=DAO.getDAO().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, idTable);
			ResultSet rs=ps.executeQuery();
			rs.next();
			return rs.getInt(1)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		return this.id;
	}
	
	public static boolean changeTable(String idOrder, String idTableChange) {
		
		String sql="update phieuyeucau set idBA=? where idPYC=? ";
		Connection conn=DAO.getDAO().getConnection();
		boolean check=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(2, idOrder);
			ps.setString(1, idTableChange);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return check;
	}


	
}
