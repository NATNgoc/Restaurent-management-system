package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import EnumSupport.LoginFormat;
import model.User;
import view.UserLoginView;
import view.UserSignUpView;

public class UserViewSignController implements WindowListener, ActionListener {
	UserSignUpView view;
	
	public UserViewSignController(UserSignUpView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equalsIgnoreCase("Sign Up")) {
			LoginFormat checkInfomation=this.view.checkInfo();
			if (checkInfomation==null) { 
				ArrayList<User> ds=DAO.getList();
				int id=1;
				boolean check=false;
				for (User user : ds) {
					if (user.getId()==id) {
						id++;
					} else {
						check=true;
						break;
					}
				}
				User tmp;
				if (check==true) {
					tmp=new User(id++,this.view.getTxtName().getText().trim(),this.view.getTxtPassword().getText().trim()
							,this.view.getTxtEmail().getText().trim(),this.view.getTxtPhone().getText().trim(),"");
				} else {
					tmp=new User(id,this.view.getTxtName().getText().trim(),this.view.getTxtPassword().getText().trim()
							,this.view.getTxtEmail().getText().trim(),this.view.getTxtPhone().getText().trim(),"");
				}
				if (DAO.addUser(tmp)) {
					JOptionPane.showMessageDialog(view, "Add successfully!");
					this.view.dispose();
					UserLoginView temp=new UserLoginView();
					temp.setLocationRelativeTo(null);
					temp.setVisible(true);
				} 
			} else if (checkInfomation.equals(LoginFormat.Email_format)) {
				JOptionPane.showMessageDialog(view,"Email has wrong format");
			} else if (checkInfomation.equals(LoginFormat.Phone)) {
				JOptionPane.showMessageDialog(view, "Wrong phone!");
			} else if (checkInfomation.equals(LoginFormat.Email_duplicate)) {
				JOptionPane.showMessageDialog(view,"Email has been already signed up!");
			} else if (checkInfomation.equals(LoginFormat.Name_duplicate)) {
				JOptionPane.showMessageDialog(view,"Name has been already signed up!");
			}
			else {
				JOptionPane.showMessageDialog(view, "Empty information!");
			}
		} else if (e.getActionCommand().equalsIgnoreCase("back")) {
			this.view.btnBackClick();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.view.dispose();
		UserLoginView tmp=new UserLoginView();
		tmp.setLocationRelativeTo(null);
		tmp.setVisible(true);
		
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
