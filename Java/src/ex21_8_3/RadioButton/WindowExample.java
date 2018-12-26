package ex21_8_3.RadioButton;

import javax.swing.*;
import java.awt.*;

public class WindowExample extends JFrame{
	WindowExample(){
		super("JRadioButton �̺�Ʈ");
		setPreferredSize(new Dimension(400,200));
		setLocation(500,100);
		Container contentPane = getContentPane();
		
		JTextField text;
		JRadioButton m, f;
		JPanel p;
		ButtonGroup gender;
		
		setLayout(new GridLayout(2, 1));
		
		text = new JTextField("������ ǥ���մϴ�.");
		text.setFont(new Font("����", Font.PLAIN, 16));
		
		p = new JPanel();
		m = new JRadioButton("����(Male)");
		f = new JRadioButton("����(Female)");
		
		gender = new ButtonGroup();
		gender.add(m);
		gender.add(f);
		
		p.add(m);
		p.add(f);
		
		contentPane.add(text);
		contentPane.add(p);
		
		m.addItemListener(new AddItemListener(text, m, f));
		f.addItemListener(new AddItemListener(text, m, f));
		
		setBounds(300, 300, 200, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new WindowExample();
	}

}
