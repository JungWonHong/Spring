package ex21_8_6.OptionPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneEx extends JFrame 
                    implements ActionListener{
	
	JButton b1, b2, b3, b4;
	String[] str={"로그인", "회원가입","취소"};

	public JOptionPaneEx(){
		super("JOptionPane 테스트");
		setLayout(new FlowLayout());
		
		b1=new JButton("MessageDialog");	
		b2=new JButton("ConfirmDialog");
		b3=new JButton("InputDialog");
		b4=new JButton("OptionDialog");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		pack();
		setLocation(300,300);
		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==b1){
			JOptionPane.showMessageDialog(this,	"메세지다이얼로그박스",
					"메세지",JOptionPane.INFORMATION_MESSAGE);
			 //[MessageDialog의 매개변수]
		    //첫번째 매개변수 : 
			//  메시지창 다이얼로그가 어떤 Frame에서 나타나게 될 것인지를 정해주는 변수 
		    //두번째 매개변수 : 화면에 보여질 메시지 (메시지 창에 보여질 문구)
		    //세번째 매개변수 : 화면의 타이틀.
		    //네번째 매개변수 : 아이콘 모양. 
			//(JOptionPane에 존재하는 INFORMATION_MESSAGE라는 아이콘을 띄우면 
			//ⓘ모양이 뜬다
		    //API, message Type을 가면 다른 모양에 대한 상수값이 존재.
			//JOptionPane.WARNING_MESSAGE
			//JOptionPane.ERROR_MESSAGE
		    //JOptionPane.PLAIN_MESSAGE					
			
			
		} else if(e.getSource()==b2){
			int num = JOptionPane.showConfirmDialog(this,"확인다이얼로그박스",
					"확인",JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println("선택한 버튼의 값은 " + num);//YES:0, NO:1, CANCEl :2
		} else if(e.getSource()==b3){
			String input = JOptionPane.showInputDialog(this,"입력다이얼로그박스",
					"입력",JOptionPane.YES_NO_OPTION); //Yes인 경우 입력값 리턴
			System.out.println("입력한 값 = " + input);			
		} else if(e.getSource()==b4){
			int num = JOptionPane.showOptionDialog(this,"옵션다이얼로그박스",
					"옵션",JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[1] );//기본값 str[1]
			     
				System.out.println("선택한 버튼의 값은 = " + num);//로그인:0, 회원가입:1
		}
	}
	
	public static void main(String[] args){
		JOptionPaneEx jop = new JOptionPaneEx();
	}
}