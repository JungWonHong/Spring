//윈도우로 작동하는 Hello, Java 프로그램
//실행하면 바탕화면 왼쪽 상단에 윈도우가 나타납니다.
//종료버튼 클릭시 윈도우는 사라지지만 프로그램은 종료되지 않습니다. - 수정할 부분
//강제 종료는 console창에서 빨간 버튼 클릭
package ex21_1_JFrame1;
import java.awt.*;
import javax.swing.*;
public class WindowExample1 {

	public static void main(String[] args) {
		//타이틀이 있는 프레임 생성합니다.
		JFrame frame = new JFrame("이곳은 타이틀 바 입니다.");
		//타이틀 없는 프레임 생성합니다.
		//JFrame frame = new JFrame();
		
		//라벨을 생성하는 식입니다.
		JLabel label = new JLabel("Hello, Java");
		
		//프레임이 있는 content pane을 가져옵니다.
		//Container는 java.awt패키지에 속하는 클래스 이름입니다.
		Container contentPane = frame.getContentPane();
		
		//라벨을 content pane위에 올려놓습니다.
		contentPane.add(label);
		
		//프레임을 디스플레이를 하면 그 위에 있는 컴포넌트들도 자동으로 디스플레이 됩니다.
		//프레임에 속해있는 컴포넌트들의 크기에 맞게 프레임의 크기를 조정합니다.
		//프레임을 적당한 크기로 만드는 메소드입니다.
		frame.pack();
		
		//프레임을 디스플레이합니다.
		frame.setVisible(true);
	}

}
