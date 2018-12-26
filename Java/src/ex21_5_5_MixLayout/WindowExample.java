package ex21_5_5_MixLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame {
	WindowExample() {
		super("����ó ���α׷�");
		
		setLocation(500, 400);
		
		setPreferredSize(new Dimension(500,500));
		
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
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(btn, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
