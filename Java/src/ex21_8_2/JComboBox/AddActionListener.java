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
		System.out.println("선택한 이름 = " + jcombo.getSelectedItem());
		System.out.println("선택한 인덱스 = " + jcombo.getSelectedIndex());
		
	}

}
