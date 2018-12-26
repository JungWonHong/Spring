//BoxLayout ����ϴ� ���α׷�
//������Ʈ�� ���� �Ǵ� ���η� ������� �迭�ϴ� ���̾ƿ�
package ex21_5_4_BoxLayout;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame {
	WindowExample() {
		super("Cafe Program");
		setLocation(500, 400);
		Container contentPane = getContentPane();
		
		//BoxLayout.X_AXIS : ���� ������ BoxLayout
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		
		//BoxLayout.Y_AXIS : ���� ������ BoxLayout
		//BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);

		// ContentPane�� BoxLayout���� �����մϴ�.
		contentPane.setLayout(layout);

		// ContentPane�� BoxLayout���� ��ư�� �߰��մϴ�.
		contentPane.add(new JButton("�ڹ�"));
		contentPane.add(new JButton("����������"));
		contentPane.add(new JButton("īǪġ��"));
		contentPane.add(new JButton("��縶��ƾ"));
		contentPane.add(new JButton("�ݷ����"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
