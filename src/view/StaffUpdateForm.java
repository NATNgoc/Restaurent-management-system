package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;

import controller.StaffRegisterFormController;
import controller.StaffUpdateViewController;
import model.Staff;

import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class StaffUpdateForm extends JDialog {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDateOfWork;
	private JComboBox cmbPosition;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final JPanel contentPanel = new JPanel();
	private Staff staffBeSelected;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public StaffUpdateForm(Staff tmp) {
		staffBeSelected=tmp;
		init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		StaffUpdateViewController con = new StaffUpdateViewController(this);
		this.setTitle("Update Staff Information");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 597, 619); 
		getContentPane().setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 24, 303, 68);
		getContentPane().add(panel_2);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StaffUpdateForm.class.getResource("/image/icons8-staff-50.png")));
		lblNewLabel_1.setBounds(0, 0, 62, 67);
		panel_2.add(lblNewLabel_1);
		
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 62, 303, 5);
		panel_2.add(panel);

		JLabel lblNewLabel_2 = new JLabel("Staff Details");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(61, 12, 240, 39);
		panel_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"STAFF INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 168, 570, 265);
		getContentPane().add(panel_1);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 18, 21, 39);
		panel_1.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblName.setBounds(26, 83, 49, 39);
		panel_1.add(lblName);
 
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblAddress.setBounds(17, 149, 58, 39);
		panel_1.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblPhone.setBounds(26, 204, 49, 39);
		panel_1.add(lblPhone);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblSex.setBounds(313, 18, 25, 39);
		panel_1.add(lblSex);

		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblPosition.setBounds(303, 83, 58, 39);
		panel_1.add(lblPosition);

		JLabel lblStartWorkingAt = new JLabel("Start Working at");
		lblStartWorkingAt.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblStartWorkingAt.setBounds(245, 152, 144, 33);
		panel_1.add(lblStartWorkingAt);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(399, 27, 69, 20);
		panel_1.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setSelected(true);
		rdbtnFemale.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(470, 27, 93, 21);
		panel_1.add(rdbtnFemale);

		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(rdbtnFemale);
		sexGroup.add(rdbtnMale);

		if (staffBeSelected.getSex() == 1)
			this.rdbtnMale.setSelected(true);
		else
			this.rdbtnFemale.setSelected(true);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(86, 23, 144, 33);
		panel_1.add(txtId);
		txtId.setColumns(10);
		txtId.setText(staffBeSelected.getIDNV());

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(85, 88, 144, 33);
		txtName.setText(staffBeSelected.getName());
		panel_1.add(txtName);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setText(staffBeSelected.getAddress());
		txtAddress.setBounds(86, 149, 144, 33);
		panel_1.add(txtAddress);

		txtPhone = new JTextField();
		txtPhone.setText(staffBeSelected.getPhoneNumber());
		txtPhone.setColumns(10);
		txtPhone.setBounds(85, 209, 144, 33);
		panel_1.add(txtPhone);

		txtDateOfWork = new JTextField();
		txtDateOfWork.setColumns(10);
		txtDateOfWork.setBounds(370, 152, 144, 33);
		txtDateOfWork.setText(new SimpleDateFormat("dd/MM/yyyy").format(staffBeSelected.getNgayLamViec()).toString());
		panel_1.add(txtDateOfWork);

		cmbPosition = new JComboBox(new String[] { "-Position-", "Nhân viên kế toán", "Nhân viên kinh doanh",
				"Nhân viên SEO", "Nhân viên Thu Ngân", "Trưởng phòng kinh doanh" });
		int itemCount = cmbPosition.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			Object item = cmbPosition.getItemAt(i);
			if (item.toString().equalsIgnoreCase(staffBeSelected.getChucVu())) {
				cmbPosition.setSelectedIndex(i);
				break;
			}
		}
		cmbPosition.setBounds(371, 88, 144, 33);
		panel_1.add(cmbPosition);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(con);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnNewButton.setBounds(174, 486, 213, 60);

		getContentPane().add(btnNewButton);
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

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	public JTextField getTxtDateOfWork() {
		return txtDateOfWork;
	}

	public void setTxtDateOfWork(JTextField txtDateOfWork) {
		this.txtDateOfWork = txtDateOfWork;
	}

	public JComboBox getCmbPosition() {
		return cmbPosition;
	}

	public void setCmbPosition(JComboBox cmbPosition) {
		this.cmbPosition = cmbPosition;
	}

	public JRadioButton getRdbtnMale() {
		return rdbtnMale;
	}

	public void setRdbtnMale(JRadioButton rdbtnMale) {
		this.rdbtnMale = rdbtnMale;
	}

	public JRadioButton getRdbtnFemale() {
		return rdbtnFemale;
	}

	public void setRdbtnFemale(JRadioButton rdbtnFemale) {
		this.rdbtnFemale = rdbtnFemale;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

}
