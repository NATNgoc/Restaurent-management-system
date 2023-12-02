package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Food;
import model.MyItem;
import view.OrderView;

public class CategoryController implements ItemListener{
	OrderView view;
	
	
	public CategoryController(OrderView view) {
		this.view = view;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange()==ItemEvent.SELECTED) {
			JComboBox food=this.view.getCmbFood();
			JComboBox category=this.view.getCmbCategroy();
			String op=this.view.getCmbCategroy().getSelectedItem().toString();
			if (op!="-Category-") {
				DefaultComboBoxModel<MyItem> model=	new DefaultComboBoxModel();
				ResultSet rs=Food.findFoodByNameCategory(op);
				try {
					while (rs.next()) {
						model.addElement(new MyItem(rs.getString(1), rs.getString(2)));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				food.removeAll();
				food.setModel(model);
			}
		}
	}

	

}
