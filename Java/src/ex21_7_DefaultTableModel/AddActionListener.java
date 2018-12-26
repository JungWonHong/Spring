package ex21_7_DefaultTableModel;

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

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = model.getRowCount(); //�ʱ⿡ row=0
		if (row <= 1)
			model.addRow(arr); // �ؽ�Ʈ ���ڿ� �Էµ� ���� ������ ���̺��� �������� ���� �߰��մϴ�.
		else 
			model.insertRow(2, arr); 
		//public void insertRow(int row, Object[] rowData)
		//������ row�� ������ insert
	}

}
