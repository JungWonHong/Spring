//FlowLayout ����ϴ� ���α׷�
//�¿��� ��� ������Ʈ�� �迭�ϴٰ� ���� ���ڶ�� ���� �ٲ㼭 ��� �迭�ϴ� ���̾ƿ�
//�����̳��� ũ�Ⱑ ����Ǹ� ������Ʈ���� ��ġ�� ���ϰ� ũ��� �����˴ϴ�.
package ex21_5_3_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample3 extends JFrame {
	WindowExample3() {
		super("Fruit Basket Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 50, 50);
		//FlowLayout(int align, int hgap, int vgap) :
		//  align : ������Ʈ���� ���Ĺ���� ����
		//  hgap  : �� ������Ʈ���� �¿� ������ ��
		//  vgap  : �� ������Ʈ���� ���� ������ ��

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
		WindowExample3 w = new WindowExample3();
	}
}
