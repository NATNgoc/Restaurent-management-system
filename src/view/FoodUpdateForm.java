package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import controller.FoodAddFormController;
import controller.FoodUpdateFormController;
import model.Food;
import model.FoodCategory;
import model.Staff;

import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class FoodUpdateForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JComboBox cmbCategory;
	private JComboBox cmbUnit;
	private JButton btnUpdate;
	private Food foodBeSelected;
	private FoodView root;

	public FoodUpdateForm(FoodView root) {
		this.root = root;
		foodBeSelected =root.getInfomation();
		init();
		setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		FoodUpdateFormController con = new FoodUpdateFormController(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
		setBounds(100, 100, 597, 619);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(22, 49, 303, 68);
		contentPanel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FoodUpdateForm.class.getResource("/image/icons8-fast-food-52.png")));
		lblNewLabel_1.setBounds(10, 0, 51, 58);
		panel_2.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 62, 303, 5);
		panel_2.add(panel);

		JLabel lblNewLabel_2 = new JLabel("Food Details");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(78, 19, 156, 39);
		panel_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FOOD INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 164, 570, 265);
		contentPanel.add(panel_1);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 18, 14, 39);
		panel_1.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblName.setBounds(37, 83, 39, 39);
		panel_1.add(lblName);

		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblUnit.setBounds(49, 144, 27, 39);
		panel_1.add(lblUnit);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblPrice.setBounds(43, 204, 33, 43);
		panel_1.add(lblPrice);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblCategory.setBounds(277, 18, 69, 39);
		panel_1.add(lblCategory);

		txtId = new JTextField();
		txtId.setText(foodBeSelected.getId());
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(86, 23, 144, 33);
		panel_1.add(txtId);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setText(foodBeSelected.getName());
		txtName.setBounds(86, 88, 144, 33);
		panel_1.add(txtName);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setText(foodBeSelected.getPrice() + "");
		txtPrice.setBounds(86, 209, 144, 33);
		panel_1.add(txtPrice);

		ArrayList<FoodCategory> dsCategories = FoodCategory.getListOfFoodCategoriesAR();
		cmbCategory = new JComboBox(new Object[] { "-category-" });
		cmbCategory.setBounds(351, 23, 144, 34);
		panel_1.add(cmbCategory);
		for (FoodCategory foodCategory : dsCategories) {
			cmbCategory.addItem(foodCategory.getName());
		}
		String categoryBeselected = root.getTxtCategory().getText();
		for (int i = 0; i <= cmbCategory.getItemCount(); i++) {
			if (cmbCategory.getItemAt(i).toString().equalsIgnoreCase(categoryBeselected)) {
				cmbCategory.setSelectedIndex(i);
				break;
			}
		}

		cmbUnit = new JComboBox(new Object[] { "-unit-", "Bát", "Dĩa", "Nồi", "Con", "Quả" });
		cmbUnit.setBounds(86, 149, 144, 33);
		int itemCount = cmbUnit.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			if (cmbUnit.getItemAt(i).toString().equalsIgnoreCase(foodBeSelected.getUnit())) {
				cmbUnit.setSelectedIndex(i);
				break;
			}
		}
		panel_1.add(cmbUnit);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnUpdate.setBounds(174, 482, 213, 60);
		btnUpdate.addActionListener(con);
		contentPanel.add(btnUpdate);
	}

	//
	// Getter and setter
	//
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

	public JComboBox getCmbCategory() {
		return cmbCategory;
	}

	public void setCmbCategory(JComboBox cmbCategory) {
		this.cmbCategory = cmbCategory;
	}

	public JComboBox getCmbUnit() {
		return cmbUnit;
	}

	public void setCmbUnit(JComboBox cmbUnit) {
		this.cmbUnit = cmbUnit;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public FoodView getRoot() {
		return root;
	}

	public void setRoot(FoodView viewRoot) {
		this.root = viewRoot;
	}

}
