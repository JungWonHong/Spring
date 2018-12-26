package ex9_14_InnerClass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerEx8 {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JButton b = new JButton("Start");
		frame.add(b);
		frame.setVisible(true);
		frame.setSize(100, 100);
		b.addActionListener(new ActionListener(){  //EventHandler의 조상인 ActionListener로만 표현 //익명클래스
				public void actionPerformed(ActionEvent e){
					System.out.println("ActionEvent occurred!!!");
				}
			}//익명클래스끝
		);
	}//메인메서드의 끝
}//InnerEx8클래스의 끝


/*
public class InnerEx8 {
	public static void main(String[] args){
		Button b = new Button("Start");
		b.addActionListener(new ActionListener(){  //EventHandler의 조상인 ActionListener로만 표현 //익명클래스
				public void actionPerformed(ActionEvent e){
					System.out.println("ActionEvent occurred!!!");
				}
			}//익명클래스끝
		);
	}//메인메서드의 끝
}//InnerEx8클래스의 끝
*/