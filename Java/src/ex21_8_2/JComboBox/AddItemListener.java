package ex21_8_2.JComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AddItemListener implements ItemListener{
	JComboBox<String> combo; 
	JTextArea textA;
	AddItemListener(JComboBox<String> combo,JTextArea textA ){
		this.combo = combo;
		this.textA = textA;
		
	}
	public void itemStateChanged(ItemEvent e){		
			textA.setText(combo.getSelectedItem()+" º±≈√ \n");
    }
}
