

/*
 * create  table  mem02(
 * id         varchar2(20)  primary key,  --�⺻Ű : �ߺ� �� �� �����
   passwd     varchar2(20),
   name       varchar2(20),
   reg_date   date);
*/

package ex22_5_ex;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertMember4 extends JFrame implements ActionListener
  { // 1�ܰ�
	// Ŭ������ �������̽��� ���ÿ� ��� ���� ���� ������ �°� ����ؾ� �մϴ�.

	Connection con;
	PreparedStatement pstmt;// SQL ���� ���� �ֱ� ���� ���, 
	                        //SQL���� ������ ��쿡 ����ϸ� ���ƿ�
	Timestamp reg_date; // ��¥ ���� Ŭ���� 
       //Date, Calendar, Timestamp 

	private String names[] = { "���̵�", "��й�ȣ", 
			                   "��й�ȣ ���Է�", "�̸�" };
	private JLabel labels[];
	private JTextField fields[];
	private JButton register, cancle, reWrite;
	private JPanel panelCenter, panelSouth;
	private int size = 4;

	public InsertMember4() {//������
		super("ȸ�����");//�Ű����� : ���� ǥ���� ��µ� ���ڿ�

		labels = new JLabel[size];
		fields = new JTextField[size];

		for (int i = 0; i < labels.length; i++)
			labels[i] = new JLabel(names[i]); // ���̺� �� ����
		// labels[0]="���̵�"       ,labels[1]="��й�ȣ"
		// labels[2]="��й�ȣ ���Է�",labels[3]="�̸�"
		
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JTextField();
		//fields[0] = new JTextField(),fields[1] = new JTextField()
		//fields[2] = new JTextField(),fields[3] = new JTextField()
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(size, 2));
		for (int i = 0; i < size; i++) {
			panelCenter.add(labels[i]);
			panelCenter.add(fields[i]);
		}

		register = new JButton("ȸ�����");
		cancle = new JButton("����");
		reWrite = new JButton("�ٽ��ۼ�");

		panelSouth = new JPanel();
		panelSouth.add(register);
		panelSouth.add(cancle);
		panelSouth.add(reWrite);
		
		//JFrame�� �޼ҵ��
		//������     Container contentPane = frame.getContentPane();��
		//contentPane.add(); �����     add�޼ҵ�� ó�� ����(JDK 1.5��������)
		add(panelCenter, "Center");
		add(panelSouth, "South");  
				
		setBounds(300, 300, 300, 250);// ��ġ(x,y)�� ũ��(����,����)
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3�ܰ�
		register.addActionListener(this); // ȸ�� ���
		cancle.addActionListener(this); // ����
		reWrite.addActionListener(this); // �ٽ� �ۼ�			
		
	}// ������ end

	// Database ���� �κ�
	public void dbConnect() {		
		try {
			// JDBC �ε����� üũ : �ش� ��ġ�� ����̹� ������ ������ ���� �߻��մϴ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "scott";
			String userPass = "tiger";
			
			// ������ ���̽� ���� üũ
			con = DriverManager.getConnection(url, userId, userPass);
			}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹� �ε��� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ������ ����");
		}
	}//���� ��

	// Event ó�� �κ�
	public void actionPerformed(ActionEvent ae) { // 2�ܰ�
		if (ae.getSource() == register) { // ȸ�� ��� ��ư Ŭ���� ���
			dbConnect();
			insertMember();
			clearFields();
		} else if (ae.getSource() == cancle) { // ���� ��ư Ŭ���� ���
			// System.exit(0); //���� �ִ� ��� â �ݾ��ݴϴ�.
			dispose();// ���� â�� �ݾ� �ݴϴ�.
		} else if (ae.getSource() == reWrite) { // �ٽ��ۼ� ��ư Ŭ���� ���
			clearFields();
		}
	}

	// ȸ�� ���� ó�� �κ�
	public void insertMember() {
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());// ���� ��¥,�ð�
		String data[] = getFieldValues();// �޼ҵ� ȣ�� 
		 if(data[0].equals("") || 
		    data[1].equals("") || 
		    data[2].equals("") ||
		    data[3].equals(""))		
		{
			JOptionPane.showMessageDialog(this, "��� ������ �Է� �ϼ���!");
		 }else if(data[1].equals(data[2])){ //��� ��ȣ�� ��ġ�ϸ� query�� ����
			String sql = "insert into mem02 values(?,?,?,?)";
			try {
				// sql�� �о� ���� ���� ���	PreparedStatement ��ü��
				// �����˴ϴ�.
				pstmt = con.prepareStatement(sql); 
				
				pstmt.setString(1,data[0]); //���̵�
				pstmt.setString(2,data[1]); //��й�ȣ
				pstmt.setString(3,data[3]); //�̸�
				pstmt.setTimestamp(4, reg_date); // �׹�° ����ǥ�� ȸ������ ��¥ �ð��� �����˴ϴ�.
				                                                 
				int result = pstmt.executeUpdate();  //SQL�� ����

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "ȸ�� ���� �Ϸ�");
					 this.dispose(); //ù��° ������ �ݴ´�. 
					// �ּ��̸� ���� �ʾ� ù��° �����Ӱ� �ι�° �������� ��Ÿ����.
										
					MemberManagement4 management = new MemberManagement4(); //�ι�° ������ �����ϴ�.

				} else {
					JOptionPane.showMessageDialog(this, "ȸ�� ���� ����");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���ο� ���ڵ� �߰��� ����");
			}

		} else { // ��� ��ȣ�� ��ġ���� ������ �޽��� �ڽ�
			JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}

	// �ٽ� �ۼ� ó�� �κ�
	public void clearFields() {
		for (int i = 0; i < size; i++) {
			fields[i].setText("");
		}
	}

	// �Է��� ȸ�� �������� ���ϴ� �κ�
	public String[] getFieldValues() { // ��ȯ��(String[]): �迭 ������(�ּҰ��� ������ �־��)
		String values[] = new String[size]; // �ּҰ��� �Ѱ� �ֱ� ���ؼ��� new�� �����ؾ� �մϴ�.
											// �� ������ String������ 4���� ����� �� �ּҸ�
											// values�� �Ҵ��մϴ�.
		for (int i = 0; i < size; i++)
			values[i] = fields[i].getText();

		return values;
	}

	public static void main(String[] args) {
		InsertMember4 insert = new InsertMember4();
	}
}











