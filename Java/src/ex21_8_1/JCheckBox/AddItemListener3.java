package ex21_8_1.JCheckBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddItemListener3 implements ItemListener {

	JTextField text;
	JCheckBox bold, italic;
	int valBold = Font.PLAIN, valItalic = Font.PLAIN;

	AddItemListener3(JTextField text, JCheckBox bold, JCheckBox italic) {
		this.text = text;
		this.bold = bold;
		this.italic = italic;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == bold) {
			if (e.getStateChange() == ItemEvent.SELECTED)
				valBold = Font.BOLD; //1
			else
				valBold = Font.PLAIN; //0
		} else if (e.getSource() == italic) {
			if (e.getStateChange() == ItemEvent.SELECTED)
				valItalic = Font.ITALIC; //2
			else
				valItalic = Font.PLAIN; //0
		}

		System.out.print("¿Ã≈≈∏Ø : " + valItalic + "\t");
		System.out.println("±Ω∞‘ : " + valBold);
		text.setFont(new Font("±º∏≤", valBold + valItalic, 40));
	}

}
