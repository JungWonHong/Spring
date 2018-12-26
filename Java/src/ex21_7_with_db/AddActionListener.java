package ex21_7_with_db;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class AddActionListener implements ActionListener { //1�ܰ�
	JTable table;
	JTextField text1, text2, text3;

	AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3) {
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	//2�ܰ�
	@Override
	// �߰� ��ư�� Ŭ������ �� ó���ϴ� �޼ҵ��Դϴ�.
	public void actionPerformed(ActionEvent arg0) {
		String arr[] = new String[3];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();

		JdbcEx5 jd = new JdbcEx5();
		jd.infoinsert(arr);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
		text1.setText("");
		text2.setText("");
		text3.setText("");
		
	}

}
