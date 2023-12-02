package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;

import EnumSupport.CardLayoutSP;
import model.Order;
import model.OrderDetail;
import model.Table;
import view.OrderView;

public class TableOderController implements ActionListener{
	OrderView view;
	
	public TableOderController(OrderView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton tmp=(JButton)e.getSource();
		view.setTableIsSelecting((model.Table) tmp.getClientProperty("tag"));
		if (view.getTableIsSelecting().getStatus()==0) {
			view.setViewForCard(CardLayoutSP.PreOrder);
		} else {
			this.view.getTxtTableIsDisplay().setText(this.view.getTableIsSelecting().getId());
			view.setViewForCard(CardLayoutSP.Order);
			this.view.resetPnOrder();
			ResultSet kp=OrderDetail.getListOfOrderDetailByIdOrder(Order.findOrderByIdTable(this.view.getTableIsSelecting().getId()));
			this.view.updateTableOrder(kp);
		}
		 
	}
	
}
