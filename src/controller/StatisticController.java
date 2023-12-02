package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import EnumSupport.AddFormat;
import model.Bill;
import view.StatisticView;

public class StatisticController implements ActionListener {
	StatisticView view;

	public StatisticController(StatisticView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		// TODO Auto-generated method stub
		Date from=this.view.getDateFrom().getDate();
		Date to=this.view.getDateTo().getDate();
		AddFormat check=this.view.checkInFo();
		if (check==null) {
			String strFrom=new SimpleDateFormat("yyyy-MM-dd").format(from)+" 00:00:00";
			String strTo=new SimpleDateFormat("yyyy-MM-dd").format(to)+" 23:59:59";
			System.out.println("da do");
			System.out.println(strFrom+"   "+strTo);
			 ResultSet rs=Bill.getResultBetween2Day(strFrom,strTo);
			 if (rs!=null) {
				 System.out.println("da do do");
				 DefaultTableModel tableModel=(DefaultTableModel) this.view.getTableMain().getModel();
				 tableModel.setRowCount(0);
				 try {
					while (rs.next()) {
						tableModel.addRow(new Object[] {
								rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4)+"",rs.getInt(5)
						});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 } 
		} else if (check==AddFormat.Wrong) {
			JOptionPane.showMessageDialog(view, "Thông tin trống hoặc đã chỉnh sửa ô ngày tháng!");
		} else if (check==AddFormat.DateSmall) {
			JOptionPane.showMessageDialog(view, "Ngày bắt đầu phải nhỏ hơn Ngày kết thúc");
		}
	}
	
	
}	
