package ex9_14_InnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerEx7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton b = new JButton("Start");
		frame.add(b);
		frame.setVisible(true);
		frame.setSize(100, 100);
		b.addActionListener(new EventHandler());
	}
}

class EventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!!");
	}
}
/*
public class InnerEx7 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
	}
}

class EventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!!");
	}
}
*/