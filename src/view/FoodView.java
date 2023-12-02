package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import EnumSupport.AddFormat;
import controller.DAO;
import controller.FoodViewController;
import model.Food;
import model.FoodCategory;
import model.Staff;

public class FoodView extends JPanel {
	private JTable tableFood;
	private JTable tableCategory;
	private JTextField txtFind;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;
	private JButton btnSync;
	private JLabel txtId;
	private JLabel txtName;
	private JLabel txtCategory;
	private JLabel txtUnit;
	private JLabel txtPrice;
	private JButton btnFind;
	private JButton btnAddCategory;
	private JButton btnEditCategory;
	private JButton btnRemoveCategory;
	private JButton btnSyncCategory;
	private JLabel txtIdCategory;
	private JLabel txtNameCategory;

	
	
	/**
	 * Create the panel.
	 */

	public FoodView() {

		setBackground(new Color(255, 255, 255));
		init();
	}

	private void init() {
		FoodViewController fcon = new FoodViewController(this);
		// TODO Auto-generated method stub
		this.setSize(1019, 710);
		setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(21, 40, 380, 68);
		add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-fast-food-50.png")));
		lblNewLabel_1.setBounds(0, 7, 50, 52);
		panel_2.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 62, 380, 3);
		panel_2.add(panel);

