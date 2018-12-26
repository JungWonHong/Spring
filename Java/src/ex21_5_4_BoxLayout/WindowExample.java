//BoxLayout 사용하는 프로그램
//컴포넌트를 가로 또는 세로로 순서대로 배열하는 레이아웃
package ex21_5_4_BoxLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame {
	WindowExample() {
		super("Cafe Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();
		
		//BoxLayout.X_AXIS : 가로 방향의 BoxLayout
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		
		//BoxLayout.Y_AXIS : 세로 방향의 BoxLayout
		//BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);

		// ContentPane을 BoxLayout으로 설정합니다.
		contentPane.setLayout(layout);

		// ContentPane에 BoxLayout으로 버튼을 추가합니다.
		contentPane.add(new JButton("자바"));
		contentPane.add(new JButton("에스프레소"));
		contentPane.add(new JButton("카푸치노"));
		contentPane.add(new JButton("블루마운틴"));
		contentPane.add(new JButton("콜럼비아"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
