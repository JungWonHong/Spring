//Ȯ�� ��ư�� ó���ϴ� ������ Ŭ����
//ConfirmButtonActionListenerŬ������ actionPerformed�޼ҵ��
//JDK���̺귯���� �̺�Ʈ ó�� ��⿡ ���� �ڵ����� ȣ��˴ϴ�.
package ex21_5_1_GridLayout;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener { // 1�ܰ�
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

	// 2�ܰ�
	@Override
	// ��ư�� Ŭ������ ��� �ؾ��� ���� ����մϴ�.
	// ��ư�� Ŭ���ϸ� �ڵ����� JVM�� ���� ȣ��˴ϴ�.
	public void actionPerformed(ActionEvent e) { //2�ܰ�
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
