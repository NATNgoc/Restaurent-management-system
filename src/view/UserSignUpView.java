package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import EnumSupport.LoginFormat;
import controller.DAO;
import controller.UserViewSignController;
import model.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserSignUpView extends JFrame {

	
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JTextField txtPhone1;


	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPhone() {
		return txtPhone1;
	}

	public void setTxtPhone(JPasswordField txtPhone1) {
		this.txtPhone1 = txtPhone1;
	}

	/**
	 * Create the application.
	 */
	public UserSignUpView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			setResizable(false);
			initialize();
			this.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		UserViewSignController uvs=new UserViewSignController(this);
		this.addWindowListener(uvs);
		this.setBounds(100, 100, 1165, 674);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 764, 637);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UserSignUpView.class.getResource("/image/11879344_Checklist (1).png")));
		lblNewLabel.setBounds(-89, 31, 876, 606);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(136, 194, 247));
		panel_1.setBounds(758, 0, 406, 637);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN UP");
		lblNewLabel_2.setBounds(143, 59, 123, 44);
		lblNewLabel_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_2.setBackground(new Color(64, 0, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(UserSignUpView.class.getResource("/image/icons8_Account_50px.png")));
		lblNewLabel_3.setBounds(24, 166, 52, 50);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setToolTipText("Enter User Name");
		txtName.setBounds(86, 176, 244, 32);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UserName");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(86, 147, 97, 27);
		panel_1.add(lblNewLabel_4);
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setIcon(new ImageIcon(UserSignUpView.class.getResource("/image/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_3_1.setBounds(24, 241, 52, 50);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(86, 222, 97, 27);
		panel_1.add(lblNewLabel_4_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Enter User Password\r\n\r\n");
		txtPassword.setBounds(86, 251, 244, 32);
		panel_1.add(txtPassword);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnSignUp.setBounds(121, 483, 153, 44);
		btnSignUp.addActionListener(uvs);
		panel_1.add(btnSignUp);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setIcon(new ImageIcon(UserSignUpView.class.getResource("/image/icons8_Secured_Letter_50px.png")));
		lblNewLabel_3_2.setBounds(24, 320, 52, 50);
		panel_1.add(lblNewLabel_3_2);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Enter User Name");
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(86, 330, 244, 32);
		panel_1.add(txtEmail);
		
		JLabel lblNewLabel_4_2 = new JLabel("Email");
		lblNewLabel_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(86, 301, 97, 27);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(UserSignUpView.class.getResource("/image/icons8_Google_Mobile_50px.png")));
		lblNewLabel_3_1_1.setBounds(24, 395, 52, 50);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Phone number");
		lblNewLabel_4_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(86, 376, 130, 27);
		panel_1.add(lblNewLabel_4_1_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnBack.setBounds(121, 543, 153, 44);
		btnBack.addActionListener(uvs);
		panel_1.add(btnBack);
		
		txtPhone1 = new JTextField();
		txtPhone1.setToolTipText("Enter User Name");
		txtPhone1.setForeground(Color.BLACK);
		txtPhone1.setColumns(10);
		txtPhone1.setBounds(86, 405, 244, 32);
		panel_1.add(txtPhone1);
		
		JLabel lblNewLabel_2_1 = new JLabel("create a new account here");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 18));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(101, 97, 214, 32);
		panel_1.add(lblNewLabel_2_1);
	}

	public LoginFormat checkInfo() {
		// TODO Auto-generated method stub
		
		if (txtEmail.getText().length()==0||txtName.getText().length()==0||txtPassword.getText().length()==0||txtPhone1.getText().length()==0) {
			return LoginFormat.Invalid;
		}
		if (txtEmail.getText().matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")==false) {
			return LoginFormat.Email_format;
		} 
		if (txtPhone1.getText().length()>=10) {
			String tmp=txtPhone1.getText();
			for (int i=0;i<txtPhone1.getText().length();i++) {
				if (tmp.charAt(i)<'0'||tmp.charAt(i)>'9') {
					return LoginFormat.Phone;
				}
			}
		}
		ArrayList<User> ds=DAO.getList();
		for (User user : ds) {
			if (txtName.getText().trim().equalsIgnoreCase(user.getName())) {
				return LoginFormat.Name_duplicate;
			} 
			if (txtEmail.getText().trim().equalsIgnoreCase(user.getEmail())) {
				return LoginFormat.Email_duplicate;
			}
		}
		return null;
	}

	public void btnBackClick() {
		// TODO Auto-generated method stub
		UserLoginView loginView=new UserLoginView();
		this.dispose();
	}
}
