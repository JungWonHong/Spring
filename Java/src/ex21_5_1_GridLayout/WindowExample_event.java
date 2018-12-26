//GridLayout을 사용하는 프로그램
//주어진 영역을 똑같은 크기의 행과 열로 나누고,
//컴포넌트들을 그 크기에 맞게 만들어서 배치하는 레이아웃
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

		// 3행 2열의 GridLayout 생성합니다.
		GridLayout layout = new GridLayout(3, 3);
		JLabel label = new JLabel("Hello, Zoo");
		
		JButton b1 = new JButton("얼룩말");
		JButton b2 = new JButton("사자");
		JButton b3 = new JButton("코끼리");
		JButton b4 = new JButton("코뿔소");
		JButton b5 = new JButton("펭귄");
		JButton b6 = new JButton("하이에나");
		// ContentPane을  GridLayout로 설정합니다.
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
		
		// 종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample_event w = new WindowExample_event();
	}

}
