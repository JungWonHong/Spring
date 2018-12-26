package ex21_5_5_MixLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame {
	WindowExample() {
		super("연락처 프로그램");
		
		setLocation(500, 400);
		
		setPreferredSize(new Dimension(500,500));
		
		Container contentPane = getContentPane();
		
		JPanel panel = new JPanel();
		
		GridLayout gridLayout = new GridLayout(3, 2);
		
		panel.setLayout(gridLayout);
		panel.add(new JLabel("이름"));
		panel.add(new JTextField());
		panel.add(new JLabel("주소"));
		panel.add(new JTextField());
		panel.add(new JLabel("전화번호"));
		panel.add(new JTextField());
		
		JButton btn = new JButton("입력");
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
