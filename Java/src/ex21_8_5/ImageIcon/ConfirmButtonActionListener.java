//Ȯ�� ��ư�� ó���ϴ� ������ Ŭ����
//ConfirmButtonActionListenerŬ������ actionPerformed�޼ҵ�� JDK���̺귯���� �̺�Ʈ ó�� ��⿡ ���� 
//�ڵ����� ȣ��ȴ�.
package ex21_8_5.ImageIcon;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;        
class ConfirmButtonActionListener implements ActionListener {//1�ܰ�
    JButton b[]=new JButton[6];
    JLabel label;
    
    ConfirmButtonActionListener(JButton b[], JLabel label) { 
        for(int i=0; i<b.length;i++)
        	this.b[i]=b[i];
        this.label = label;
    }

	@Override
	//��ư�� Ŭ������ ��� �ؾ��� ���� ����մϴ�.
	//��ư�� Ŭ���ϸ� �ڵ����� JVM�� ���� ȣ��˴ϴ�.
	public void actionPerformed(ActionEvent e) { //2�ܰ�
		String name="";
		for(int i=0; i<b.length;i++){
			if(e.getSource()==b[i])
				name = b[i].getText();
		}
		 
		 //�󺧿� ������ �ؽ�Ʈ�� �ٲٴ� �޼ҵ��Դϴ�.
		    label.setFont(new Font("����", Font.BOLD, 30));
	        label.setText("Hello, " + name);
	}
    
 
}
