package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import controller.DAO;

public class Staff {
	private String IDNV;
	private String Name;
	private String address;
	private String PhoneNumber;
	private int sex;
	private String ChucVu;
	private java.util.Date NgayLamViec;
	public Staff(String iDNV, String name, String address, String phoneNumber, int sex, String chucVu,
			java.util.Date ngayLamViec) {
		IDNV = iDNV;
		Name = name;
		this.address = address;
		PhoneNumber = phoneNumber;
		this.sex = sex;
		ChucVu = chucVu;
		NgayLamViec = ngayLamViec;
	}
	public Staff() {
		
	}
	public String getIDNV() {
		return IDNV;
	}
	public void setIDNV(String iDNV) {
		IDNV = iDNV;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public java.util.Date getNgayLamViec() {
		return NgayLamViec;
	}
	public void setNgayLamViec(java.util.Date ngayLamViec) {
		NgayLamViec = ngayLamViec;
	}
	
	public static ResultSet getListOfStaffRS() {
		Connection conn=DAO.getDAO().getConnection();
		ResultSet rs=null;
		String sql ="Select * from nhanvien";
		try {
			PreparedStatement pr=conn.prepareStatement(sql);
			rs=pr.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	
	public static ArrayList<Staff> findByName(String name) {
		ArrayList<Staff> ds=new ArrayList<>();
		Connection conn=DAO.getDAO().getConnection();
		String sql ="Select * from nhanvien where HoTenNV like ?";
		try {
			PreparedStatement pr=conn.prepareStatement(sql);
			name='%'+name+'%';
			pr.setString(1, name);
			ResultSet rs=pr.executeQuery();
			while (rs.next()) {
				Staff tmp=new Staff();
				tmp.setIDNV(rs.getString(1));
				tmp.setName(rs.getString(2));
				tmp.setAddress(rs.getString(3));
				tmp.setPhoneNumber(rs.getString(4));
				tmp.setSex(rs.getInt(5));
				tmp.setChucVu(rs.getString(6));
				tmp.setNgayLamViec(rs.getDate(7));
				ds.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ds;
	}
	
	public static ArrayList<Staff> getListOfStaffAR() {
		ArrayList<Staff> ds=new ArrayList<>();
		Connection conn=DAO.getDAO().getConnection();
		String sql ="Select * from nhanvien";
		try {
			PreparedStatement pr=conn.prepareStatement(sql);
			ResultSet rs=pr.executeQuery();
			while (rs.next()) {
				Staff tmp=new Staff();
				tmp.setIDNV(rs.getString(1));
				tmp.setIDNV(rs.getString(1));
				tmp.setName(rs.getString(2));
				tmp.setAddress(rs.getString(3));
				tmp.setPhoneNumber(rs.getString(4));
				tmp.setSex(rs.getInt(5));
				tmp.setChucVu(rs.getString(6));
				tmp.setNgayLamViec(rs.getDate(7));
				ds.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ds;
	}
	
	public static int getSizeOfStaff() {
			String sql="Select count(*) from nhanvien";
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
	
	public static boolean deleteStaff(String id) {
		Connection conn=DAO.getDAO().getConnection();
		try {
			String sql="DELETE FROM nhanvien WHERE IDNV=?";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(1, id);
			return pr.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	
	public static boolean updateStaff(Staff tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql="UPDATE nhanvien\n"
				+ "SET HoTenNV=?, DiaChiNV=?, SoDTNV=?,GioiTinhNV=?,ChucVuNV=?,NgayLamViec=?\n"
				+ "WHERE IDNV=?";
		try {
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(7, tmp.getIDNV());
			pr.setString(1, tmp.getName());
			pr.setString(2, tmp.getAddress());
			pr.setString(3, tmp.getPhoneNumber());
			pr.setInt(4, tmp.getSex());
			pr.setString(5, tmp.getChucVu());
			pr.setDate(6, new Date(tmp.getNgayLamViec().getTime()));
			return pr.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public static boolean addStaff(Staff tmp) {
		Connection conn=DAO.getDAO().getConnection();
		String sql="Insert into nhanvien "+
		"Values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tmp.getIDNV());
			ps.setString(2, tmp.getName());
			ps.setString(3, tmp.getAddress());
			ps.setString(4, tmp.getPhoneNumber());
			ps.setInt(5, tmp.getSex());
			ps.setString(6, tmp.getChucVu());
			ps.setDate(7, new Date(tmp.getNgayLamViec().getTime()));
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi cho add Staff");
			e.printStackTrace();
		} 
		return false;
	}
	 
	
	
}
