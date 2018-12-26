//확인 버튼을 처리하는 리스너 클래스
//ConfirmButtonActionListener클래스의 actionPerformed메소드는 JDK라이브러리의 이벤트 처리 모듈에 의해 
//자동으로 호출된다.
package ex21_8_5.ImageIcon;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;        
class ConfirmButtonActionListener implements ActionListener {//1단계
    JButton b[]=new JButton[6];
    JLabel label;
    
    ConfirmButtonActionListener(JButton b[], JLabel label) { 
        for(int i=0; i<b.length;i++)
        	this.b[i]=b[i];
        this.label = label;
    }

	@Override
	//버튼을 클릭했을 경우 해야할 일을 기술합니다.
	//버튼을 클릭하면 자동으로 JVM에 의해 호출됩니다.
	public void actionPerformed(ActionEvent e) { //2단계
		String name="";
		for(int i=0; i<b.length;i++){
			if(e.getSource()==b[i])
				name = b[i].getText();
		}
		 
		 //라벨에 쓰여진 텍스트를 바꾸는 메소드입니다.
		    label.setFont(new Font("굴림", Font.BOLD, 30));
	        label.setText("Hello, " + name);
	}
    
 
}
