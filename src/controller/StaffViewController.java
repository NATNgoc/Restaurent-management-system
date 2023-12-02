package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Staff;
import view.StaffRegisterForm;
import view.StaffView;
import view.StaffUpdateForm;

public class StaffViewController extends MouseAdapter implements ActionListener {
	StaffView view;

	public StaffViewController(StaffView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(view.getBtnAdd())) {
			new StaffRegisterForm();
		}
		if (e.getSource().equals(view.getBtnSync())) {
			this.view.resetInfomation();
			this.view.updateTable();
			JOptionPane.showMessageDialog(view, "Đã reset lại trang", "Notice", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource().equals(view.getBtnUpdate())) {
			Staff tmp = this.view.getInformation();
			if (tmp != null) {
				new StaffUpdateForm(tmp);
			}
		}
		if (e.getSource().equals(view.getBtnRemove())) {
			JTable table = this.view.getTableStaff();
			int index = table.getSelectedRow();
			if (index != -1) {
				int op = JOptionPane.showOptionDialog(view, "Bạn chắc chắn muốn xóa nhân viên này", "Notice",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if (op == JOptionPane.YES_OPTION) {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					boolean check = Staff.deleteStaff(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
					if (check == true) {
						JOptionPane.showMessageDialog(view, "Delete Succesfully!");
					} else {
						JOptionPane.showMessageDialog(view, "Delete Unsuccesfully!");
					}
				}
			} else {
				JOptionPane.showMessageDialog(view, "Bạn chưa chọn ô để xóa!");
			}
		}
		if (e.getSource().equals(view.getBtnFind())) {
			String tmp=view.getTxtNameForFind().getText().trim();
			if (tmp.length()>0) {
				ArrayList<Staff> listFinded=Staff.findByName(tmp);
				if (listFinded.size()>0) {
					this.view.updateTable(listFinded);
					JOptionPane.showMessageDialog(view, "Tìm thành công!");
				} else {
					JOptionPane.showMessageDialog(view, "Tên không tồn tại!");
				}
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng điền tên muốn tìm");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = this.view.getTableStaff().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableStaff().getModel();
		if (index != -1) {
			Staff tmp = this.view.getInformation();
			this.view.fillInformation(tmp);
		}
	}

}
