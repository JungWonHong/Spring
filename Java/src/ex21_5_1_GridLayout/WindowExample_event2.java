//GridLayout�� ����ϴ� ���α׷�
//�־��� ������ �Ȱ��� ũ���� ��� ���� ������,
//������Ʈ���� �� ũ�⿡ �°� ���� ��ġ�ϴ� ���̾ƿ�
package ex21_5_1_GridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowExample_event2 extends JFrame {
	WindowExample_event2() {
		super("Zoo Program");
		setLocation(500, 400);
		setPreferredSize(new Dimension(500, 300));
		Container contentPane = getContentPane();

		// 3�� 2���� GridLayout �����մϴ�.
		GridLayout layout = new GridLayout(3, 3);
		
		String[] animal = { "��踻", "����", "�ڳ���", "�ڻԼ�", "���", "���̿���" };
		JButton[] button = new JButton[6];
		for (int i = 0; i < button.length; i++)
			button[i] = new JButton(animal[i]);

		// ContentPane�� 3�� 2���� GridLayout�� �����մϴ�.
		contentPane.setLayout(layout);

		// ContentPane�� 3�� 2���� GridLayout���� ��ư�� �߰��մϴ�.
		for (int i = 0; i < button.length; i++)
			contentPane.add(button[i]);
		
		JLabel label = new JLabel("Hello, Zoo");
		contentPane.add(label);

		ActionListener listener = new ConfirmButtonActionListener2(button, label);
		
		for(int i=0;i<button.length;i++)
			button[i].addActionListener(listener);
		
		// �����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample_event2 w = new WindowExample_event2();
	}

}
