//���� ��ư�� ó���ϴ� ������ Ŭ����
package ex21_7_with_db;
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
		
		if(row == -1) //���õ� ���� ���� ��
			return;
		
		//�÷��� ������ ���ؿɴϴ�.
		int col = table.getColumnCount();
		TableModel tm = table.getModel();
		
		//���õ� row�� �÷������� ���ؿɴϴ�.
		Object arr[] = new Object[col];
		for(int i=0;i<col;i++)
			arr[i] = tm.getValueAt(row, i);
		
		//DB���� �޼ҵ� ȣ���մϴ�.
		JdbcEx5 je = new JdbcEx5();
		je.infodelete(arr);
		System.out.println("���õ� ��=" + row);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row); //���õ� ���� ���̺�� ���� �����մϴ�.
	}
	
}
