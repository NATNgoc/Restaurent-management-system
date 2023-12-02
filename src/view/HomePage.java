package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rojeru_san.complementos.RSTableMetro;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import controller.HomeListener;
import controller.MenuHandler;
import model.Staff;
import model.User;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JProgressBar;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JLabel oderTxt;
	private JLabel staffTxt;
	private JLabel statisticTxt;
	private JLabel foodITxt;
	private JLabel ExitITxt;
	private JPanel mainPanel;
	private JLabel HomePageTxt;
	private JPanel FoodItem;
	private JPanel StatisticItem;
	private JPanel StaffItem;
	private JPanel OrderItem;
	private JPanel HomeItem;
	private JPanel ExitItem;
	private JPanel itemChoosed;
	public  static User userUsing;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {

		MenuHandler mHand = new MenuHandler(this);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1383, 821);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.addWindowListener(new HomeListener(this));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(136, 194, 247));
		panel_1.setBounds(0, 0, 1369, 55);
		contentPane.add(panel_1);

		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8-restaurant-40.png")));
		lblNewLabel.setBounds(21, 5, 52, 45);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(83, 5, 3, 45);
		panel_1.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Restaurent management");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(103, 7, 361, 40);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Welcome, Admin");
		lblNewLabel_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/image/male_user_50px.png")));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(1123, 1, 288, 57);
		panel_1.add(lblNewLabel_1_1);

		JPanel pnMenu = new JPanel();
		pnMenu.setLayout(null);
		pnMenu.setBackground(new Color(0, 0, 0));
		pnMenu.setBounds(0, 54, 351, 794);
		contentPane.add(pnMenu);

		FoodItem = new JPanel();
		FoodItem.setBackground(new Color(0, 0, 0));
		FoodItem.setForeground(new Color(0, 0, 0));
		FoodItem.setBounds(0, 486, 351, 56);
		FoodItem.addMouseListener(mHand);
		pnMenu.add(FoodItem);
		FoodItem.setLayout(null);

		foodITxt = new JLabel("Food ");
		foodITxt.setForeground(new Color(128, 128, 128));
		foodITxt.setBounds(24, 16, 86, 30);
		foodITxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8-hamburger-26.png")));
		foodITxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		FoodItem.add(foodITxt);

		StatisticItem = new JPanel();
		StatisticItem.setBackground(new Color(0, 0, 0));
		StatisticItem.setForeground(new Color(0, 0, 0));
		StatisticItem.setBounds(0, 390, 351, 56);
		StatisticItem.addMouseListener(mHand);
		pnMenu.add(StatisticItem);
		StatisticItem.setLayout(null);

		statisticTxt = new JLabel("Statistic");
		statisticTxt.setForeground(new Color(128, 128, 128));
		statisticTxt.setBounds(26, 13, 103, 27);
		statisticTxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8_Sell_26px.png")));
		statisticTxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		StatisticItem.add(statisticTxt);

		StaffItem = new JPanel();
		StaffItem.setBackground(new Color(0, 0, 0));
		StaffItem.setForeground(new Color(0, 0, 0));
		StaffItem.setBounds(0, 294, 351, 56);
		StaffItem.addMouseListener(mHand);
		pnMenu.add(StaffItem);
		StaffItem.setLayout(null);

		staffTxt = new JLabel("Staff");
		staffTxt.setForeground(new Color(128, 128, 128));
		staffTxt.setBounds(26, 13, 73, 27);
		staffTxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8_Conference_26px.png")));
		staffTxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		StaffItem.add(staffTxt);

		OrderItem = new JPanel();
		OrderItem.setBackground(new Color(0, 0, 0));
		OrderItem.setForeground(new Color(0, 0, 0));
		OrderItem.setLayout(null);
		OrderItem.setBounds(0, 202, 351, 56);
		OrderItem.addMouseListener(mHand);
		pnMenu.add(OrderItem);

		oderTxt = new JLabel("Order");
		oderTxt.setForeground(new Color(128, 128, 128));
		oderTxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8-customer-26.png")));
		oderTxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		oderTxt.setBounds(26, 10, 140, 34);
		OrderItem.add(oderTxt);

		HomeItem = new JPanel();
		HomeItem.setBackground(new Color(255, 128, 64));
		HomeItem.setBounds(0, 46, 351, 56);
		HomeItem.addMouseListener(mHand);
		pnMenu.add(HomeItem);
		HomeItem.setLayout(null);

		HomePageTxt = new JLabel("Home Page");
		HomePageTxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/home_24px.png")));
		HomePageTxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		HomePageTxt.setBounds(26, 10, 140, 34);
		HomeItem.add(HomePageTxt);

		JLabel lblNewLabel_3 = new JLabel("Features");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(192, 192, 192));
		lblNewLabel_3.setBounds(26, 136, 183, 36);
		pnMenu.add(lblNewLabel_3);

		ExitItem = new JPanel();
		ExitItem.setBounds(0, 580, 351, 55);
		ExitItem.addMouseListener(mHand);
		pnMenu.add(ExitItem);
		ExitItem.setLayout(null);
		ExitItem.setBackground(new Color(136, 194, 247));

		ExitITxt = new JLabel("Exit");
		ExitITxt.setIcon(new ImageIcon(HomePage.class.getResource("/image/icons8_Exit_26px.png")));
		ExitITxt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ExitITxt.setBounds(26, 11, 140, 34);
		ExitItem.add(ExitITxt);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(350, 54, 1019, 730);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		this.setView(new HomePageView());
	}
	// Getter and Setter for component

	public JPanel getFoodItem() {
		return FoodItem;
	}

	public JPanel getStatisticItem() {
		return StatisticItem;
	}

	public JPanel getStaffItem() {
		return StaffItem;
	}

	public JPanel getOrderItem() {
		return OrderItem;
	}



	public User getUserUsing() {
		return userUsing;
	}

	

	public JPanel getHomeItem() {
		return HomeItem;
	}

	

	public JPanel getExitItem() {
		return ExitItem;
	}

	public void setItemChoosed(JPanel itemChoosed) {
		this.itemChoosed = itemChoosed;
	}

	// Phương thức chuyển view
	public void setView(JPanel viewChange) {
		// TODO Auto-generated method stub
		this.mainPanel.removeAll();
		this.mainPanel.add(viewChange);
		this.repaint();
		this.revalidate();
	}
}
