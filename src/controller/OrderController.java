package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import EnumSupport.CardLayoutSP;
import model.Bill;
import model.Food;
import model.MyItem;
import model.Order;
import model.OrderDetail;
import model.Table;
import view.HomePage;
import view.OrderView;
import view.StaffRegisterForm;
import view.StaffUpdateForm;

public class OrderController implements ActionListener {

	OrderView view;

	public OrderController(OrderView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout layout = (CardLayout) this.view.getPanelAll().getLayout();
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.view.getBtnOpenTable())) {
			layout.show(view.getPanelAll(), "pnOrder");
			Order tmp = new Order(Order.findNumberNotExsits() + "", view.getTableIsSelecting().getId(),
					new java.util.Date(), 0);
			Order.addOrder(tmp);
			this.view.updateTable();
			this.view.revalidate();
			this.view.repaint();

		} else if (e.getSource().equals(this.view.getBtnAddNewFood())) {
			if (this.view.getCmbFood().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(view, "Không tồn tại món ăn");
			} else {
				String op = this.view.getCmbFood().getSelectedItem().toString();
				if (op.equalsIgnoreCase("-food-") == true || op.trim().equalsIgnoreCase("") == true
						|| (int) this.view.getSpnCount().getValue() == 0) {
					JOptionPane.showMessageDialog(view, "Điền đầy đủ thông tin");
				} else {
					// Biến kiểm tra có bị lặp món không(trả về row hoặc -1)
					int checkDuplicate = this.view.check(op);
					System.out.println(checkDuplicate);
					String idOrder = Order.findOrderByIdTable(this.view.getTableIsSelecting().getId());
					MyItem tmp = (MyItem) this.view.getCmbFood().getSelectedItem();
					String idMA = tmp.getValue();
					if (checkDuplicate == -1) {
						int count = (Integer) this.view.getSpnCount().getValue();
						if (count < 0) {
							JOptionPane.showMessageDialog(view, "Chưa có món này nên không xóa được!");
						} else {
							OrderDetail oder = new OrderDetail(idOrder, idMA, count, new Date(),
									Food.findPriceById(idMA));
							OrderDetail.addOrderDetail(oder);
							JOptionPane.showMessageDialog(view, "Thêm món thành công");
						}

					} else {
						DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableOrder().getModel();
						int oldCount = Integer.parseInt(tableModel.getValueAt(checkDuplicate, 1) + "");
						int newCount = (int) this.view.getSpnCount().getValue();
						int result = oldCount + newCount;
						if (result <= 0) {
							JOptionPane.showMessageDialog(view, "Đã xóa món thành công!");
							OrderDetail.deleteOrderDetail(idMA, idOrder);

						} else {
							OrderDetail.updateOrderDetail(idMA, idOrder, result);
							JOptionPane.showMessageDialog(view, "Đã cập nhật món thành công!");

						}
					}

					ResultSet kp = OrderDetail.getListOfOrderDetailByIdOrder(
					Order.findOrderByIdTable(this.view.getTableIsSelecting().getId()));
					this.view.updateTableOrder(kp);
				}
			}
		} else if (e.getSource().equals(this.view.getBtnPay())) {
			DefaultTableModel tableModel = (DefaultTableModel) this.view.getTableOrder().getModel();
			if (tableModel.getRowCount() == 0) {
				JOptionPane.showMessageDialog(view, "Chưa có món hoặc discount không hợp lệ!");
			} else {
				String idBill = Bill.findNumberNotExsits() + "";
				String idTable = this.view.getTableIsSelecting().getId();
				String idOder = Order.findOrderByIdTable(idTable);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				int discount = Integer.parseInt(this.view.getTxtNumDiscount().getText());
				Double money=0.0;
				try {
					
					money =OrderView.vndFormat.parse(this.view.getTxtSum().getText()).doubleValue();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Double moneyAfterDiscount = (money * (100 - discount)) / 100;
				ImageIcon icon=new ImageIcon("D:\\JDBC\\QuanLyBanHang\\src\\image\\icons8-pay-50.png");
				int op = JOptionPane.showConfirmDialog(view,
						"Số tiền phải thanh toán là: " + OrderView.vndFormat.format(moneyAfterDiscount) + "\nXác nhận thanh toán?", "Thông báo",
						JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,icon);
				if (op == JOptionPane.YES_OPTION) {
					Bill bill = new Bill(idBill, idOder, date, moneyAfterDiscount, discount);
					Bill.addBill(bill);
					Table.closeTable(idTable);
					this.view.updateTable();
					this.view.setViewForCard(CardLayoutSP.Null);
					this.view.revalidate();
					this.view.repaint();

				}
			}
		} else if (e.getSource().equals(view.getBtnTrans())) {
			Table newTable = (Table) this.view.getCmbTable().getSelectedItem();
			Table oldTable = this.view.getTableIsSelecting();
			
			if (Table.checkStatus(newTable.getId())==true) {
				boolean check = Table.changeTable(Order.findOrderByIdTable(oldTable.getId()), newTable.getId());
				if (check==true) {
				Table.closeTable(this.view.getTableIsSelecting().getId());
				Table.openTable(newTable.getId());
				JOptionPane.showMessageDialog(view, "Chuyển bàn thành công");
				this.view.updateTable();
				this.view.setViewForCard(CardLayoutSP.Null);
				} else {
					JOptionPane.showMessageDialog(view, "Bàn đã có người");
				}
			} else {
				JOptionPane.showMessageDialog(view, "Bàn đã có người");
			}
		} else if (e.getSource().equals(this.view.getBtnRemoveOrder())) {
			int op=JOptionPane.showConfirmDialog(view, "Bạn muốn xóa hóa đơn này không?","Thông báo",JOptionPane.YES_NO_OPTION);
			if (op==JOptionPane.YES_OPTION) {
				String idOrder=Order.findOrderByIdTable(this.view.getTableIsSelecting().getId());
				boolean check= Order.deleteOrderById(idOrder);
				Table.closeTable(this.view.getTableIsSelecting().getId());
				if (check==true) JOptionPane.showMessageDialog(view, "Bạn đã xóa thành công"); 
				else 
					JOptionPane.showMessageDialog(view, "Bạn đã xóa không thành công");
				this.view.setViewForCard(CardLayoutSP.Null);
				this.view.updateTable();	
				this.view.revalidate();
				this.view.repaint();
			}
			
		}

		view.revalidate();
		view.repaint();
	}

}
