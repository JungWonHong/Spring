//���� ��ư�� ó���ϴ� ������ Ŭ����
package ex21_7_DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class RemoveActionListener implements ActionListener {
	JTable table;
	RemoveActionListener(JTable table){
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ���� ���ؿɴϴ�.
		int row = table.getSelectedRow();
		System.out.println("���õ� �� = " + row);
		
		if(row == -1) //���õ� ���� ���� ��
			return;
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row); //���õ� ���� ���̺�� ���� �����մϴ�.
	}
	
}
