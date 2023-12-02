package view;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import controller.StaffRegisterFormController;
import controller.StaffViewController;
import model.Staff;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StaffView extends JPanel {
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable tableStaff;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JTextField txtNameForFind;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JButton btnSync;
	private JLabel txtID;
	private JLabel txtName;
	private JLabel txtAddress;
	private JLabel txtPhone;
	private JLabel txtPosition;
	private JLabel txtDateOfWork;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private ButtonGroup groupSex;
	private JButton btnFind;

	/**
	 * Create the panel.
	 */

	public StaffView() {
			init();
			
	}

	private void init() {
		// TODO Auto-generated method stub
		StaffViewController svCon = new StaffViewController(this);
		setBackground(new Color(255, 255, 255));
		this.setSize(1019, 730);
		setLayout(null);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_14.setBounds(0, 10, 1019, 710);
		add(panel_14);
		panel_14.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(21, 129, 988, 564);
		panel_14.add(panel_10);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setLayout(null);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(25, 362, 939, 192);
		panel_10.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "STAFF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);

		tableStaff = new JTable() { 
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableStaff.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tableStaff);
		tableStaff.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Address", "Phone", "Sex", "Position", "Date of work"
			}
		));
		tableStaff.addMouseListener(svCon);
		JTableHeader tableHeader = tableStaff.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		panel_1 = new JPanel();
		panel_1.setBounds(25, 30, 570, 307);
		panel_10.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"STAFF INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(57, 18, 25, 39);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(37, 67, 45, 56);
		panel_1.add(lblName);
		lblName.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(21, 143, 58, 50);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(27, 203, 45, 47);
		panel_1.add(lblPhone);
		lblPhone.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(364, 18, 25, 39);
		panel_1.add(lblSex);
		lblSex.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(331, 76, 58, 47);
		panel_1.add(lblPosition);
		lblPosition.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		JLabel lblStartWorkingAt = new JLabel("Date start working");
		lblStartWorkingAt.setBounds(267, 143, 120, 39);
		panel_1.add(lblStartWorkingAt);
		lblStartWorkingAt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(255, 255, 255));
		rdbtnMale.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rdbtnMale.setBounds(399, 27, 69, 20);
		panel_1.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(255, 255, 255));
		rdbtnFemale.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rdbtnFemale.setBounds(470, 27, 93, 21);
		panel_1.add(rdbtnFemale);

		groupSex = new ButtonGroup();
		groupSex.add(rdbtnMale);
		groupSex.add(rdbtnFemale);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(85, 18, 144, 33);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		txtID = new JLabel("");
		txtID.setForeground(new Color(0, 0, 0));
		txtID.setBackground(new Color(255, 255, 255));
		panel_4.add(txtID, BorderLayout.CENTER);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(85, 78, 144, 33);
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		txtName = new JLabel("");
		txtName.setBackground(Color.white);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(txtName, BorderLayout.CENTER);

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.setBounds(85, 149, 144, 33);
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		txtAddress = new JLabel("");
		txtAddress.setBackground(new Color(255, 255, 255));
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_6.add(txtAddress, BorderLayout.CENTER);

		panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_7.setBounds(85, 209, 144, 33);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		txtPhone = new JLabel("");
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(txtPhone, BorderLayout.CENTER);

		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_8.setBounds(399, 84, 144, 33);
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		txtPosition = new JLabel("");
		txtPosition.setBackground(new Color(255, 255, 255));
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(txtPosition, BorderLayout.CENTER);

		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_9.setBounds(399, 149, 144, 33);
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		txtDateOfWork = new JLabel("");
		txtDateOfWork.setBackground(new Color(255, 255, 255));
		txtDateOfWork.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(txtDateOfWork, BorderLayout.CENTER);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBorder(new TitledBorder(null, "TOOL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(622, 30, 342, 307);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_12.setBounds(10, 54, 322, 135);
		panel_11.add(panel_12);
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(217, 217, 217));

		txtNameForFind = new JTextField();
		txtNameForFind.setToolTipText("Name of staff you want to find");
		txtNameForFind.setBounds(28, 38, 262, 36);
		panel_12.add(txtNameForFind);
		txtNameForFind.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setForeground(new Color(73, 73, 73));
		lblNewLabel_3.setBackground(new Color(255, 128, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 10, 164, 25);
		panel_12.add(lblNewLabel_3);

		btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-search-25.png")));
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFind.setBounds(111, 86, 98, 30);
		btnFind.addActionListener(svCon);
		panel_12.add(btnFind);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setBounds(10, 234, 322, 49);
		panel_11.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 4, 3, 3));

		btnAdd = new JButton("");
		btnAdd.addActionListener(svCon);
		panel_13.add(btnAdd);
		btnAdd.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-add-male-user-40.png")));

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(svCon);
		panel_13.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-edit-40.png")));

		btnRemove = new JButton("");
		btnRemove.addActionListener(svCon);
		panel_13.add(btnRemove);
		btnRemove.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-remove-40.png")));

		btnSync = new JButton("");
		btnSync.addActionListener(svCon);
		panel_13.add(btnSync);
		btnSync.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-sync-40.png")));

		panel_2 = new JPanel();
		panel_2.setBounds(21, 40, 380, 66);
		panel_14.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 14, 50, 52);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(StaffView.class.getResource("/image/icons8-staff-50.png")));

		lblNewLabel_2 = new JLabel("Staff Details");
		lblNewLabel_2.setBounds(60, 27, 240, 39);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		
				panel = new JPanel();
				panel.setBounds(0, 62, 980, 3);
				panel_2.add(panel);
				panel.setBackground(new Color(0, 0, 0));

		this.updateTable();
	}

	// Getter and setter
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JTextField getTxtNameForFind() {
		return txtNameForFind;
	}

	public void setTxtNameForFind(JTextField txtNameForFind) {
		this.txtNameForFind = txtNameForFind;
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public void setBtnFind(JButton btnFind) {
		this.btnFind = btnFind;
	}

	public JTable getTableStaff() {
		return tableStaff;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnRemove() {
		return btnRemove;
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

	// Phương thức cập nhật bảng - All
	public void updateTable() {

		ResultSet rs = Staff.getListOfStaffRS();
		DefaultTableModel tableModel = (DefaultTableModel) this.tableStaff.getModel();
		tableModel.setRowCount(0);
		try {
			while (rs.next()) {
				tableModel.addRow(new Object[] { rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5) == 1 ? "Male" : "Female", rs.getString(6),
						new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(7)) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Phương thức cập nhật bảng - Custom
	public void updateTable(ArrayList<Staff> listOfStaff) {
		DefaultTableModel tableModel = (DefaultTableModel) this.tableStaff.getModel();
		tableModel.setRowCount(0);
		for (Staff sf : listOfStaff) {
			tableModel.addRow(new Object[] { sf.getIDNV(), sf.getName(), sf.getAddress(), sf.getPhoneNumber(),
					sf.getSex() == 1 ? "Male" : "Female", sf.getChucVu(),
					new SimpleDateFormat("dd/MM/yyyy").format(sf.getNgayLamViec()) });
		}
	}
	// Phương thức reset hiển thị thông tin NV
	public void resetInfomation() {
		this.txtID.setText("");
		this.txtName.setText("");
		this.txtAddress.setText("");
		this.txtPhone.setText("");
		this.txtDateOfWork.setText("");
		this.txtPosition.setText("");
		this.groupSex.clearSelection();
		this.tableStaff.clearSelection();
	}

	// Phương thức lấy thông tin từ bảng
	public void fillInformation(Staff staff) {
		this.txtID.setText(staff.getIDNV());
		this.txtName.setText(staff.getName());
		this.txtAddress.setText(staff.getAddress());
		this.txtPhone.setText(staff.getPhoneNumber());
		this.txtPosition.setText(staff.getChucVu());
		this.txtDateOfWork.setText(new SimpleDateFormat("dd/MM/yyyy").format(staff.getNgayLamViec()).toString());
		if (staff.getSex() == 1)
			this.rdbtnMale.setSelected(true);
		else
			this.rdbtnFemale.setSelected(true);
	}

	// Phương thức lấy thông tin từ cột được chọn
	public Staff getInformation() {
		int index = this.getTableStaff().getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn cột muốn thay đổi!");
			return null;
		} else {
			DefaultTableModel tableModel = (DefaultTableModel) this.getTableStaff().getModel();
			String id = tableModel.getValueAt(index, 0) + "";
			String name = tableModel.getValueAt(index, 1) + "";
			String address = tableModel.getValueAt(index, 2) + "";
			String phone = tableModel.getValueAt(index, 3) + "";
			int sex = new String(tableModel.getValueAt(index, 4) + "").equalsIgnoreCase("Male") == true ? 1 : 0;
			String position = tableModel.getValueAt(index, 5) + "";
			Date dateOfWork = null;
			try {
				dateOfWork = new SimpleDateFormat("dd/MM/yyyy").parse(tableModel.getValueAt(index, 6) + "");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Staff tmp = new Staff(id, name, address, phone, sex, position, dateOfWork);
			return tmp;
		}
	}
}
