//Ȯ�� ��ư�� ó���ϴ� ������ Ŭ����
//ConfirmButtonActionListenerŬ������ actionPerformed�޼ҵ��
//JDK���̺귯���� �̺�Ʈ ó�� ��⿡ ���� �ڵ����� ȣ��˴ϴ�.
package ex21_5_1_GridLayout;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener2 implements ActionListener { // 1�ܰ�
	JButton[] button;
	JLabel label;

	ConfirmButtonActionListener2(JButton[] button, JLabel label) {
		this.button = button;
		this.label = label;
	}

	// 2�ܰ�
	@Override
	// ��ư�� Ŭ������ ��� �ؾ��� ���� ����մϴ�.
	// ��ư�� Ŭ���ϸ� �ڵ����� JVM�� ���� ȣ��˴ϴ�.
	public void actionPerformed(ActionEvent e) { // 2�ܰ�
		String name = null;
		for (int i = 0; i < button.length; i++)
			if (e.getSource() == button[i])
				name = button[i].getText();

		label.setText("Hello, " + name);
	}

}
