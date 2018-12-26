//삭제 버튼을 처리하는 리스너 클래스
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
		//선택한 행을 구해옵니다.
		int row = table.getSelectedRow();
		
		if(row == -1) //선택된 행이 없을 때
			return;
		
		//컬럼의 갯수를 구해옵니다.
		int col = table.getColumnCount();
		TableModel tm = table.getModel();
		
		//선택된 row의 컬럼값들을 구해옵니다.
		Object arr[] = new Object[col];
		for(int i=0;i<col;i++)
			arr[i] = tm.getValueAt(row, i);
		
		//DB삭제 메소드 호출합니다.
		JdbcEx5 je = new JdbcEx5();
		je.infodelete(arr);
		System.out.println("선택된 행=" + row);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row); //선택된 행을 테이블로 부터 삭제합니다.
	}
	
}
