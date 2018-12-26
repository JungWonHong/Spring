//GridLayout을 사용하는 프로그램
//주어진 영역을 똑같은 크기의 행과 열로 나누고,
//컴포넌트들을 그 크기에 맞게 만들어서 배치하는 레이아웃
package ex21_5_1_GridLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		super("Zoo Program");
		setLocation(500, 400);
		setPreferredSize(new Dimension(500, 600));
		Container contentPane = getContentPane();

		// 3행 2열의 GridLayout 생성합니다.
		// java.awt.GridLayout.GridLayout(int rows, int cols, int hgap, int vgap)
		// hgap - the horizontal gap(가로 간격)
		// vgap - the vertical gap(세로 간격)
		GridLayout layout = new GridLayout(3, 2, 200, 10);

		// ContentPane을 3행 2열의 GridLayout로 설정합니다.
		contentPane.setLayout(layout);

		// ContentPane에 3행 3열의 GridLayout으로 버튼을 추가합니다.
		contentPane.add(new JButton("얼룩말"));
		contentPane.add(new JButton("사자"));
		contentPane.add(new JButton("코끼리"));
		contentPane.add(new JButton("코뿔소"));
		contentPane.add(new JButton("펭귄"));
		contentPane.add(new JButton("하이에나1"));

		// 세 개의 행을 유지하면서 열을 증가합니다.
		// contentPane.add(new JButton("하이에나2"));

		// 종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample2 w = new WindowExample2();
	}

}
