package view;

import javax.swing.JPanel;


import com.toedter.calendar.JDateChooser;

import EnumSupport.AddFormat;
import controller.StatisticController;
import model.Bill;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;

public class StatisticView extends JPanel {
	private JTable tableMain;
	private JLabel txtPageCurrent;
	private JLabel txtSumOfPage;
	private JDateChooser dateTo;
	private JDateChooser dateFrom;
	/**
	 * Create the panel.
	 */
	public StatisticView() {
		setBackground(new Color(255, 255, 255));
		init();
		this.setVisible(true);
	}

	private void init() {
		StatisticController conn=new StatisticController(this);
		this.setSize(1019,730);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 206, 999, 514);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableMain = new JTable();
		tableMain.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID PTT", "ID PYC", "Date bill", "Money", "Discount"
			}
		));
		scrollPane.setViewportView(tableMain);
		
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 137, 52, 43);
		add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblTo.setBounds(361, 137, 28, 43);
		add(lblTo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(StatisticView.class.getResource("/image/icons8-enter-35.png")));
		btnNewButton.setBounds(599, 137, 52, 43);
		btnNewButton.addActionListener(conn);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StatisticView.class.getResource("/image/icons8-circled-right-40.png")));
		lblNewLabel_1.setBounds(957, 137, 52, 43);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(StatisticView.class.getResource("/image/icons8-circled-right-40 (1).png")));
		lblNewLabel_1_1.setBounds(907, 137, 40, 43);
		add(lblNewLabel_1_1);
		
		txtSumOfPage = new JLabel("0");
		txtSumOfPage.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtSumOfPage.setBounds(981, 179, 28, 27);
		add(txtSumOfPage);
		
		
		JLabel txtSumOfPage_1 = new JLabel("/");
		txtSumOfPage_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		txtSumOfPage_1.setBounds(950, 179, 6, 27);
		add(txtSumOfPage_1);
		
		txtPageCurrent = new JLabel("0");
		txtPageCurrent.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		txtPageCurrent.setBounds(914, 179, 28, 27);
		add(txtPageCurrent);
		
		dateTo = new JDateChooser();
		dateTo.setBounds(399, 137, 159, 43);
		add(dateTo);
		
		dateFrom = new JDateChooser();
		dateFrom.setBounds(86, 137, 159, 43);
		add(dateFrom);
		
	}

	public JDateChooser getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(JDateChooser dateFrom) {
		this.dateFrom = dateFrom;
	}

	public JDateChooser getDateTo() {
		return dateTo;
	}

	public void setDateTo(JDateChooser dateTo) {
		this.dateTo = dateTo;
	}

	public JLabel getTxtPageCurrent() {
		return txtPageCurrent;
	}

	public void setTxtPageCurrent(JLabel txtPageCurrent) {
		this.txtPageCurrent = txtPageCurrent;
	}

	public JLabel getTxtSumOfPage() {
		return txtSumOfPage;
	}

	public void setTxtSumOfPage(JLabel txtSumOfPage) {
		this.txtSumOfPage = txtSumOfPage;
	}
	
	public JTable getTableMain() {
		return tableMain;
	}

	public void setTableMain(JTable tableMain) {
		this.tableMain = tableMain;
	}

	public AddFormat checkInFo() {
		try {
			String dateFrom=this.dateFrom.getDate().toString().trim();
			String dateTo=this.dateTo.getDate().toString().trim();
			if (dateFrom.length()==0||dateTo.length()==0) return AddFormat.null_Info;
			int distance=(int) (this.dateTo.getDate().getTime()-this.dateFrom.getDate().getTime());
			if (distance<0){
				return AddFormat.DateSmall;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return AddFormat.Wrong;
		} 
		return null;
		
	}
}
