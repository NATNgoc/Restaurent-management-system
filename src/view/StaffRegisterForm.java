package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import org.jdatepicker.util.JDatePickerUtil;

import controller.StaffRegisterFormController;
import model.Staff;

import org.jdatepicker.graphics.JNextIcon;

public class StaffRegisterForm extends JDialog {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDateOfWork;
	private JComboBox cmbPosition;
	private StaffView mainView;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	/**
	 * Create the frame.
	 */

	public StaffRegisterForm() {
		this.init();
		this.setVisible(true);
	} 
	// Getter and setter

	public void init() {
		this.setTitle("Staff Information");
		StaffRegisterFormController ctler = new StaffRegisterFormController(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 597, 619);
		getContentPane().setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 24, 303, 68);
		getContentPane().add(panel_2);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StaffRegisterForm.class.getResource("/image/icons8-staff-50.png")));
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

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(86, 23, 144, 33);
		panel_1.add(txtId);
		txtId.setColumns(10);
		txtId.setText(this.randomID("NV",this.findNumberNotExsits()));

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(85, 88, 144, 33);
		panel_1.add(txtName);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(86, 149, 144, 33);
		panel_1.add(txtAddress);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(85, 209, 144, 33);
		panel_1.add(txtPhone);

		txtDateOfWork = new JTextField();
		txtDateOfWork.setColumns(10);
		txtDateOfWork.setBounds(370, 152, 144, 33);
		panel_1.add(txtDateOfWork);

		cmbPosition = new JComboBox(new String[] { "-Position-", "Nhân viên kế toán", "Nhân viên kinh doanh",
				"Nhân viên SEO", "Nhân viên Thu Ngân", "Trưởng phòng kinh doanh" });
		cmbPosition.setBounds(371, 88, 144, 33);
		panel_1.add(cmbPosition);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton.setBounds(174, 486, 213, 60);
		btnNewButton.addActionListener(ctler);
		getContentPane().add(btnNewButton);
	}
	
	public static String randomID (String pattern, int NumberNotExsits) {
		if (NumberNotExsits <= 9)
			return pattern+"00" + NumberNotExsits;
		else if (NumberNotExsits > 9 && NumberNotExsits <= 99)
			return pattern+"0" + NumberNotExsits;
		else 
			return pattern + NumberNotExsits;
	}
	
	private int findNumberNotExsits() {
		int viTri = 1;
		ResultSet dsStaff = Staff.getListOfStaffRS();
		String id;
		try {
			while (dsStaff.next()) {
				id=dsStaff.getString(1);
				int idStaff=Integer.parseInt(id.substring(id.indexOf("0")));
				if (idStaff==viTri) {
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
	public JTextField getTxtId() {
		return txtId;
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

	public JComboBox getCmbPosition() {
		return cmbPosition;
	}

	public void setCmbPosition(JComboBox cmbPosition) {
		this.cmbPosition = cmbPosition;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public StaffView getMainView() {
		return mainView;
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
}
