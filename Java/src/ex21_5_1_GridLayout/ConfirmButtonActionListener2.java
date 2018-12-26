//확인 버튼을 처리하는 리스너 클래스
//ConfirmButtonActionListener클래스의 actionPerformed메소드는
//JDK라이브러리의 이벤트 처리 모듈에 의해 자동으로 호출됩니다.
package ex21_5_1_GridLayout;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener2 implements ActionListener { // 1단계
	JButton[] button;
	JLabel label;

	ConfirmButtonActionListener2(JButton[] button, JLabel label) {
		this.button = button;
		this.label = label;
	}

	// 2단계
	@Override
	// 버튼을 클릭했을 경우 해야할 일을 기술합니다.
	// 버튼을 클릭하면 자동으로 JVM에 의해 호출됩니다.
	public void actionPerformed(ActionEvent e) { // 2단계
		String name = null;
		for (int i = 0; i < button.length; i++)
			if (e.getSource() == button[i])
				name = button[i].getText();

		label.setText("Hello, " + name);
	}

}
