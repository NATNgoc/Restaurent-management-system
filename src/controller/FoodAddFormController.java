package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import EnumSupport.AddFormat;
import model.Food;
import model.FoodCategory;
import view.FoodAddForm;
import view.FoodView;

public class FoodAddFormController implements ActionListener{
	FoodAddForm view;
	
	
	public FoodAddFormController(FoodAddForm view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(view.getBtnAdd())) {
			AddFormat checkFormat=this.check();
			if (checkFormat==null) {
				Food tmp=new Food();
				tmp.setId(view.getTxtId().getText());
				tmp.setIdCategory(FoodCategory.findFoodCategoryIDByName(view.getCmbCategory().getSelectedItem().toString()));
				tmp.setName(view.getTxtName().getText());
				tmp.setPrice(Double.parseDouble(view.getTxtPrice().getText()));
				tmp.setUnit(view.getCmbUnit().getSelectedItem().toString());
				boolean checkAdd = Food.addFood(tmp);
				if (checkAdd==true) {
					JOptionPane.showMessageDialog(view, "Add succesfully!");
					this.view.dispose();
					this.view.getRoot().updateTableFood();
				} else {
					JOptionPane.showMessageDialog(view, "Check again!");
				} 
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
