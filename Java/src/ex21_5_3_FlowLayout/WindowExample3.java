//FlowLayout 사용하는 프로그램
//좌에서 우로 컴포넌트를 배열하다가 폭이 모자라면 줄을 바꿔서 계속 배열하는 레이아웃
//컨테이너의 크기가 변경되면 컴포넌트들의 위치는 변하고 크기는 고정됩니다.
package ex21_5_3_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample3 extends JFrame {
	WindowExample3() {
		super("Fruit Basket Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 50, 50);
		//FlowLayout(int align, int hgap, int vgap) :
		//  align : 컴포넌트들의 정렬방법을 지정
		//  hgap  : 각 컴포넌트간의 좌우 간격을 줌
		//  vgap  : 각 컴포넌트간의 상하 간격을 줌

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
		WindowExample3 w = new WindowExample3();
	}
}
