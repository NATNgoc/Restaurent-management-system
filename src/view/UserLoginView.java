package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DAO;
import controller.UserViewLoginController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class UserLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	public JTextField getTextField() {
		return txtName;
	}

	public void setTextField(JTextField textField) {
		this.txtName = textField;
	}

	public JPasswordField getPasswordField() {
		return txtPassword;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.txtPassword = passwordField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UserLoginView frame = new UserLoginView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLoginView() {
		init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		setResizable(false);
		UserViewLoginController logCon = new UserViewLoginController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 671, 594);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/Screenshot 2023-03-02 163309.png")));
		lblNewLabel.setBounds(20, 105, 628, 529);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/Untitled Design_1 (1).png")));
		lblNewLabel_1.setBounds(-16, 10, 304, 70);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(136, 194, 247));
		panel_1.setBounds(673, 0, 398, 594);
		contentPane.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("LOGIN\r\n\r\n");
		lblNewLabel_2.setForeground(new Color(64, 0, 0));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		lblNewLabel_2.setBackground(new Color(64, 128, 128));
		lblNewLabel_2.setBounds(153, 55, 97, 44);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/icons8_Account_50px.png")));
		lblNewLabel_3.setBounds(24, 166, 52, 50);
		panel_1.add(lblNewLabel_3);

		txtName = new JTextField();
		txtName.setToolTipText("Enter User Name");
		txtName.setForeground(Color.BLACK);
		txtName.setColumns(10);
		txtName.setBounds(86, 176, 244, 32);
		panel_1.add(txtName);

		JLabel lblNewLabel_4 = new JLabel("UserName");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(86, 147, 97, 27);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1
				.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_3_1.setBounds(24, 241, 52, 50);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(86, 222, 97, 27);
		panel_1.add(lblNewLabel_4_1);
		this.setLocationRelativeTo(null);
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Enter User Password\r\n\r\n");
		txtPassword.setBounds(86, 251, 244, 32);
		panel_1.add(txtPassword);

		btnLogin = new JButton("ENTER");
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnLogin.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/icons8-login-rounded-35.png")));
		btnLogin.setBounds(133, 309, 120, 38);
		btnLogin.addActionListener(logCon);
		
		panel_1.add(btnLogin);

		JLabel lblNewLabel_5_1 = new JLabel("Sign up for a new account");
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(10, 381, 205, 27);
		panel_1.add(lblNewLabel_5_1);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setIcon(new ImageIcon(UserLoginView.class.getResource("/image/icons8-sign-up-38.png")));
		btnSignUp.addActionListener(logCon);

		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignUp.setBounds(37, 417, 133, 50);
		panel_1.add(btnSignUp);

		JLabel lblNewLabel_2_1 = new JLabel("welcome to restaurent ");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 17));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(112, 91, 191, 32);
		panel_1.add(lblNewLabel_2_1);

	}

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

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void signUpClick() {
		UserSignUpView uvs = new UserSignUpView();
		this.dispose();
	}
}
