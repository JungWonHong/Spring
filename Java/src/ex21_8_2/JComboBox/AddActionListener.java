package ex21_8_2.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class AddActionListener implements ActionListener {
	JComboBox<String> jcombo;
	AddActionListener(JComboBox<String> jcombo){
		this.jcombo = jcombo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("������ �̸� = " + jcombo.getSelectedItem());
		System.out.println("������ �ε��� = " + jcombo.getSelectedIndex());
		
	}

}
