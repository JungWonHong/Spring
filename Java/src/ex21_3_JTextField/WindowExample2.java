//JFrame�� ��� �޾� �������� ����� ���
package ex21_3_JTextField;

import java.awt.*;
import javax.swing.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		// Ÿ��Ʋ�� �ִ� �������� �����մϴ�.
		super("Hello Java Program");

		// �������� ��ġ�� �����մϴ�.
		setLocation(500, 400); // (x��ǥ, y��ǥ)

		setPreferredSize(new Dimension(300, 80));
		
		// �������� �ִ� content pane�� �����ɴϴ�.
		Container contentPane = getContentPane();

		// �ؽ�Ʈ ���ڸ� �����մϴ�.
		JTextField text = new JTextField();

		// ��ư�� ǥ���� �ؽ�Ʈ�� ������ �Ķ���ͷ� �Ѱ��ݴϴ�.
		JButton button = new JButton("Ȯ��");
		
		JLabel label = new JLabel("Hello");

		// ���� content pane���� �÷������ϴ�.
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		// �����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		// setDefaultCloseOperation - ���� ��ư�� ������ �� �ؾ� �� ���� �����ϴ� �޼ҵ�
		// EXIT_ON_CLOSE - �ݱ� ��ư�� Ŭ������ �� ����(exit)�϶�� �ǹ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������� ���÷��̸� �ϸ� �� ���� �ִ� ������Ʈ�鵵 �ڵ����� ���÷��� �˴ϴ�.
		// �����ӿ� �����ִ� ������Ʈ���� ũ�⿡ �°� �������� ũ�⸦ �����մϴ�.
		// �������� ������ ũ��� ����� �޼ҵ��Դϴ�.
		pack();

		// �������� ���÷����մϴ�.
		setVisible(true);
	} // �����ڳ�

	public static void main(String[] args) {
		WindowExample2 w2 = new WindowExample2();
	}

}
