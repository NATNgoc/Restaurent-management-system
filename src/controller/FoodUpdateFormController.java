package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import EnumSupport.AddFormat;
import model.Food;
import model.FoodCategory;
import view.FoodUpdateForm;
import view.FoodView;

public class FoodUpdateFormController implements ActionListener {
	FoodUpdateForm view;
	
	public FoodUpdateFormController(FoodUpdateForm view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(view.getBtnUpdate())) {
			AddFormat checkFormat=this.check();
			if (checkFormat==null) {
				Food tmp=new Food();
				tmp.setId(view.getTxtId().getText());
				tmp.setIdCategory(FoodCategory.findFoodCategoryIDByName(view.getCmbCategory().getSelectedItem().toString()));
				tmp.setName(view.getTxtName().getText());
				tmp.setPrice(Double.parseDouble(view.getTxtPrice().getText()));
				tmp.setUnit(view.getCmbUnit().getSelectedItem().toString());
				boolean checkAdd = Food.updateFood(tmp);
				if (checkAdd==true) {
					JOptionPane.showMessageDialog(view, "Update succesfully!");
					this.view.getRoot().updateTableFood();
				} else {
					JOptionPane.showMessageDialog(view, "Check again!");

				} 
			this.view.dispose();
			} else if (checkFormat==AddFormat.null_Info) {
				JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin!");
			} else if (checkFormat==AddFormat.Price) {
				JOptionPane.showMessageDialog(view, "Giá phải chỉ được chứa số");
			}
		}
	}
	 
	public AddFormat check() {
		if (view.getTxtName().getText().length()==0||view.getTxtPrice().getText().length()==0
				||view.getCmbCategory().getSelectedItem().toString().equalsIgnoreCase("-category-")
				||view.getCmbUnit().getSelectedItem().toString().equalsIgnoreCase("-unit-")) {
			return AddFormat.null_Info;
		}
		String price=this.view.getTxtPrice().getText();
		if (price.matches("^[0-9]*$")==false) {
			return AddFormat.Price;
		}
		return null;
	}
}
