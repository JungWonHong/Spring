package ex21_8_1.JCheckBox;
import java.awt.*;
import javax.swing.*;
public class WindowExample3 extends JFrame{
	WindowExample3(){
		super("참가자 명단 프로그램");
		setPreferredSize(new Dimension(400,200));
		setLocation(500,100);
		Container contentPane = getContentPane();
		setLayout(new GridLayout(2, 1));
		
		JTextField text;
		JCheckBox bold, italic;
		JPanel p;
		text = new JTextField("JAVA 연습");
		text.setFont(new Font("굴림", Font.PLAIN, 40));
		
		p = new JPanel();
		bold = new JCheckBox("진하게");
		italic = new JCheckBox("기울임");
		p.add(bold);
		p.add(italic);
		
		contentPane.add(text);
		contentPane.add(p);
		
		AddItemListener3 listener = new AddItemListener3(text, bold, italic);
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample3 w = new WindowExample3();
	}

}
