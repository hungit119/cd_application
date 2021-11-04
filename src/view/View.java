package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.DataSaveCD;
import controller.ListCD;
import model.CD;

public class View extends JFrame {
	private JTextField txtId;
	private JTextField txtTua;
	private JTextField txtCasi;
	private JTextField txtSoBaiHat;
	private JTextField txtGiaThanh;

	private JButton btnThem;
	private JButton btnClear;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;

	private JScrollPane scroll;

	private JList<String> jList;
	private DefaultListModel<String> listModel;

	private JPanel topPanel;
	private JPanel botPanel;

	private ListCD listCD;
	private DataSaveCD dataCD;

	public View() {
		listCD = new ListCD();
		dataCD = new DataSaveCD();
		setSize(950, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 1));
		listModel = new DefaultListModel<String>();
		buildTop();
		buildBot();
		add(topPanel);
		add(botPanel);
		setVisible(true);
		readDataFromFile();
	}

	private void readDataFromFile() {
		listCD.setListCD(dataCD.read_cd());
		JOptionPane.showMessageDialog(null, "Da doc file thanh cong!!!");
		for (CD cd : listCD.getListCD()) {
			listModel.addElement(cd.toString());
		}
	}

	private void buildBot() {
		// TODO Auto-generated method stub
		botPanel = new JPanel();
		botPanel.setLayout(new BorderLayout());
		JPanel listPanel = new JPanel();

		listPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Danh sach CD"));
		jList = new JList<String>(listModel);
		jList.addListSelectionListener(new selectionList());
		jList.setVisibleRowCount(15);
		jList.setFixedCellWidth(910);
		jList.setFixedCellHeight(16);

		scroll = new JScrollPane(jList);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		listPanel.add(scroll);
		botPanel.add(listPanel, BorderLayout.CENTER);
	}

	private void buildTop() {
		// TODO Auto-generated method stub
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(7, 1));
		JPanel pnId = new JPanel(new BorderLayout());

		JPanel pnlbId = new JPanel();
		JPanel pntxtId = new JPanel();
		JLabel lbId = new JLabel("Ma CD:");
		txtId = new JTextField(75);

		pnlbId.add(lbId);
		pntxtId.add(txtId);
		pnId.add(pnlbId, BorderLayout.WEST);
		pnId.add(pntxtId, BorderLayout.EAST);

		JPanel pnTua = new JPanel(new BorderLayout());

		JPanel pnlbTua = new JPanel();
		JPanel pntxtTua = new JPanel();
		JLabel lbTua = new JLabel("Tua CD:");
		txtTua = new JTextField(75);

		pnlbTua.add(lbTua);
		pntxtTua.add(txtTua);
		pnTua.add(pnlbTua, BorderLayout.WEST);
		pnTua.add(pntxtTua, BorderLayout.EAST);

		JPanel pnCasi = new JPanel(new BorderLayout());

		JPanel pnlbCasi = new JPanel();
		JPanel pntxtCasi = new JPanel();
		JLabel lbCasi = new JLabel("Ca si:");
		txtCasi = new JTextField(75);

		pnlbCasi.add(lbCasi);
		pntxtCasi.add(txtCasi);
		pnCasi.add(pnlbCasi, BorderLayout.WEST);
		pnCasi.add(pntxtCasi, BorderLayout.EAST);

		JPanel pnSoBaiHat = new JPanel(new BorderLayout());

		JPanel pnlbSoBaiHat = new JPanel();
		JPanel pntxtSoBaiHat = new JPanel();
		JLabel lbSoBaiHat = new JLabel("So bai hat:");
		txtSoBaiHat = new JTextField(75);

		pnlbSoBaiHat.add(lbSoBaiHat);
		pntxtSoBaiHat.add(txtSoBaiHat);
		pnSoBaiHat.add(pnlbSoBaiHat, BorderLayout.WEST);
		pnSoBaiHat.add(pntxtSoBaiHat, BorderLayout.EAST);

		JPanel pnGiaThanh = new JPanel(new BorderLayout());

		JPanel pnlbGiaThanh = new JPanel();
		JPanel pntxtGiaThanh = new JPanel();
		JLabel lbGiaThanh = new JLabel("Gia Thanh:");
		txtGiaThanh = new JTextField(75);

		pnlbGiaThanh.add(lbGiaThanh);
		pntxtGiaThanh.add(txtGiaThanh);
		pnGiaThanh.add(pnlbGiaThanh, BorderLayout.WEST);
		pnGiaThanh.add(pntxtGiaThanh, BorderLayout.EAST);

		JPanel pnBtn = new JPanel();
		pnBtn.setLayout(new FlowLayout());
		JPanel pnbtnThem = new JPanel();
		JPanel pnbtnClear = new JPanel();
		JPanel pnbtnLuu = new JPanel();
		JPanel pnbtnSua = new JPanel();
		JPanel pnbtnXoa = new JPanel();
		JPanel pnbtnTimKiem = new JPanel();

		btnThem = new JButton("Them");
		btnThem.addActionListener(new BtnThemOnClick());
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new BtnClearOnClick());
		btnLuu = new JButton("Luu");
		btnLuu.addActionListener(new BtnLuuOnClick());
		btnSua = new JButton("Sua");
		btnSua.addActionListener(new BtnSuaOnClick());
		btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new BtnXoaOnClick());
		btnTimKiem = new JButton("Tim Kiem");
		btnTimKiem.addActionListener(new BtnTimKiemOnClick());

		pnbtnThem.add(btnThem);
		pnbtnClear.add(btnClear);
		pnbtnLuu.add(btnLuu);
		pnbtnSua.add(btnSua);
		pnbtnXoa.add(btnXoa);
		pnbtnTimKiem.add(btnTimKiem);

		pnBtn.add(pnbtnThem);
		pnBtn.add(pnbtnClear);
		pnBtn.add(pnbtnLuu);
		pnBtn.add(pnbtnXoa);
		pnBtn.add(pnbtnSua);
		pnBtn.add(pnbtnTimKiem);

		topPanel.add(new JLabel("THONG TIN CD", SwingConstants.CENTER));
		topPanel.add(pnId);
		topPanel.add(pnTua);
		topPanel.add(pnCasi);
		topPanel.add(pnSoBaiHat);
		topPanel.add(pnGiaThanh);
		topPanel.add(pnBtn);
	}

	public class BtnThemOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			CD cd = new CD();
			if (txtId.getText() == "" || txtTua.getText() == "" || txtCasi.getText() == ""
					|| txtSoBaiHat.getText() == "" || txtGiaThanh.getText() == "" || !isSo(txtSoBaiHat.getText())
					|| !isSo(txtGiaThanh.getText())) {
				JOptionPane.showMessageDialog(null, "Dau vao khong hop le!!!");
			} else {
				int maCD;
				String tuaCD, caSi;
				int soBaiHat;
				float giaThanh;
				maCD = Integer.parseInt(txtId.getText());
				tuaCD = txtTua.getText();
				caSi = txtCasi.getText();
				soBaiHat = Integer.parseInt(txtSoBaiHat.getText());
				giaThanh = Float.parseFloat(txtGiaThanh.getText());

				cd.setMaCD(maCD);
				cd.setTuaCD(tuaCD);
				cd.setCaSi(caSi);
				cd.setSoBaiHat(soBaiHat);
				cd.setGiaThanh(giaThanh);

				Boolean r = false;
				for (int i = 0; i < listCD.tongCD(); i++) {
					if (listCD.getCD(i).getMaCD() == cd.getMaCD()) {
						JOptionPane.showMessageDialog(null, "Trung ma CD");
						r = true;
					}
				}
				if (r == false) {
					listCD.addCD(cd);
					listModel.addElement(cd.toString());
					txtId.setText("");
					txtTua.setText("");
					txtCasi.setText("");
					txtSoBaiHat.setText("");
					txtGiaThanh.setText("");

				}
			}
		}

		boolean isSo(String str) {
			for (int i = 0; i < str.length(); i++) {
				if (Character.isDigit(str.charAt(i))) {
					return true;
				}
			}
			return false;
		}

	}

	public class BtnClearOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtId.setText("");
			txtTua.setText("");
			txtCasi.setText("");
			txtSoBaiHat.setText("");
			txtGiaThanh.setText("");
		}

	}

	public class BtnLuuOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dataCD.saveFile(listCD);
			JOptionPane.showMessageDialog(null, "Da luu vao file");
		}

	}

	public class BtnXoaOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			File file = new File("data.txt");
			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhap ma CD muon xoa"));
			int r = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon xoa CD nay");
			if (r == JOptionPane.YES_OPTION) {
				int index = listCD.deleteCD(id);
				listModel.remove(index);
				file.delete();
				dataCD.saveFile(listCD);
			}
		}

	}

	public class BtnSuaOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhap id cd can sua:"));
			for (int i = 0; i < listCD.tongCD(); i++) {
				if (listCD.getCD(i).getMaCD() == id) {
					String tuaCD = JOptionPane.showInputDialog(null, "Nhap Tua CD moi:");
					String caSi = JOptionPane.showInputDialog(null, "Nhap Ca si moi:");
					int soBaiHat = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhap So bai hat moi:"));
					float giaThanh = Float.parseFloat(JOptionPane.showInputDialog(null, "Nhap Gia thanh CD moi:"));
					listCD.updateCD(id, tuaCD, caSi, soBaiHat, giaThanh);
					listModel.remove(i);
					listModel.add(i, listCD.getCD(i).toString());
					File file = new File("data.txt");
					file.delete();
					dataCD.saveFile(listCD);
				}
			}
		}

	}

	public class BtnTimKiemOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int maCD;
			boolean r = false;
			maCD = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhap ma CD can tim:"));
			for (int i = 0; i < listCD.tongCD(); i++) {
				if (listCD.getCD(i).getMaCD() == maCD) {
					txtId.setText(Integer.toString(listCD.getCD(i).getMaCD()));
					txtTua.setText(listCD.getCD(i).getTuaCD());
					txtCasi.setText(listCD.getCD(i).getCaSi());
					txtSoBaiHat.setText(Integer.toString(listCD.getCD(i).getSoBaiHat()));
					txtGiaThanh.setText(Float.toString(listCD.getCD(i).getGiaThanh()));
					r = true;
				}
			}
			if (r == false) {
				JOptionPane.showMessageDialog(null, "Khong ton tai CD co ma nay!!!");
			}
		}

	}

	public class selectionList implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int index = jList.getSelectedIndex();
			txtId.setText(Integer.toString(listCD.getCD(index).getMaCD()));
			txtTua.setText(listCD.getCD(index).getTuaCD());
			txtCasi.setText(listCD.getCD(index).getCaSi());
			txtSoBaiHat.setText(Integer.toString(listCD.getCD(index).getSoBaiHat()));
			txtGiaThanh.setText(Float.toString(listCD.getCD(index).getGiaThanh()));
		}

	}

	public static void main(String[] args) {
		new View();
	}
}
