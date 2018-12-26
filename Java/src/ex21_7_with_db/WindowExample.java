//���̺� ���� �߰�/�����ϴ� ������ ���α׷�
//���̺��� �߰��� DefaultTableModel Ŭ������ addRow �޼ҵ��
//insertRow�޼ҵ带 ȣ���Ѵ�.
//���̺� �ִ� Ư�� ���� �����ϱ� ���ؼ��� DefaultTableModel Ŭ������
//removeRow �޼ҵ带 ����Ѵ�.
package ex21_7_with_db;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class WindowExample extends JFrame{
	WindowExample(){
		super("������ ��� ���α׷�");

		setLocation(500, 100);

		setPreferredSize(new Dimension(400, 200));

		Container contentPane = getContentPane();
		
		//���̺� �����ؼ� contentPane�� �߰��մϴ�.
		String colNames[] = {"�̸�", "����", "����"};
		Object data[][];
		JdbcEx5 je = new JdbcEx5();
		data = je.infoselect(); //DB�����ؼ� ������ �������� �޼ҵ�
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		
		for(int i=0;i<data.length;i++)
			model.addRow(data[i]); //DB���� ������ ������ ���̺� �߰��ϱ�

		//contentPane�� JScrollPane�� BorderLayout.CENTER�� ��ġ�մϴ�.
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//�г�, TextField, Button �����մϴ�.
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField(6); //��ȣ���� ���ڴ� �ؽ�Ʈ�ʵ��� ������(ũ��)
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(2);
		JButton button1 = new JButton("�߰�");
		JButton button2 = new JButton("����");
		
		//�гο� ������ ���� ������Ʈ���� �߰��մϴ�.
		panel.add(new JLabel("�̸�"));
		panel.add(text1);
		panel.add(new JLabel("����"));
		panel.add(text2);
		panel.add(new JLabel("����"));
		panel.add(text3);
		panel.add(button1);
		panel.add(button2);
		
		//�г��� contentPane�� BorderLayout.SOUTH���� ��ġ�մϴ�.
		contentPane.add(panel, BorderLayout.SOUTH);
		
		//3�ܰ�
		//�߰� ��ư�� �����ʿ� ����մϴ�.
		button1.addActionListener(new AddActionListener(table, text1, text2, text3));
		
		//���� ��ư�� �����ʿ� ����մϴ�.
		button2.addActionListener(new RemoveActionListener(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
