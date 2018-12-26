//JTable - ǥ ���·� �����͸� �����ִ� ���̺� ������Ʈ
//�̺�Ʈ ������
package ex21_6_with_db;

import java.awt.*;
import javax.swing.*;

public class WindowExample extends JFrame {
	public WindowExample() {
		super("������ ��� ���α׷�");

		setLocation(500, 100);

		setPreferredSize(new Dimension(300, 300));

		Container contentPane = getContentPane();

		// �÷� �̸��� �ִ� 1���� �迭
		String colNames[] = { "DEPTNO", "DEPTNAME", "COLLEAGE", "LOC" };
	
		Object data[][];
		
		JdbcEx4 je = new JdbcEx4();
		data = je.getData();
		
		//javax.swing.JTable.JTable(Object[][] rowData, Object[] columnNames)
		//ù��° �Ķ���� : 2���� �迭(������ �׸�), �ι�° �Ķ���� : 1���� �迭(�÷� �̸�)
		//JTable �����մϴ�.
		JTable table = new JTable(data, colNames);
		
		//���̺� �÷��� ScrollPane�� �����մϴ�.
		JScrollPane scrollPane = new JScrollPane(table);
		
		//contentPane�� scrollPane�� BorderLayout.CENTER�� ��ġ�մϴ�.
		contentPane.add(scrollPane, BorderLayout.CENTER);

		//��ư�� �����մϴ�.
		JButton button = new JButton("���");

		//new PrintActionListener(table) : ������ ����
		//��� ��ư ó�� �����ʸ� ����մϴ�.
		button.addActionListener(new PrintActionListener(table));
		contentPane.add(button, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}

}
