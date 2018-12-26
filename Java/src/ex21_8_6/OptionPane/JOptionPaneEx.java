package ex21_8_6.OptionPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneEx extends JFrame 
                    implements ActionListener{
	
	JButton b1, b2, b3, b4;
	String[] str={"�α���", "ȸ������","���"};

	public JOptionPaneEx(){
		super("JOptionPane �׽�Ʈ");
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
			JOptionPane.showMessageDialog(this,	"�޼������̾�α׹ڽ�",
					"�޼���",JOptionPane.INFORMATION_MESSAGE);
			 //[MessageDialog�� �Ű�����]
		    //ù��° �Ű����� : 
			//  �޽���â ���̾�αװ� � Frame���� ��Ÿ���� �� �������� �����ִ� ���� 
		    //�ι�° �Ű����� : ȭ�鿡 ������ �޽��� (�޽��� â�� ������ ����)
		    //����° �Ű����� : ȭ���� Ÿ��Ʋ.
		    //�׹�° �Ű����� : ������ ���. 
			//(JOptionPane�� �����ϴ� INFORMATION_MESSAGE��� �������� ���� 
			//�ո���� ���
		    //API, message Type�� ���� �ٸ� ��翡 ���� ������� ����.
			//JOptionPane.WARNING_MESSAGE
			//JOptionPane.ERROR_MESSAGE
		    //JOptionPane.PLAIN_MESSAGE					
			
			
		} else if(e.getSource()==b2){
			int num = JOptionPane.showConfirmDialog(this,"Ȯ�δ��̾�α׹ڽ�",
					"Ȯ��",JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println("������ ��ư�� ���� " + num);//YES:0, NO:1, CANCEl :2
		} else if(e.getSource()==b3){
			String input = JOptionPane.showInputDialog(this,"�Է´��̾�α׹ڽ�",
					"�Է�",JOptionPane.YES_NO_OPTION); //Yes�� ��� �Է°� ����
			System.out.println("�Է��� �� = " + input);			
		} else if(e.getSource()==b4){
			int num = JOptionPane.showOptionDialog(this,"�ɼǴ��̾�α׹ڽ�",
					"�ɼ�",JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[1] );//�⺻�� str[1]
			     
				System.out.println("������ ��ư�� ���� = " + num);//�α���:0, ȸ������:1
		}
	}
	
	public static void main(String[] args){
		JOptionPaneEx jop = new JOptionPaneEx();
	}
}