//GridLayout을 사용하는 프로그램
//주어진 영역을 똑같은 크기의 행과 열로 나누고,
//컴포넌트들을 그 크기에 맞게 만들어서 배치하는 레이아웃
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

		// 3행 2열의 GridLayout 생성합니다.
		GridLayout layout = new GridLayout(3, 3);
		
		String[] animal = { "얼룩말", "사자", "코끼리", "코뿔소", "펭귄", "하이에나" };
		JButton[] button = new JButton[6];
		for (int i = 0; i < button.length; i++)
			button[i] = new JButton(animal[i]);

		// ContentPane을 3행 2열의 GridLayout로 설정합니다.
		contentPane.setLayout(layout);

		// ContentPane에 3행 2열의 GridLayout으로 버튼을 추가합니다.
		for (int i = 0; i < button.length; i++)
			contentPane.add(button[i]);
		
		JLabel label = new JLabel("Hello, Zoo");
		contentPane.add(label);

		ActionListener listener = new ConfirmButtonActionListener2(button, label);
		
		for(int i=0;i<button.length;i++)
			button[i].addActionListener(listener);
		
		// 종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample_event2 w = new WindowExample_event2();
	}

}
