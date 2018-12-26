package ex21_7_DefaultTableModel;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class AddActionListener implements ActionListener { //1단계
	JTable table;
	JTextField text1, text2, text3;

	AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3) {
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	//2단계
	@Override
	// 추가 버튼을 클릭했을 때 처리하는 메소드입니다.
	public void actionPerformed(ActionEvent arg0) {
		String arr[] = new String[3];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = model.getRowCount(); //초기에 row=0
		if (row <= 1)
			model.addRow(arr); // 텍스트 상자에 입력된 값을 가지고 테이블의 마지막에 행을 추가합니다.
		else 
			model.insertRow(2, arr); 
		//public void insertRow(int row, Object[] rowData)
		//지정한 row에 데이터 insert
	}

}
