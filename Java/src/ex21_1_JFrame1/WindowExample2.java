//JFrame을 상속 받아 프레임을 만드는 방법
package ex21_1_JFrame1;

import java.awt.*;
import javax.swing.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		// 슈퍼클래스의 생성자 인자값으로 타이틀 설정할 수 있습니다.
		super("이곳은 타이틀바입니다.");

		// 메소드를 이용한 타이틀 설정 방법
		// setTitle("이곳은");

		// 프레임이 있는 content pane을 가져옵니다.
		Container contentPane = getContentPane();
		// 라벨을 생성하는 식입니다.
		JLabel label = new JLabel("Hello, Java");
		contentPane.add(label);

		// 프레임을 디스플레이를 하면 그 위에 있는 컴포넌트들도 자동으로 디스플레이 됩니다.
		// 프레임에 속해있는 컴포넌트들의 크기에 맞게 프레임의 크기를 조정합니다.
		// 프레임을 적당한 크기로 만드는 메소드입니다.
		pack();

		// 프레임을 디스플레이합니다.
		setVisible(true);
	} //생성자끝
	
	public static void main(String[] args){
		new WindowExample2();
	}

}
