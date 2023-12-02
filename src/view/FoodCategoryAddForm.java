package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FoodCTAddController;
import model.Food;
import model.FoodCategory;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Font;

public class FoodCategoryAddForm extends JDialog {
	private JTextField txtID;
	private JTextField txtName;
	private FoodView root;

	public FoodCategoryAddForm(FoodView root) {
		setTitle("Add Form");
		this.root=root;
		init();
		this.setVisible(true);
		
		
		
		
	}
	
	public void init() {
		FoodCTAddController controller=new FoodCTAddController(this);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblNewLabel.setBounds(100, 29, 13, 36);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(137, 29, 204, 36);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		txtID.setText(StaffRegisterForm.randomID("Nhom", this.FindNumberNotExsits()));
		txtName = new JTextField();
		txtName.setBounds(137, 102, 204, 36);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
		lblCategoryName.setBounds(28, 102, 89, 36);
		getContentPane().add(lblCategoryName);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(164, 159, 120, 47);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(controller);
	}
	//
	//Tim id con trong
	//
	public static int FindNumberNotExsits() {
		int viTri = 1;
		ResultSet rs=FoodCategory.getListOfFoodCategoriesRS();
		try {
			while (rs.next()) {
				String id=rs.getString(1);
				int idFood=Integer.parseInt(id.substring(id.indexOf("0")));
				if (idFood==viTri) {
					viTri++; 
				} else {
					break;
				}
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viTri;
	}
	//
	//Getter and Setter
	//

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public FoodView getRoot() {
		return root;
	}

	public void setRoot(FoodView rootPanel) {
		this.root = rootPanel;
	}
	
}
