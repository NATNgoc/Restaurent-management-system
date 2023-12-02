package view;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;

import model.Bill;
import model.Order;
import model.Staff;

import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HomePageView extends JPanel {

	private JLabel txtNumStaff;
	private JLabel txtNumOrder;
	private JLabel txtNumRevenue;
	private JTable tableStaff;
	private JTable tableOrder;
	/**
	 * Create the panel.
	 */
	public HomePageView() {
		init();
		this.setVisible(true);	
	}
	private void init() {
		// TODO Auto-generated method stub
		setLayout(null);
		this.setSize(1019, 730);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1019, 730);
		add(mainPanel);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(207, 207, 209));
		panel_4.setBounds(55, 75, 212, 129);
		mainPanel.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 128, 0));
		panel_5.setBounds(0, 0, 212, 16);
		panel_4.add(panel_5);

		txtNumStaff = new JLabel("0");
		txtNumStaff.setForeground(Color.GRAY);
		txtNumStaff.setFont(new Font("Segoe UI Semibold", Font.BOLD, 54));
		txtNumStaff.setBounds(10, 37, 202, 60);
		panel_4.add(txtNumStaff);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(207, 207, 209));
		panel_4_1.setBounds(314, 75, 212, 129);
		mainPanel.add(panel_4_1);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(0, 64, 128));
		panel_5_1.setBounds(0, 0, 212, 16);
		panel_4_1.add(panel_5_1);

		txtNumOrder = new JLabel("0");
		txtNumOrder.setForeground(Color.GRAY);
		txtNumOrder.setFont(new Font("Segoe UI Semibold", Font.BOLD, 54));
		txtNumOrder.setBounds(10, 37, 202, 60);
		panel_4_1.add(txtNumOrder);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(new Color(207, 207, 209));
		panel_4_2.setBounds(573, 75, 407, 129);
		mainPanel.add(panel_4_2);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(new Color(98, 0, 49));
		panel_5_2.setBounds(0, 0, 407, 16);
		panel_4_2.add(panel_5_2);

		txtNumRevenue = new JLabel("0");
		txtNumRevenue.setForeground(Color.GRAY);
		txtNumRevenue.setFont(new Font("Segoe UI Semibold", Font.BOLD, 54));
		txtNumRevenue.setBounds(10, 37, 397, 60);
		panel_4_2.add(txtNumRevenue);

		JLabel lblNewLabel_4 = new JLabel("No. Of Staff");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_4.setBounds(55, 30, 194, 34);
		mainPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("No. Of Order");
		lblNewLabel_4_1.setForeground(Color.GRAY);
		lblNewLabel_4_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(313, 30, 194, 34);
		mainPanel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Revenue");
		lblNewLabel_4_2.setForeground(Color.GRAY);
		lblNewLabel_4_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(573, 31, 194, 34);
		mainPanel.add(lblNewLabel_4_2);

		JPanel staffHomeTable = new JPanel();
		staffHomeTable.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "STAFF",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		staffHomeTable.setBounds(55, 227, 927, 233);
		mainPanel.add(staffHomeTable);
		staffHomeTable.setLayout(new BoxLayout(staffHomeTable, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		staffHomeTable.add(scrollPane);
		
		tableStaff = new JTable();
		tableStaff.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "\u0110\u1ECBa ch\u1EC9", "Gi\u1EDBi t\u00EDnh", "Ch\u1EE9c v\u1EE5"
			}
		));
		scrollPane.setViewportView(tableStaff);

		JPanel orderHomeTable = new JPanel();
		orderHomeTable.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "ORDER",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		orderHomeTable.setBounds(53, 487, 927, 233);
		mainPanel.add(orderHomeTable);
		orderHomeTable.setLayout(new BoxLayout(orderHomeTable, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		orderHomeTable.add(scrollPane_1);
		
		tableOrder = new JTable();
		tableOrder.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID Bill", "Ng\u00E0y thanh to\u00E1n", "Discount", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(tableOrder);
		this.updateHome();
	}
	public void updateHome() {
		this.txtNumStaff.setText(Staff.getSizeOfStaff()+"");
		this.txtNumOrder.setText(Bill.getSizeOfBill()+"");
		this.txtNumRevenue.setText(OrderView.vndFormat.format(Order.getRevenue()));
		this.updateTable();
	}
	
	public void updateTable() {
		DefaultTableModel tableStaffModel=(DefaultTableModel) this.tableStaff.getModel();
		
		
		DefaultTableModel tableBillModel=(DefaultTableModel) this.tableOrder.getModel();
		
		tableBillModel.setRowCount(0);
		tableStaffModel.setRowCount(0);
		ResultSet staff=Staff.getListOfStaffRS();
		ResultSet bill=Bill.getListOfBill();
		try {
			while (staff.next()) {
				tableStaffModel.addRow(new Object[] {
						staff.getString(1),staff.getString(2),staff.getString(3),staff.getInt(4)==1?"Male":"Female",staff.getString(5)
								
				});
			}
			while (bill.next()) {
				tableBillModel.addRow(new Object[] {
						bill.getInt(1)+"",bill.getString(3),bill.getDouble(4)+"",bill.getInt(5)+""
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


