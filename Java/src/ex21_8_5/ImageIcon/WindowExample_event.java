//GridLayout�� ����ϴ� ���α׷� - �̺�Ʈ �߻��� ����
//�־��� ������ �Ȱ��� ũ���� ��� ���� ������, ������Ʈ���� �� ũ�⿡ �°� ���� ��ġ�ϴ� ���̾ƿ�
//WindowExample3_event.java��  �迭�� ������ ����
package ex21_8_5.ImageIcon;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

class WindowExample_event extends JFrame {
	WindowExample_event() {
		 super("Zoo Program");
         setLocation(180, 100);
         Container contentPane = getContentPane();
         
         //3�� 2���� GridLayout �����մϴ�.
         GridLayout layout = new GridLayout(3, 2);
         
         //ContentPane�� 3�� 2���� GridLayout�� �����մϴ�.
         contentPane.setLayout(layout);
         
         String imageNames[] = { "smile_01.png", "smile_02.png",
        	    "smile_03.png", "smile_04.png",
  	 			"smile_05.png", "smile_06.png" };
  	 	 
  	 	 
  	 	 Icon icons[]=new ImageIcon[imageNames.length];
          for (int i = 0; i < icons.length; i++) {
  			icons[i] = 
  			 new ImageIcon("src/ex21_8_5/ImageIcon/"+imageNames[i]);//�̹��� ��ġ : ������Ʈ ����  		    
          }        
         
         JButton b[] = new JButton[6];
         String name[]={ "��踻", "����","�ڳ���","�ڻԼ�","���","���̿���"};
         for(int i=0;i<name.length;i++){
        	 b[i] = new JButton(name[i], icons[i]);
        	 //b[i].setHorizontalTextPosition(SwingConstants.CENTER ); �ؽ�Ʈ�� ��ġ-���� �߾�
        	
        	 //b[i].setVerticalTextPosition(SwingConstants.BOTTOM );//�ؽ�Ʈ ��ġ - ������  �Ʒ�
        	 
        	 //�ؽ�Ʈ ��ġ�� �̹��� ���� �Ʒ� ���� �߾ӿ� ��ġ
        	 b[i].setHorizontalTextPosition(SwingConstants.CENTER );
        	 b[i].setVerticalTextPosition(SwingConstants.BOTTOM );
        	 
        	 b[i].setFont(new Font("����", Font.BOLD, 30));
         }        
         
         //ContentPane�� 3�� 2���� GridLayout���� ��ư�� �߰��մϴ�.
         for(int i=0;i<name.length;i++){
        	 contentPane.add(b[i]);
         }
         
         JLabel label = new JLabel();
         contentPane.add(label);
         
         ActionListener listener = 
                 new ConfirmButtonActionListener(b, label);
              
              //�����ʸ� ����մϴ�.
              //��ư�� Ŭ�������� �̺�Ʈ�� �߻��մϴ�. 
         for(int i=0;i<name.length;i++){
        	 b[i].addActionListener(listener);
         }
                
         
         
         //�����ư�� Ŭ������ ��� �����찡 �������� ���α׷��� ���� �ǵ��� �մϴ�.
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         //�������� ������ ũ��� ����� �޼ҵ��Դϴ�.
         pack();
         
         //�������� ���÷����մϴ�.
         setVisible(true);
    }
	public static void main(String[] args) {
		WindowExample_event we = new WindowExample_event();
	}
}
