package ex21_8_4.JList;

import javax.swing.event.*;
import javax.swing.*;
//ListSelectionEvent는 JList의 아이템을 선택할때 발생함
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
		System.out.println("선택된 index = " + list.getSelectedIndex());
		label.setIcon(icons[list.getSelectedIndex()]);
	}

}
