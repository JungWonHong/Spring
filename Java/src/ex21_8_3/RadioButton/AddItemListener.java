package ex21_8_3.RadioButton;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddItemListener implements ItemListener {
	JTextField text;
	JRadioButton m, f;

	public AddItemListener(JTextField text, JRadioButton m, JRadioButton f) {
		this.text = text;
		this.m = m;
		this.f = f;
	}

	public void itemStateChanged(ItemEvent e) {
		if(m.isSelected()){
			text.setText("남자 입니다.");
		}
		else if(f.isSelected()){
			text.setText("여자 입니다.");
		}
	}
}
