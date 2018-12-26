package ex21_8_2.JComboBox;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WindowExample extends JFrame {
	WindowExample() {
		 super("JCheckBox ¿Ã∫•∆Æ");
	     setPreferredSize(new Dimension(400, 200));
	     setLocation(500, 400);
	     Container contentPane = getContentPane();
	    
	     JComboBox<String> combo; 
		 JTextArea textA;
		 JScrollPane jsp;

        combo = new JComboBox<String>();        
		combo.addItem("«—øπΩΩ");
		combo.addItem("±Ë≈¬»Ò");
		combo.addItem("√÷∞≠»Ò");
		
		textA = new JTextArea();
		jsp = new JScrollPane(textA);

		contentPane.add(combo, "North");
		contentPane.add(jsp, "Center");  
        
		//MixedListener
		combo.addItemListener(new AddItemListener(combo,textA));
		combo.addActionListener(new AddActionListener(combo));
		
		/*public void setBounds(int x,  int y, int width,  int height)*/
		setBounds(300, 300, 200, 300);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}
	
	public static void main(String[] args) {
		WindowExample we = new WindowExample();
	}
}
