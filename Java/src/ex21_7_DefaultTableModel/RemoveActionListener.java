//삭제 버튼을 처리하는 리스너 클래스
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
		//선택한 행을 구해옵니다.
		int row = table.getSelectedRow();
		System.out.println("선택된 행 = " + row);
		
		if(row == -1) //선택된 행이 없을 때
			return;
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row); //선택된 행을 테이블로 부터 삭제합니다.
	}
	
}
