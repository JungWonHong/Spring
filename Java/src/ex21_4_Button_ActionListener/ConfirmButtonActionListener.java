//Ȯ�� ��ư�� ó���ϴ� ������ Ŭ����
//ConfirmButtonActionListenerŬ������ actionPerformed�޼ҵ��
//JDK���̺귯���� �̺�Ʈ ó�� ��⿡ ���� �ڵ����� ȣ��˴ϴ�.
package ex21_4_Button_ActionListener;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmButtonActionListener implements ActionListener { // 1�ܰ�
	JTextField text;
	JLabel label;

	ConfirmButtonActionListener(JTextField text, JLabel label) {
		this.text = text;
		this.label = label;
	}

	// 2�ܰ�
	@Override
	// ��ư�� Ŭ������ ��� �ؾ��� ���� ����մϴ�.
	// ��ư�� Ŭ���ϸ� �ڵ����� JVM�� ���� ȣ��˴ϴ�.
	public void actionPerformed(ActionEvent e) {
		// �ؽ�Ʈ ������ �ؽ�Ʈ�� �������� �޼ҵ��Դϴ�.
		String name = text.getText();

		// �󺧿� ������ �ؽ�Ʈ�� �ٲٴ� �޼ҵ��Դϴ�.
		label.setText("Hello, " + name);
	}

}
