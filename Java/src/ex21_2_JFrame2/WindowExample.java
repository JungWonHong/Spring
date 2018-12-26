//JFrame�� ��� �޾� �������� ����� ���
package ex21_2_JFrame2;

import java.awt.*;
import javax.swing.*;

public class WindowExample extends JFrame {
	WindowExample() {
		// Ÿ��Ʋ�� �ִ� �������� �����մϴ�.
		super("Hello Java Program");

		// �������� ��ġ�� �����մϴ�.
		setLocation(500, 400); // (x��ǥ, y��ǥ)

		// �������� ũ�⸦ �ٲߴϴ�.
		// java.awt.Dimension(int width, int height) - ����, ����
		setPreferredSize(new Dimension(300, 200));

		// �� ��° �Ķ���ͷ� ���� ���ڿ��� �߾ӿ� ǥ���ϵ��� �մϴ�.
		JLabel label = new JLabel("�ȳ��ϼ���? �ڹٴ�", SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));

		// �������� �ִ� content pane�� �����ɴϴ�.
		Container contentPane = getContentPane();
		// ���� content pane���� �÷������ϴ�.
		contentPane.add(label);

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
		WindowExample w2 = new WindowExample();
	}

}
