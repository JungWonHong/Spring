//JTable - ǥ ���·� �����͸� �����ִ� ���̺� ������Ʈ
//�̺�Ʈ ������
package ex21_6_1_JTable;

import java.awt.*;
import javax.swing.*;

public class WindowExample1_event_no extends JFrame {
	public WindowExample1_event_no() {
		super("������ ��� ���α׷�");

		setLocation(500, 100);

		setPreferredSize(new Dimension(300, 300));

		Container contentPane = getContentPane();

		// �÷� �̸��� �ִ� 1���� �迭
		String colNames[] = { "�̸�", "����", "����" };
		// ������ �׸��� �ִ� 2���� �迭
		Object data[][] = { { "��ö��", 24, '��' }, 
							{ "�̼���", 21, '��' }, 
							{ "������", 26, '��' } };

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
		
		//contentPane�� ��ư�� BorderLayout.SOUTH�� ��ġ�մϴ�.
		contentPane.add(button, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample1_event_no w = new WindowExample1_event_no();
	}

}
