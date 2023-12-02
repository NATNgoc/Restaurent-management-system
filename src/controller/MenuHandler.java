package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.FoodView;
import view.HomePage;
import view.HomePageView;
import view.OrderView;
import view.StaffView;
import view.StatisticView;

public class MenuHandler implements MouseListener {
	private HomePage view;

	public MenuHandler(HomePage view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(view.getStaffItem())) {
			if (HomePage.userUsing.getPosition().equalsIgnoreCase("admin")) {
				view.setView(new StaffView());
			} else {
				JOptionPane.showMessageDialog(view, "Yêu cầu admin cấp quyền cao hơn");
			}
		} else if (e.getSource().equals(view.getHomeItem())) {
			view.setView(new HomePageView());
		} else if (e.getSource().equals(view.getFoodItem())) {
			if (HomePage.userUsing.getPosition().equalsIgnoreCase("admin")) {
				view.setView(new FoodView());
			} else {
				JOptionPane.showMessageDialog(view, "Yêu cầu admin cấp quyền cao hơn");
			}

		} else if (e.getSource().equals(view.getExitItem())) {
			int op = JOptionPane.showOptionDialog(view, "Thoát chương trình?", "Notice", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null, null, null);
			if (op == JOptionPane.YES_OPTION) {
				try {
					DAO.getDAO().getConnection().close();
					System.out.println("Da ngat ket noi");
					System.exit(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource().equals(view.getOrderItem())) {
			view.setView(new OrderView());
		} else if (e.getSource().equals(view.getStatisticItem())) {
			if (HomePage.userUsing.getPosition().equalsIgnoreCase("admin")) {
				this.view.setView(new StatisticView());
			} else {
				JOptionPane.showMessageDialog(view, "Yêu cầu admin cấp quyền cao hơn");
			}
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

		if (e.getSource().equals(view.getOrderItem())) {
			view.getOrderItem().setBackground(new Color(178, 178, 178));
		}
		if (e.getSource().equals(view.getFoodItem())) {
			view.getFoodItem().setBackground(new Color(178, 178, 178));
		}
		if (e.getSource().equals(view.getStatisticItem())) {
			view.getStatisticItem().setBackground(new Color(178, 178, 178));
		}
		if (e.getSource().equals(view.getStaffItem())) {
			view.getStaffItem().setBackground(new Color(178, 178, 178));
		}
		if (e.getSource().equals(view.getHomeItem())) {
			view.getHomeItem().setBackground(new Color(193, 97, 0));
		}
		if (e.getSource().equals(view.getExitItem())) {
			view.getExitItem().setBackground(new Color(0, 64, 128));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(view.getOrderItem())) {
			view.getOrderItem().setBackground(Color.BLACK);
		}
		if (e.getSource().equals(view.getFoodItem())) {
			view.getFoodItem().setBackground(Color.BLACK);
		}
		if (e.getSource().equals(view.getStatisticItem())) {
			view.getStatisticItem().setBackground(Color.BLACK);
		}
		if (e.getSource().equals(view.getStaffItem())) {
			view.getStaffItem().setBackground(Color.BLACK);
		}
		if (e.getSource().equals(view.getHomeItem())) {
			view.getHomeItem().setBackground(new Color(255, 128, 64));
		}
		if (e.getSource().equals(view.getExitItem())) {
			view.getExitItem().setBackground(new Color(136, 194, 247));
		}
	}

}
