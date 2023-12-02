package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import EnumSupport.AddFormat;
import model.Food;
import model.FoodCategory;
import view.FoodAddForm;
import view.FoodCategoryAddForm;
import view.FoodCategoryUpdateForm;
import view.FoodUpdateForm;
import view.FoodView;

public class FoodViewController implements ActionListener, MouseListener {
	FoodView view;

	public FoodViewController(FoodView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//
		// Phần Food
		//
		if (e.getSource().equals(view.getBtnAdd())) {
			new FoodAddForm(this.view);
		}
		if (e.getSource().equals(view.getBtnEdit())) {
			int op = view.getTableFood().getSelectedRow();
			if (op != -1)
				new FoodUpdateForm(view);
			else
				JOptionPane.showMessageDialog(view, "Vui lòng chọn cột muốn thay đổi!");
		}
		if (e.getSource().equals(view.getBtnRemove())) {
			int op = view.getTableFood().getSelectedRow();
			if (op == -1) {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn cột muốn xóa!");
			} else {
				DefaultTableModel tabelModel = (DefaultTableModel) view.getTableFood().getModel();
				if (Food.deleteFoodById(tabelModel.getValueAt(op, 0) + "") == true) {
					JOptionPane.showMessageDialog(view, "Xóa thành công!");
					this.view.updateTableFood();
				} else {
					JOptionPane.showMessageDialog(view, "Xóa không thành công vì có phiếu yêu cầu đang dùng món ăn đó!");
				}

			}
		}
		if (e.getSource().equals(view.getBtnSync())) {
			this.view.updateTableFood();
			JOptionPane.showMessageDialog(view, "Đã cập nhật lại bảng");
		}
		if (e.getSource().equals(view.getBtnFind())) {
			if (this.view.getTxtFind().getText().trim().equals("")) {
				JOptionPane.showMessageDialog(view, "Điền đầy đủ thông tin!");
			} else {
				this.view.updateTableFoodFinding(Food.findFoodByName(this.view.getTxtFind().getText()));
			}
		}
		// --------------------
		//
		// Phần Food Category
		//
		if (e.getSource().equals(view.getBtnAddCategory())) {
			new FoodCategoryAddForm(this.view);
		}
		if (e.getSource().equals(view.getBtnEditCategory())) {
			JTable table = this.view.getTableCategory();
			if (table.getSelectedRow() != -1) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				new FoodCategoryUpdateForm(this.view);
			} else {
				JOptionPane.showMessageDialog(this.view, "Vui lòng chọn cột muốn thay đổi");
			}

		}
		if (e.getSource().equals(view.getBtnSyncCategory())) {
			this.view.updateTableCategory();
			JOptionPane.showMessageDialog(this.view, "Đã cập nhật lại bảng");
		}
		if (e.getSource().equals(view.getBtnRemoveCategory())) {
			JTable table = this.view.getTableCategory();
			if (table.getSelectedRow() != -1) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				boolean check = FoodCategory.deleteById(tableModel.getValueAt(this.view.getTableCategory().getSelectedRow(), 0) + "");
				if (check == true) {
					JOptionPane.showMessageDialog(this.view, "Đã xóa thành công!");
					this.view.updateTableCategory();
				} else {
					JOptionPane.showMessageDialog(this.view, "Không thành công vì có phiếu yêu cầu đang dùng món ăn đó!");
				}

			} else {
				JOptionPane.showMessageDialog(this.view, "Vui lòng chọn cột muốn xóa!");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(view.getTableFood())) {
			int index = view.getTableFood().getSelectedRow();
			if (index != -1)
				this.view.getInformationFoodFromTable();
		} else if (e.getSource().equals(view.getTableCategory())) {
			int index = view.getTableCategory().getSelectedRow();
			if (index != -1)
				this.view.getInformationFoodCategoryFromTable();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
