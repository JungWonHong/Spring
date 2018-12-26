//FlowLayout ����ϴ� ���α׷�
//�¿��� ��� ������Ʈ�� �迭�ϴٰ� ���� ���ڶ�� ���� �ٲ㼭 ��� �迭�ϴ� ���̾ƿ�
//�����̳��� ũ�Ⱑ ����Ǹ� ������Ʈ���� ��ġ�� ���ϰ� ũ��� �����˴ϴ�.
package ex21_5_3_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		super("Fruit Basket Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();

		// FlowLayout��ü �����մϴ�.
		// �������� �Ű� ������ ������Ʈ���� ���� ����� �����մϴ�.
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);

		// ContentPane�� FlowLayout���� �����մϴ�.
		contentPane.setLayout(layout);

		// ContentPane�� FlowLayout���� ��ư�� �߰��մϴ�.
		contentPane.add(new JButton("���"));
		contentPane.add(new JButton("���ξ���"));
		contentPane.add(new JButton("������"));
		contentPane.add(new JButton("����"));
		contentPane.add(new JButton("����"));
		contentPane.add(new JButton("������"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample2 w = new WindowExample2();
	}
}
