package ex21_8_4.JList;

import java.awt.*;
import javax.swing.*;

public class WindowExample1 extends JFrame {
	WindowExample1() {
		super("JList �̺�Ʈ");
		//setPreferredSize(new Dimension(400, 200));
		//setLocation(500, 100);
		Container contentPane = getContentPane();

		JList<String> list;
		JLabel label;

		String imageNames[] = { "blue.jpg", "black.jpg", "red.jpg", "green.jpg", "pink.jpg", "yellow.jpg" };
		String listNames[] = { "blue", "black", "red", "green", "pink", "yellow" };
		Icon icons[];
		
		setLayout(new GridLayout(1, 2));
		
		list = new JList<String>(listNames);
		
		//����Ʈ�� ����� �����Ҷ� ���� ���ø��� ����
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		icons = new ImageIcon[imageNames.length];
		
		String dir = "src/ex21_8_4/JList/";
		
		for(int i = 0;i<icons.length;i++){
			icons[i] = new ImageIcon(dir+imageNames[i]); //�̹��� ��ġ : ������Ʈ ����
		}
		
		label = new JLabel(icons[0]);
		
		contentPane.add(new JScrollPane(list));
		contentPane.add(label);
		
		list.addListSelectionListener(new AddListSelectionListener(list, label, icons));
		
		setBounds(300, 300, 500, 300);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new WindowExample1();
	}

}
