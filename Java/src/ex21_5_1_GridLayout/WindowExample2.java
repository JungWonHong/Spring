//GridLayout�� ����ϴ� ���α׷�
//�־��� ������ �Ȱ��� ũ���� ��� ���� ������,
//������Ʈ���� �� ũ�⿡ �°� ���� ��ġ�ϴ� ���̾ƿ�
package ex21_5_1_GridLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample2 extends JFrame {
	WindowExample2() {
		super("Zoo Program");
		setLocation(500, 400);
		setPreferredSize(new Dimension(500, 600));
		Container contentPane = getContentPane();

		// 3�� 2���� GridLayout �����մϴ�.
		// java.awt.GridLayout.GridLayout(int rows, int cols, int hgap, int vgap)
		// hgap - the horizontal gap(���� ����)
		// vgap - the vertical gap(���� ����)
		GridLayout layout = new GridLayout(3, 2, 200, 10);

		// ContentPane�� 3�� 2���� GridLayout�� �����մϴ�.
		contentPane.setLayout(layout);

		// ContentPane�� 3�� 3���� GridLayout���� ��ư�� �߰��մϴ�.
		contentPane.add(new JButton("��踻"));
		contentPane.add(new JButton("����"));
		contentPane.add(new JButton("�ڳ���"));
		contentPane.add(new JButton("�ڻԼ�"));
		contentPane.add(new JButton("���"));
		contentPane.add(new JButton("���̿���1"));

		// �� ���� ���� �����ϸ鼭 ���� �����մϴ�.
		// contentPane.add(new JButton("���̿���2"));

		// �����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample2 w = new WindowExample2();
	}

}