		JLabel lblNewLabel_2 = new JLabel("Food Details");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(60, 27, 185, 39);
		panel_2.add(lblNewLabel_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 114, 976, 586);
		add(tabbedPane);
		tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder());
		tabbedPane.addTab("Food", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FOOD INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(25, 105, 329, 280);
		panel_1.add(panel_1_1);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblNewLabel.setBounds(71, 27, 14, 39);
		panel_1_1.add(lblNewLabel);

		JLabel lblName_1 = new JLabel("Name ");
		lblName_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblName_1.setBounds(48, 76, 48, 39);
		panel_1_1.add(lblName_1);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblCategory.setBounds(32, 125, 64, 39);
		panel_1_1.add(lblCategory);

		JLabel lblPhone = new JLabel("Unit");
		lblPhone.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblPhone.setBounds(58, 172, 27, 39);
		panel_1_1.add(lblPhone);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(106, 27, 144, 33);
		panel_1_1.add(panel_4);
		panel_4.setLayout(null);

		txtId = new JLabel("");
		txtId.setBounds(0, 10, 86, 22);
		panel_4.add(txtId);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(106, 74, 144, 33);
		panel_1_1.add(panel_5);
		panel_5.setLayout(null);

		txtName = new JLabel("");
		txtName.setBounds(0, 10, 144, 22);
		panel_5.add(txtName);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(106, 127, 144, 33);
		panel_1_1.add(panel_6);
		panel_6.setLayout(null);

		txtCategory = new JLabel("");
		txtCategory.setBounds(0, 10, 144, 22);
		panel_6.add(txtCategory);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(106, 174, 144, 33);
		panel_1_1.add(panel_7);
		panel_7.setLayout(null);

		txtUnit = new JLabel("");
		txtUnit.setBounds(0, 10, 144, 22);
		panel_7.add(txtUnit);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_7_1.setBackground(Color.WHITE);
		panel_7_1.setBounds(106, 217, 144, 33);
		panel_1_1.add(panel_7_1);
		panel_7_1.setLayout(null);

		txtPrice = new JLabel("");
		txtPrice.setBounds(0, 10, 144, 22);
		panel_7_1.add(txtPrice);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblPrice.setBounds(48, 221, 32, 39);
		panel_1_1.add(lblPrice);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(398, 10, 563, 534);
		panel_1.add(scrollPane);
		tableFood = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(tableFood);
		tableFood.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "ID", "Name", "Category", "Unit", "Price" }));
		tableFood.addMouseListener(fcon);
		JTableHeader tableFoodHeader = tableFood.getTableHeader();
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(25, 395, 329, 63);
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 4, 15, 15));

		btnAdd = new JButton("");
		btnAdd.addActionListener(fcon);
		btnAdd.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-add-new-40.png")));
		panel_8.add(btnAdd);

		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-edit-40.png")));
		panel_8.add(btnEdit);
		btnEdit.addActionListener(fcon);

		btnRemove = new JButton("");
		btnRemove.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-remove-40.png")));
		btnRemove.addActionListener(fcon);
		panel_8.add(btnRemove);

		btnSync = new JButton("");
		btnSync.addActionListener(fcon);
		btnSync.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-sync-40.png")));
		panel_8.add(btnSync);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 0, 0));
		panel_10.setBounds(376, 12, 3, 521);
		panel_1.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(25, 30, 329, 63);
		panel_1.add(panel_11);
		panel_11.setLayout(null);

		txtFind = new JTextField();
		txtFind.setBounds(35, 10, 199, 41);
		panel_11.add(txtFind);
		txtFind.setColumns(10);

		btnFind = new JButton("");
		btnFind.addActionListener(fcon);
		btnFind.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-search-25.png")));
		btnFind.setBounds(244, 10, 47, 41);
		panel_11.add(btnFind);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Category", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBorder(new TitledBorder(null, "CATEGORY", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(33, 68, 374, 137);
		panel_3.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblNewLabel_3.setBounds(89, 21, 14, 39);
		panel_9.add(lblNewLabel_3);

		JLabel lblName_1_1 = new JLabel("Name ");
		lblName_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblName_1_1.setBounds(65, 70, 43, 39);
		panel_9.add(lblName_1_1);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(118, 21, 144, 33);
		panel_9.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		txtIdCategory = new JLabel("");
		txtIdCategory.setBounds(0, 10, 144, 23);
		panel_4_1.add(txtIdCategory);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(118, 68, 144, 33);
		panel_9.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		txtNameCategory = new JLabel("");
		txtNameCategory.setBounds(0, 10, 144, 22);
		panel_5_1.add(txtNameCategory);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(461, 10, 500, 534);
		panel_3.add(scrollPane_1);

		tableCategory = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableCategory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		tableCategory.addMouseListener(fcon);

		JTableHeader tableCategoryHeader = tableCategory.getTableHeader();
		scrollPane_1.setViewportView(tableCategory);
		tableCategoryHeader.setReorderingAllowed(false);
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(255, 255, 255));
		panel_8_1.setBounds(67, 249, 296, 125);
		panel_3.add(panel_8_1);
		panel_8_1.setLayout(new GridLayout(2, 2, 15, 15));

		btnAddCategory = new JButton("");
		btnAddCategory.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-add-new-40.png")));
		panel_8_1.add(btnAddCategory);
		btnAddCategory.addActionListener(fcon);

		btnEditCategory = new JButton("");
		btnEditCategory.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-edit-40.png")));
		panel_8_1.add(btnEditCategory);
		btnEditCategory.addActionListener(fcon);

		btnRemoveCategory = new JButton("");
		btnRemoveCategory.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-remove-40.png")));
		panel_8_1.add(btnRemoveCategory);
		btnRemoveCategory.addActionListener(fcon);
		

		btnSyncCategory = new JButton("");
		btnSyncCategory.setIcon(new ImageIcon(FoodView.class.getResource("/image/icons8-sync-40.png")));
		panel_8_1.add(btnSyncCategory);
		btnSyncCategory.addActionListener(fcon);

		JPanel panel_10_1 = new JPanel();
		panel_10_1.setBackground(Color.BLACK);
		panel_10_1.setBounds(438, 10, 3, 521);
		panel_3.add(panel_10_1);
		tableFoodHeader.setReorderingAllowed(false);
		this.updateTableFood();
		this.updateTableCategory();
	}

	public void updateTableFood() {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableFood.getModel();
		tableModel.setRowCount(0);
		Connection conn = DAO.getDAO().getConnection();
		String sql = "SELECT m.IDMA,m.TenMA,nm.TenNhomMA,m.DonViTinh,m.DonGiaMA\n" + "FROM monan m\n"
				+ "JOIN nhommonan nm\n" + "WHERE m.IDNhomMA=nm.IDNhomMA";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tableModel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getInformationFoodFromTable() {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableFood.getModel();
		int indexBeSelected = this.tableFood.getSelectedRow();
		if (indexBeSelected != -1) {
			txtId.setText(tableModel.getValueAt(indexBeSelected, 0) + "");
			txtName.setText(tableModel.getValueAt(indexBeSelected, 1) + "");
			txtCategory.setText(tableModel.getValueAt(indexBeSelected, 2) + "");
			txtUnit.setText(tableModel.getValueAt(indexBeSelected, 3) + "");
			txtPrice.setText(tableModel.getValueAt(indexBeSelected, 4) + "");
		}
	}

	public JLabel getTxtCategory() {
		return txtCategory;
	}

	public void setTxtCategory(JLabel txtCategory) {
		this.txtCategory = txtCategory;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JTable getTableFood() {
		return tableFood;
	}

	public void setTableFood(JTable tableFood) {
		this.tableFood = tableFood;
	}

	public JTable getTableCategory() {
		return tableCategory;
	}

	public void setTableCategory(JTable tableCategory) {
		this.tableCategory = tableCategory;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnAddCategory() {
		return btnAddCategory;
	}

	public void setBtnAddCategory(JButton btnAddCategory) {
		this.btnAddCategory = btnAddCategory;
	}

	public JButton getBtnEditCategory() {
		return btnEditCategory;
	}

	public void setBtnEditCategory(JButton btnEditCategory) {
		this.btnEditCategory = btnEditCategory;
	}

	public JButton getBtnRemoveCategory() {
		return btnRemoveCategory;
	}

	public void setBtnRemoveCategory(JButton btnRemoveCategory) {
		this.btnRemoveCategory = btnRemoveCategory;
	}

	public JButton getBtnSyncCategory() {
		return btnSyncCategory;
	}

	public void setBtnSyncCategory(JButton btnSyncCategory) {
		this.btnSyncCategory = btnSyncCategory;
	}

	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}

	public JButton getBtnSync() {
		return btnSync;
	}

	public void setBtnSync(JButton btnSync) {
		this.btnSync = btnSync;
	}

	public JTextField getTxtFind() {
		return txtFind;
	}

	public void setTxtFind(JTextField txtFind) {
		this.txtFind = txtFind;
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public void setBtnFind(JButton btnFind) {
		this.btnFind = btnFind;
	}

	public Food getInfomation() {
		Food tmp = new Food();
		int indexBeSelected = this.tableFood.getSelectedRow();
		if (indexBeSelected != -1) {
			DefaultTableModel tableModel = (DefaultTableModel) this.tableFood.getModel();
			tmp.setId(tableModel.getValueAt(indexBeSelected, 0) + "");
			tmp.setName(tableModel.getValueAt(indexBeSelected, 1) + "");
			tmp.setIdCategory(FoodCategory.findFoodCategoryIDByName(tableModel.getValueAt(indexBeSelected, 2) + ""));
			tmp.setUnit(tableModel.getValueAt(indexBeSelected, 3) + "");
			tmp.setPrice(Double.parseDouble(tableModel.getValueAt(indexBeSelected, 4) + ""));
			return tmp;
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn cột muốn thay đổi!");
			return null;
		}
	}

	//
	// Update Bảng sau khi tìm kiếm
	//
	public void updateTableFoodFinding(ResultSet resultFinded) {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableFood.getModel();
		tableModel.setRowCount(0);
		if (resultFinded == null) {
			JOptionPane.showMessageDialog(this, "Món ăn không tồn tại");
		} else {
			try {
				while (resultFinded.next()) {
					tableModel.addRow(new Object[] { resultFinded.getString(1), resultFinded.getString(2),
							resultFinded.getString(3), resultFinded.getString(4), resultFinded.getDouble(5) });
				}
				JOptionPane.showMessageDialog(this, "Tìm thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//
	// Update Bảng Category
	//
	public void updateTableCategory() {
		ResultSet rs = FoodCategory.getListOfFoodCategoriesRS();
		if (rs != null) {
			try {
				DefaultTableModel tableModel = (DefaultTableModel) this.tableCategory.getModel();
				tableModel.setRowCount(0);
				while (rs.next()) {
					tableModel.addRow(new Object[] { rs.getString(1), rs.getString(2) });
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getInformationFoodCategoryFromTable() {
		// TODO Auto-generated method stub
		DefaultTableModel tableModel=(DefaultTableModel) this.getTableCategory().getModel();
		int index=this.tableCategory.getSelectedRow();
		this.txtIdCategory.setText(tableModel.getValueAt(index, 0)+"");
		this.txtNameCategory.setText(tableModel.getValueAt(index, 1)+"");
	}
	
}
