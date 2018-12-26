package ex21_8_4.JList;

import javax.swing.event.*;
import javax.swing.*;
//ListSelectionEvent�� JList�� �������� �����Ҷ� �߻���
public class AddListSelectionListener implements ListSelectionListener{
	JList<String> list;
	JLabel label;
	Icon[] icons;
	
	AddListSelectionListener(JList<String> list, JLabel label, Icon[] icons){
		this.list = list;
		this.label = label;
		this.icons = icons;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("���õ� index = " + list.getSelectedIndex());
		label.setIcon(icons[list.getSelectedIndex()]);
	}

}
