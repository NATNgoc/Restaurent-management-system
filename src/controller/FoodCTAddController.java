package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.FoodCategory;
import view.FoodCategoryAddForm;

public class FoodCTAddController implements ActionListener {
	FoodCategoryAddForm view;

	public FoodCTAddController(FoodCategoryAddForm view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (view.getTxtName().getText().trim().length()>0) {
			FoodCategory tmp=new FoodCategory(view.getTxtID().getText(), view.getTxtName().getText().trim());
			if (FoodCategory.AddFoodCategory(tmp)) {
				JOptionPane.showMessageDialog(view, "Add succefully!");
				view.dispose();
				view.getRoot().updateTableCategory();
			} else {
				JOptionPane.showMessageDialog(view, "Check again!");
			}
			
		} else {
			JOptionPane.showMessageDialog(view, "Nhập đầy đủ thông tin!");
		}
	}

	public FoodCategoryAddForm getView() {
		return view;
	}

	public void setView(FoodCategoryAddForm view) {
		this.view = view;
	}
	
	
	
}
