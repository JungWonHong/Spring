//GridLayout을 사용하는 프로그램 - 이벤트 발생해 보기
//주어진 영역을 똑같은 크기의 행과 열로 나누고, 컴포넌트들을 그 크기에 맞게 만들어서 배치하는 레이아웃
//WindowExample3_event.java를  배열로 수정해 보기
package ex21_8_5.ImageIcon;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

class WindowExample_event extends JFrame {
	WindowExample_event() {
		 super("Zoo Program");
         setLocation(180, 100);
         Container contentPane = getContentPane();
         
         //3행 2열의 GridLayout 생성합니다.
         GridLayout layout = new GridLayout(3, 2);
         
         //ContentPane을 3행 2열의 GridLayout로 설정합니다.
         contentPane.setLayout(layout);
         
         String imageNames[] = { "smile_01.png", "smile_02.png",
        	    "smile_03.png", "smile_04.png",
  	 			"smile_05.png", "smile_06.png" };
  	 	 
  	 	 
  	 	 Icon icons[]=new ImageIcon[imageNames.length];
          for (int i = 0; i < icons.length; i++) {
  			icons[i] = 
  			 new ImageIcon("src/ex21_8_5/ImageIcon/"+imageNames[i]);//이미지 위치 : 프로젝트 폴더  		    
          }        
         
         JButton b[] = new JButton[6];
         String name[]={ "얼룩말", "사자","코끼리","코뿔소","펭귄","하이에나"};
         for(int i=0;i<name.length;i++){
        	 b[i] = new JButton(name[i], icons[i]);
        	 //b[i].setHorizontalTextPosition(SwingConstants.CENTER ); 텍스트의 위치-가로 중앙
        	
        	 //b[i].setVerticalTextPosition(SwingConstants.BOTTOM );//텍스트 위치 - 오른쪽  아래
        	 
        	 //텍스트 위치를 이미지 세로 아래 가로 중앙에 배치
        	 b[i].setHorizontalTextPosition(SwingConstants.CENTER );
        	 b[i].setVerticalTextPosition(SwingConstants.BOTTOM );
        	 
        	 b[i].setFont(new Font("바탕", Font.BOLD, 30));
         }        
         
         //ContentPane에 3행 2열의 GridLayout으로 버튼을 추가합니다.
         for(int i=0;i<name.length;i++){
        	 contentPane.add(b[i]);
         }
         
         JLabel label = new JLabel();
         contentPane.add(label);
         
         ActionListener listener = 
                 new ConfirmButtonActionListener(b, label);
              
              //리스너를 등록합니다.
              //버튼을 클릭했을때 이벤트가 발생합니다. 
         for(int i=0;i<name.length;i++){
        	 b[i].addActionListener(listener);
         }
                
         
         
         //종료버튼을 클릭했을 경우 윈도우가 닫혀지고 프로그램이 종료 되도록 합니다.
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         //프레임을 적당한 크기로 만드는 메소드입니다.
         pack();
         
         //프레임을 디스플레이합니다.
         setVisible(true);
    }
	public static void main(String[] args) {
		WindowExample_event we = new WindowExample_event();
	}
}
