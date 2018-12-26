//JFrame을 상속 받아 프레임을 만드는 방법
package ex21_3_JTextField;

import java.awt.*;
import javax.swing.*;

public class WindowExample3 extends JFrame {
	WindowExample3() {
		// 타이틀이 있는 프레임을 생성합니다.
		super("Hello Java Program");

		// 윈도우의 위치를 지정합니다.
		setLocation(500, 400); // (x좌표, y좌표)

		setPreferredSize(new Dimension(300, 100));
		
		// 프레임이 있는 content pane을 가져옵니다.
		Container contentPane = getContentPane();

		// 텍스트 상자를 생성합니다.
		JTextField text = new JTextField();

		// 버튼에 표시할 텍스트를 생성자 파라미터로 넘겨줍니다.
		JButton button = new JButton("확인");
		
		JLabel label = new JLabel();
		label.setText("Hello Java");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setForeground(Color.RED);
		
		// 라벨을 content pane위에 올려놓습니다.
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		// 종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
		// setDefaultCloseOperation - 종료 버튼을 눌렀을 때 해야 할 일을 지시하는 메소드
		// EXIT_ON_CLOSE - 닫기 버튼을 클릭했을 때 종료(exit)하라는 의미
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 디스플레이를 하면 그 위에 있는 컴포넌트들도 자동으로 디스플레이 됩니다.
		// 프레임에 속해있는 컴포넌트들의 크기에 맞게 프레임의 크기를 조정합니다.
		// 프레임을 적당한 크기로 만드는 메소드입니다.
		pack();

		// 프레임을 디스플레이합니다.
		setVisible(true);
	} // 생성자끝

	public static void main(String[] args) {
		WindowExample3 w2 = new WindowExample3();
	}

}
