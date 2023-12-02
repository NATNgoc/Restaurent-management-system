package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import EnumSupport.AddFormat;
import EnumSupport.LoginFormat;
import model.Staff;
import view.StaffRegisterForm;
import java.util.Date;
public class StaffRegisterFormController implements ActionListener {
	StaffRegisterForm view;
	
	public StaffRegisterFormController(StaffRegisterForm view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AddFormat check=this.check();
		if (check==null) {
			Staff tmp=new Staff();
			tmp.setIDNV(view.getTxtId().getText());
			tmp.setName(view.getTxtName().getText());
			tmp.setChucVu(view.getCmbPosition().getSelectedItem().toString());
			tmp.setSex(view.getRdbtnMale().isSelected()==true?1:0);
			try {
				tmp.setNgayLamViec(new SimpleDateFormat("dd/MM/yyyy").parse(view.getTxtDateOfWork().getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
			tmp.setPhoneNumber(view.getTxtPhone().getText());
			tmp.setAddress(view.getTxtAddress().getText());
			boolean checkAdd=Staff.addStaff(tmp);
			if (checkAdd==true) {
				JOptionPane.showMessageDialog(view, "Add successfully!");
				view.dispose();
			} else {
				JOptionPane.showMessageDialog(view, "Add unsuccessfully!");
				view.dispose();
			}
		} else if (check==AddFormat.null_Info) {
			JOptionPane.showMessageDialog(view, "Điền đầy đủ thông tin!");
		} else if (check==AddFormat.Date) {
			JOptionPane.showMessageDialog(view, "Định dạng ngày phải là dd/mm/yyyy\n"+"Vd: 27/04/2003");
		} else if (check==AddFormat.Name) {
			JOptionPane.showMessageDialog(view, "Tên phải chứa ít nhất 10 ký tự");
		} else if (check==AddFormat.Phone) {
			JOptionPane.showMessageDialog(view, "Số điện thoại không đúng");
		}
		
	}
	
	public AddFormat check() {
		if (view.getTxtName().getText().length()==0||view.getTxtPhone().getText().length()==0
				||view.getTxtAddress().getText().length()==0
				||view.getTxtDateOfWork().getText().length()==0
				||view.getCmbPosition().getSelectedItem().toString().equalsIgnoreCase("-position-")) {
			return AddFormat.null_Info;
		}
		String regex="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		if (view.getTxtPhone().getText().length()>=10) {
			String tmp=view.getTxtPhone().getText();
			for (int i=0;i<view.getTxtPhone().getText().length();i++) {
				if (tmp.charAt(i)<'0'||tmp.charAt(i)>'9') {
					return AddFormat.Phone;
				}
			}
		} 
		if (view.getTxtDateOfWork().getText().matches(regex)==false) {
			return AddFormat.Date;
		}
		if (view.getTxtName().getText().length()<10) {
			return AddFormat.Name;
		}
		
		return null;
	}
}
