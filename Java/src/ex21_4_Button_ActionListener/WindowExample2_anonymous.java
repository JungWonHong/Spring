package ex21_4_Button_ActionListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowExample2_anonymous extends JFrame {
	WindowExample2_anonymous() {
		super("Hello Program - ��ư �̺�Ʈ");

		setPreferredSize(new Dimension(200, 150));
		setLocation(500, 400);

		Container contentPane = getContentPane();

		JTextField text = new JTextField();
		JButton button = new JButton("Ȯ��");
		JLabel label = new JLabel("Hello");

		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		//�͸�Ŭ���� ���
		//�����Ѱ�, �ѹ��������� �̷������� �͸�Ŭ���� ����Ѵ�.
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = text.getText();
				label.setText("Hello2, " + name);
			}
		});

		// �����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
