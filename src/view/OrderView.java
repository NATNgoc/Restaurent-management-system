package view;

import javax.swing.JPanel;

import com.mysql.cj.xdevapi.Table;

import EnumSupport.CardLayoutSP;
import controller.CategoryController;
import controller.DAO;
import controller.FocusOfDiscount;
import controller.OrderController;
import controller.TableOderController;
import model.FoodCategory;
import model.MyItem;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class OrderView extends JPanel {

	private JPanel pnTable;
	private JPanel panel;
	private JButton btnOpenTable;
	private JPanel pnOrder;
	private JPanel panelAll;
	private model.Table tableIsSelecting;
	private OrderController conn;
	private TableOderController tableConn;
	private JTable tableOrder;
	private JComboBox cmbCategroy;
	private JComboBox cmbFood;
	private JButton btnAddNewFood;
	private JSpinner spnCount;
	private JLabel txtSum;
	private JTextField txtNumDiscount;
	private JButton btnPay;
	private JPanel panelNull;
	private JComboBox cmbTable;
	private DefaultComboBoxModel cmbTableModel;
	private JButton btnTrans;
	private JLabel txtTableIsDisplay;
	private JButton btnRemoveOrder;
	public static NumberFormat vndFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	/**
	 * Create the panel.
	 */
	public OrderView() {
		tableIsSelecting = null;
		conn = new OrderController(this);
		tableConn = new TableOderController(this);
		setBackground(new Color(255, 255, 255));
		init();
	}

	private void init() {

		// TODO Auto-generated method stub
		this.setSize(1019, 710);
		setLayout(null);

		pnTable = new JPanel();
		pnTable.setBackground(new Color(255, 255, 255));
		pnTable.setBounds(23, 78, 441, 648);
		add(pnTable);
		pnTable.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(474, 76, 3, 574);
		add(panel);

		panelAll = new JPanel();
		panelAll.setBounds(487, 78, 518, 622);
		add(panelAll);
		panelAll.setLayout(new CardLayout(0, 0));

		pnOrder = new JPanel();
		pnOrder.setLayout(null);
		pnOrder.setBackground(Color.WHITE);
		panelAll.add(pnOrder, "pnOrder");

		DefaultComboBoxModel<MyItem> cmbCategoryModel = new DefaultComboBoxModel<>();
		ResultSet ds = FoodCategory.getListOfFoodCategoriesRS();
		cmbCategoryModel.addElement(new MyItem("-category-", 0 + ""));
		try {
			while (ds.next()) {
				cmbCategoryModel.addElement(new MyItem(ds.getString(2), ds.getString(1)));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		spnCount = new JSpinner();
		spnCount.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		spnCount.setBounds(395, 62, 41, 36);
		pnOrder.add(spnCount);

		btnAddNewFood = new JButton("Thêm Món");
		btnAddNewFood.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnAddNewFood.setBackground(new Color(155, 255, 205));
		btnAddNewFood.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-add-25.png")));
		btnAddNewFood.setBounds(330, 115, 138, 38);
		btnAddNewFood.addActionListener(conn);
		pnOrder.add(btnAddNewFood);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 163, 514, 296);
		pnOrder.add(scrollPane);

		tableOrder = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableOrder.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		tableOrder.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Food Name", "Count", "Price", "Th\u00E0nh ti\u1EC1n" }));
		JTableHeader header = tableOrder.getTableHeader();
		header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		header.setReorderingAllowed(false);
		scrollPane.setViewportView(tableOrder);

		cmbTable = new JComboBox();
		cmbTable.setBounds(23, 485, 80, 48);
		pnOrder.add(cmbTable);

		btnTrans = new JButton("");
		btnTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrans.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-data-transfer-35.png")));
		btnTrans.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnTrans.setBounds(107, 485, 62, 48);
		btnTrans.addActionListener(conn);
		pnOrder.add(btnTrans);

		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPay.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-cash-35.png")));
		btnPay.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnPay.setBounds(275, 543, 138, 48);
		pnOrder.add(btnPay);
		btnPay.addActionListener(conn);

		JLabel lblNewLabel = new JLabel("Tổng tiền:");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(191, 482, 74, 48);
		pnOrder.add(lblNewLabel);

		DefaultComboBoxModel<MyItem> cmbFoodModel = new DefaultComboBoxModel<>();
		cmbFoodModel.addElement(new MyItem("-Food-", "0"));

		JLabel lblNewLabel_2_2 = new JLabel("Count:");
		lblNewLabel_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(339, 69, 62, 21);
		pnOrder.add(lblNewLabel_2_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(275, 486, 229, 47);
		pnOrder.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		txtSum = new JLabel("");
		txtSum.setLocation(0, 485);
		panel_1.add(txtSum, BorderLayout.CENTER);

		txtNumDiscount = new JTextField();
		txtNumDiscount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtNumDiscount.setText("0");
		txtNumDiscount.setBounds(423, 543, 72, 48);
		pnOrder.add(txtNumDiscount);
		txtNumDiscount.setColumns(10);
		txtNumDiscount.addFocusListener(new FocusOfDiscount(this));
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(494, 543, 20, 48);
		pnOrder.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JLabel lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		panel_2.add(lblNewLabel_3);

		JPanel pnPreOrder = new JPanel();
		pnPreOrder.setBackground(new Color(255, 255, 255));
		panelAll.add(pnPreOrder, "pnPreOrder");
		pnPreOrder.setLayout(null);

		btnOpenTable = new JButton("Press here to open");
		btnOpenTable.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnOpenTable.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-open-sign-100.png")));
		btnOpenTable.setBounds(103, 266, 312, 90);
		btnOpenTable.addActionListener(conn);
		pnPreOrder.add(btnOpenTable);

		panelNull = new JPanel();
		panelNull.setBackground(new Color(255, 255, 255));
		panelAll.add(panelNull, "null");

		CardLayout layout = (CardLayout) panelAll.getLayout();
		layout.show(panelAll, "null");

		JLabel lblNewLabel_1_1 = new JLabel("Table");
		lblNewLabel_1_1.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-restaurant-table-50.png")));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(23, 10, 262, 71);
		add(lblNewLabel_1_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(486, 10, 262, 65);
		add(panel_1_1);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Order");
		panel_1_1.add(lblNewLabel_1, BorderLayout.WEST);
		lblNewLabel_1.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-purchase-order-50 (1).png")));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		cmbTableModel = new DefaultComboBoxModel<>();
		this.updateTable();
		cmbTable.setModel(cmbTableModel);
		
		txtTableIsDisplay = new JLabel("");
		txtTableIsDisplay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		txtTableIsDisplay.setBounds(0, 0, 103, 36);
		pnOrder.add(txtTableIsDisplay);
		
		 btnRemoveOrder = new JButton("");
		btnRemoveOrder.setBackground(new Color(255, 128, 128));
		btnRemoveOrder.setIcon(new ImageIcon(OrderView.class.getResource("/image/icons8-delete-document-35.png")));
		btnRemoveOrder.setBounds(23, 543, 50, 48);
		btnRemoveOrder.addActionListener(conn);
		pnOrder.add(btnRemoveOrder);
		cmbCategroy = new JComboBox();
		cmbCategroy.setBounds(38, 77, 227, 21);
		pnOrder.add(cmbCategroy);
		cmbCategroy.addItemListener(new CategoryController(this));
		cmbCategroy.setModel(cmbCategoryModel);
		
				JLabel lblNewLabel_2 = new JLabel("Category:");
				lblNewLabel_2.setBounds(38, 37, 80, 30);
				pnOrder.add(lblNewLabel_2);
				lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				
						JLabel lblNewLabel_2_1 = new JLabel("Food: ");
						lblNewLabel_2_1.setBounds(38, 101, 45, 21);
						pnOrder.add(lblNewLabel_2_1);
						lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
						cmbFood = new JComboBox();
						cmbFood.setBounds(38, 132, 227, 21);
						pnOrder.add(cmbFood);
						cmbFood.setModel(cmbFoodModel);
	}

	public model.Table getTableIsSelecting() {
		return tableIsSelecting;
	}

	public JLabel getTxtTableIsDisplay() {
		return txtTableIsDisplay;
	}

	public JButton getBtnRemoveOrder() {
		return btnRemoveOrder;
	}

	public void setBtnRemoveOrder(JButton btnRemoveOrder) {
		this.btnRemoveOrder = btnRemoveOrder;
	}

	public void setTxtTableIsDisplay(JLabel txtTableIsDisplay) {
		this.txtTableIsDisplay = txtTableIsDisplay;
	}

	public void setTableIsSelecting(model.Table tableIsSelecting) {
		this.tableIsSelecting = tableIsSelecting;
	}

	public JPanel getPanelAll() {
		return panelAll;
	}

	public void setPanelAll(JPanel panelAll) {
		this.panelAll = panelAll;
	}

	public JPanel getPnOrder() {
		return pnOrder;
	}

	public void setPnOrder(JPanel pnOrder) {
		this.pnOrder = pnOrder;
	}

	public JPanel getPnTable() {
		return pnTable;
	}

	public void setPnTable(JPanel pnTable) {
		this.pnTable = pnTable;
	}

	public JButton getBtnOpenTable() {
		return btnOpenTable;
	}

	public void setBtnOpenTable(JButton btnOpenTable) {
		this.btnOpenTable = btnOpenTable;
	}

	public void setViewForCard(CardLayoutSP index) {
		CardLayout layout = (CardLayout) panelAll.getLayout();
		if (index == CardLayoutSP.Order) {
			layout.show(panelAll, "pnOrder");
		}
		if (index == CardLayoutSP.PreOrder) {
			layout.show(panelAll, "pnPreOrder");
		}
		if (index == CardLayoutSP.Null) {
			layout.show(panelAll, "null");
		}
		this.revalidate();
		this.repaint();
	}

	public void updateTable() {
		this.cmbTableModel.removeAllElements();
		this.pnTable.removeAll();
		ResultSet rs = model.Table.getListOfTable();
		try {
			int i = 1;
			while (rs.next()) {
				JButton tmp = new JButton();
				tmp.setPreferredSize(new Dimension(model.Table.widthTable, model.Table.heightTable));
				tmp.setText("Bàn " + i);
				model.Table tmpTable=new model.Table(rs.getString(1), rs.getInt(2));
				tmp.putClientProperty("tag",tmpTable);
				tmp.addActionListener(tableConn);
				if (rs.getInt(2) == 1) {
					tmp.setOpaque(true);
					tmp.setBorder(null);
					tmp.setBackground(Color.PINK);
				}
				this.cmbTableModel.addElement(tmpTable);
				this.pnTable.add(tmp);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTable getTableOrder() {
		return tableOrder;
	}

	public void setTableOrder(JTable tableOrder) {
		this.tableOrder = tableOrder;
	}

	public JSpinner getSpnCount() {
		return spnCount;
	}

	public void setSpnCount(JSpinner spnCount) {
		this.spnCount = spnCount;
	}

	public JComboBox getCmbCategroy() {
		return cmbCategroy;
	}

	public void setCmbCategroy(JComboBox cmbCategroy) {
		this.cmbCategroy = cmbCategroy;
	}

	public JComboBox getCmbFood() {
		return cmbFood;
	}

	public void setCmbFood(JComboBox cmbFood) {
		this.cmbFood = cmbFood;
	}

	
	
	public void resetPnOrder() {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableOrder.getModel();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
		this.cmbCategroy.setSelectedIndex(0);
		this.cmbFood.addItem("-Food-");
	}

	public JTable getPnTableOrder() {
		return tableOrder;
	}

	public void setPnTableOrder(JTable pnTableOrder) {
		this.tableOrder = pnTableOrder;
	}

	public JButton getBtnAddNewFood() {
		return btnAddNewFood;
	}

	public JComboBox getCmbTable() {
		return cmbTable;
	}

	public void setCmbTable(JComboBox cmbTable) {
		this.cmbTable = cmbTable;
	}

	public void setBtnAddNewFood(JButton btnAddNewFood) {
		this.btnAddNewFood = btnAddNewFood;
	}

	public void updateTableOrder(ResultSet rs) {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableOrder.getModel();
		tableModel.setRowCount(0);
		double allMoney = 0;
		try {
			double sumOfMoney;
			while (rs.next()) {
				sumOfMoney = (double) rs.getInt(4) * rs.getDouble(5);
				allMoney += sumOfMoney;
				tableModel
						.addRow(new Object[] { rs.getString(3), rs.getInt(4) + "", rs.getDouble(5), sumOfMoney + "" });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.txtSum.setText(OrderView.vndFormat.format(allMoney)
				+ "");

	}

	public JTextField getTxtNumDiscount() {
		return txtNumDiscount;
	}

	public void setTxtNumDiscount(JTextField txtNumDiscount) {
		this.txtNumDiscount = txtNumDiscount;
	}

	public JButton getBtnPay() {
		return btnPay;
	}

	public void setBtnPay(JButton btnPay) {
		this.btnPay = btnPay;
	}

	public JButton getBtnTrans() {
		return btnTrans;
	}

	public void setBtnTrans(JButton btnTrans) {
		this.btnTrans = btnTrans;
	}

	public JLabel getTxtSum() {
		return txtSum;
	}

	public void setTxtSum(JLabel txtSum) {
		this.txtSum = txtSum;
	}

	//
	// Check Món đã có rồi
	//
	public int check(String name) {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableOrder.getModel();
		for (int i = 0; i < this.tableOrder.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(name)) {

				return i;
			}
		}
		return -1;
	}
}
