package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.FoodCategory;
import view.FoodCategoryAddForm;
import view.FoodCategoryUpdateForm;

public class FoodCTUpdateController implements ActionListener {
	FoodCategoryUpdateForm view;
	

	public FoodCTUpdateController(FoodCategoryUpdateForm view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (view.getTxtName().getText().trim().length() > 0) {
			FoodCategory tmp = new FoodCategory(view.getTxtId().getText(), view.getTxtName().getText().trim());
			if (FoodCategory.UpdateFoodCategory(tmp)) {
				JOptionPane.showMessageDialog(view, "Update Successfully!");
				this.view.dispose();
				this.view.getRoot().updateTableCategory();
			} else { 
				JOptionPane.showMessageDialog(view, "Check again!");
			}
		} else {
			JOptionPane.showMessageDialog(view, "Nhập đầy đủ thông tin!");
		}
	}
}
