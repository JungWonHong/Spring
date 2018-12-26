package ex21_5_5_MixLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		super("����ó ���α׷�");
		
		setLocation(500, 400);
		
		setPreferredSize(new Dimension(500,200));
		
		Container contentPane = getContentPane();
		
		JPanel panel = new JPanel();
		
		GridLayout gridLayout = new GridLayout(3, 2);
		
		panel.setLayout(gridLayout);
		panel.add(new JLabel("�̸�"));
		panel.add(new JTextField());
		panel.add(new JLabel("�ּ�"));
		panel.add(new JTextField());
		panel.add(new JLabel("��ȭ��ȣ"));
		panel.add(new JTextField());
		
		JButton btn = new JButton("�Է�");
		btn.setPreferredSize(new Dimension(400, 100));
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(btn, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample2 w = new WindowExample2();
	}
}
