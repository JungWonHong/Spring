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
		super("Hello Program - 버튼 이벤트");

		setPreferredSize(new Dimension(200, 150));
		setLocation(500, 400);

		Container contentPane = getContentPane();

		JTextField text = new JTextField();
		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello");

		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		//익명클래스 사용
		//간단한것, 한번쓰고말것은 이런식으로 익명클래스 사용한다.
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = text.getText();
				label.setText("Hello2, " + name);
			}
		});

		// 종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
