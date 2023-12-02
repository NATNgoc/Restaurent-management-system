package controller;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.OrderView;

public class FocusOfDiscount extends FocusAdapter{
	OrderView view;
	
	
	public FocusOfDiscount(OrderView view) {
		this.view = view;
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	if (e.getSource().equals(this.view.getTxtNumDiscount())) {
		String regrex="^\\d+$";
		String num=this.view.getTxtNumDiscount().getText();
			if (num.matches(regrex)==false||num.length()>2) {
				this.view.getTxtNumDiscount().setText("0");
			}
	}
	}

}
