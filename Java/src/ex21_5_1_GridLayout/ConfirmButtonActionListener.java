//확인 버튼을 처리하는 리스너 클래스
//ConfirmButtonActionListener클래스의 actionPerformed메소드는
//JDK라이브러리의 이벤트 처리 모듈에 의해 자동으로 호출됩니다.
package ex21_5_1_GridLayout;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener { // 1단계
	JButton b1, b2, b3, b4, b5, b6;
	JLabel label;

	ConfirmButtonActionListener(JButton b1, JButton b2, JButton b3, JButton b4, 
			JButton b5, JButton b6, JLabel label) {
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		this.b6 = b6;
		this.label = label;
	}

	// 2단계
	@Override
	// 버튼을 클릭했을 경우 해야할 일을 기술합니다.
	// 버튼을 클릭하면 자동으로 JVM에 의해 호출됩니다.
	public void actionPerformed(ActionEvent e) { //2단계
		String name;
		if(e.getSource()==b1)
			name = b1.getText();
		else if(e.getSource()==b2)
			name = b2.getText();
		else if(e.getSource()==b3)
			name = b3.getText();
		else if(e.getSource()==b4)
			name = b4.getText();
		else if(e.getSource()==b5)
			name = b5.getText();
		else
			name = b6.getText();
		
		label.setText("Hello, " + name);
	}

}
