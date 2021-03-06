//FlowLayout 사용하는 프로그램
//좌에서 우로 컴포넌트를 배열하다가 폭이 모자라면 줄을 바꿔서 계속 배열하는 레이아웃
//컨테이너의 크기가 변경되면 컴포넌트들의 위치는 변하고 크기는 고정됩니다.
package ex21_5_3_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame {
	WindowExample() {
		super("Fruit Basket Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();

		// FlowLayout객체 생성합니다.
		// 가운데 정렬이면서 hgap과 vgap이 5픽셀인 FlowLayout을 생성
		FlowLayout layout = new FlowLayout();

		// ContentPane을 FlowLayout으로 설정합니다.
		contentPane.setLayout(layout);

		// ContentPane에 FlowLayout으로 버튼을 추가합니다.
		contentPane.add(new JButton("사과"));
		contentPane.add(new JButton("파인애플"));
		contentPane.add(new JButton("오렌지"));
		contentPane.add(new JButton("포도"));
		contentPane.add(new JButton("레몬"));
		contentPane.add(new JButton("복숭아"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
