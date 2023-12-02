package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.HomePage;
import view.UserLoginView;
import view.UserSignUpView;

public class UserViewLoginController implements ActionListener, WindowListener {
	UserLoginView view;
	
	public UserViewLoginController(UserLoginView view) {
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if (e.getSource().equals(this.view.getBtnLogin())) {
		if (view.getTxtName().getText().length()>0&&view.getTxtPassword().getText().length()>0) {
			boolean check=false;
			check=DAO.getDAO().Login(view.getTxtName().getText(),view.getTxtPassword().getText());
			if (check==true) {
				this.view.dispose();
				new HomePage().setVisible(true);
			} else {	
				JOptionPane.showMessageDialog(view, "Check name or password again!");
			}
	
			} else {
				JOptionPane.showMessageDialog(view, "Empty Information");
			}
	} else if (e.getActionCommand().equalsIgnoreCase("sign up")) {
		this.view.signUpClick();
	}
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		try {
			DAO.getDAO().getConnection().close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
