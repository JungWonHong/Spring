//JFrame�� ��� �޾� �������� ����� ���
package ex21_1_JFrame1;

import java.awt.*;
import javax.swing.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		// ����Ŭ������ ������ ���ڰ����� Ÿ��Ʋ ������ �� �ֽ��ϴ�.
		super("�̰��� Ÿ��Ʋ���Դϴ�.");

		// �޼ҵ带 �̿��� Ÿ��Ʋ ���� ���
		// setTitle("�̰���");

		// �������� �ִ� content pane�� �����ɴϴ�.
		Container contentPane = getContentPane();
		// ���� �����ϴ� ���Դϴ�.
		JLabel label = new JLabel("Hello, Java");
		contentPane.add(label);

		// �������� ���÷��̸� �ϸ� �� ���� �ִ� ������Ʈ�鵵 �ڵ����� ���÷��� �˴ϴ�.
		// �����ӿ� �����ִ� ������Ʈ���� ũ�⿡ �°� �������� ũ�⸦ �����մϴ�.
		// �������� ������ ũ��� ����� �޼ҵ��Դϴ�.
		pack();

		// �������� ���÷����մϴ�.
		setVisible(true);
	} //�����ڳ�
	
	public static void main(String[] args){
		new WindowExample2();
	}

}
