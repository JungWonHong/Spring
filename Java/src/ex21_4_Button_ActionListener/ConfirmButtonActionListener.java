//확인 버튼을 처리하는 리스너 클래스
//ConfirmButtonActionListener클래스의 actionPerformed메소드는
//JDK라이브러리의 이벤트 처리 모듈에 의해 자동으로 호출됩니다.
package ex21_4_Button_ActionListener;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener { // 1단계
	JTextField text;
	JLabel label;

	ConfirmButtonActionListener(JTextField text, JLabel label) {
		this.text = text;
		this.label = label;
	}

	// 2단계
	@Override
	// 버튼을 클릭했을 경우 해야할 일을 기술합니다.
	// 버튼을 클릭하면 자동으로 JVM에 의해 호출됩니다.
	public void actionPerformed(ActionEvent e) {
		// 텍스트 상자의 텍스트를 가져오는 메소드입니다.
		String name = text.getText();

		// 라벨에 쓰여진 텍스트를 바꾸는 메소드입니다.
		label.setText("Hello, " + name);
	}

}
