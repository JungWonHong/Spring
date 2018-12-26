//GridLayout�� ����ϴ� ���α׷�
//�־��� ������ �Ȱ��� ũ���� ��� ���� ������,
//������Ʈ���� �� ũ�⿡ �°� ���� ��ġ�ϴ� ���̾ƿ�
package ex21_5_1_GridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowExample_event extends JFrame {
	WindowExample_event() {
		super("Zoo Program");
		setLocation(500, 400);
		setPreferredSize(new Dimension(500, 300));
		Container contentPane = getContentPane();

		// 3�� 2���� GridLayout �����մϴ�.
		GridLayout layout = new GridLayout(3, 3);
		JLabel label = new JLabel("Hello, Zoo");
		
		JButton b1 = new JButton("��踻");
		JButton b2 = new JButton("����");
		JButton b3 = new JButton("�ڳ���");
		JButton b4 = new JButton("�ڻԼ�");
		JButton b5 = new JButton("���");
		JButton b6 = new JButton("���̿���");
		// ContentPane��  GridLayout�� �����մϴ�.
		contentPane.setLayout(layout);

		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(b5);
		contentPane.add(b6);
		contentPane.add(label);

		ActionListener listener = new ConfirmButtonActionListener(b1, b2, b3, b4, b5, b6, label);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		b5.addActionListener(listener);
		b6.addActionListener(listener);
		
		// �����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample_event w = new WindowExample_event();
	}

}
