package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.FoodCTUpdateController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FoodCategoryUpdateForm extends JDialog {
	private JTextField txtId;
	private JTextField txtName;
	private FoodView rootView;
	private JButton btnUpdate;
	public FoodCategoryUpdateForm(FoodView rootView) {
		this.rootView=rootView;
		init();
		this.setVisible(true);
	}
	
	private void init() {
		FoodCTUpdateController controller=new FoodCTUpdateController(this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel.setBounds(125, 44, 13, 36);
		getContentPane().add(lblNewLabel);
		DefaultTableModel tableModel=(DefaultTableModel) rootView.getTableCategory().getModel();
		txtId = new JTextField();
		txtId.setText(tableModel.getValueAt(rootView.getTableCategory().getSelectedRow(), 0)+"");
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(162, 44, 204, 36);
		getContentPane().add(txtId);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(162, 117, 204, 36);
		txtName.setText(tableModel.getValueAt(rootView.getTableCategory().getSelectedRow(), 1)+"");
		getContentPane().add(txtName);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblCategoryName.setBounds(53, 117, 89, 36);
		getContentPane().add(lblCategoryName);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(189, 174, 120, 47);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(controller);
	}

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

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public FoodView getRoot() {
		return this.rootView;
	}
	
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

}
