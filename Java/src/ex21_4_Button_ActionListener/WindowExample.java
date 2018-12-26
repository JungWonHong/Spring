//��ư�� Ŭ������ �� �̺�Ʈ(����ڳ� ���α׷��� ���� �߻��� �� �ִ� ���)��
//�߻��ϴ� ���α׷��Դϴ�.
package ex21_4_Button_ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowExample extends JFrame {
	WindowExample(){
		super("Hello Program - ��ư �̺�Ʈ");
		
		setPreferredSize(new Dimension(200, 150));
		setLocation(500, 400);
		
		Container contentPane = getContentPane();
		
		JTextField text = new JTextField();
		JButton button = new JButton("Ȯ��");
		JLabel label = new JLabel("Hello");
		
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);
		
		/*
		 * 3�ܰ� �̺�Ʈ ������(Event Listener - �̺�Ʈ ������) :
		 * �̺�Ʈ�� ó���ϴ� Ŭ����(�̺�Ʈ �ڵ鷯)�� ��ü��
		 * �̺�Ʈ�� �����ϰ� ó���մϴ�.
		 * �̺�Ʈ �ڵ鷯�� �̺�Ʈ �����ʷ� �̺�Ʈ �ҽ�(Event Source-�̺�Ʈ �߻���)��
		 * �����ؾ� �̺�Ʈ�� �߻����� �� �̺�Ʈ�� ó���˴ϴ�.
		 * ���⼭ �̺�Ʈ �ҽ��� button, �̺�Ʈ �ڵ鷯�� ConfirmButtonActionListener
		 * �̺�Ʈ �����ʴ� listener �Դϴ�.
		 */
		// Ȯ�� ��ư ó�� �����ʸ� �����մϴ�.
		ActionListener listener = new ConfirmButtonActionListener(text, label);
		
		//�̺�Ʈ �����ʸ� ����մϴ�.
		//��ư�� Ŭ�������� �̺�Ʈ�� �߻��մϴ�.
		//�̺�Ʈ �ҽ�(Event Source-�̺�Ʈ �߻���) : �̺�Ʈ�� �߻��� ��Ǫ��Ʈ
		//����ڰ� Button�� ������ �� �̺�Ʈ�� �߻��ϰ� Button��
		//�̺�Ʈ�� �ҽ��� �˴ϴ�.
		button.addActionListener(listener);
		
		//�����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}

	public static void main(String[] args){
		WindowExample w = new WindowExample();
	}

}
