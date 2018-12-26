package ex22_5_ex;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberManagement4 extends JFrame 
		implements ActionListener {//1�ܰ�
	Connection con;
	PreparedStatement pstmt; 

	// select ���� ResultSet ��ü ����
	ResultSet rs;
	
	String data[]; //��������� �� �޼ҵ帶�� ��� �����մϴ�.

	private String names[] = { "���̵�", "��й�ȣ", "�̸�", "������" };
	private JLabel labels[], label1;
	private JTextField fields[], searchId;
	private JButton update, delete, search, insert;
	private JPanel panelNorth, panelCenter, panelSouth;
	private int size = 4;

	public MemberManagement4() {
		super("ȸ������ - ȸ������ �˻�, ����, Ż��");

		dbConnect();
         
		panelNorth = new JPanel();
		label1 = new JLabel(names[0]);
		searchId = new JTextField(10);
		search = new JButton("�˻�");

		panelNorth.add(label1);
		panelNorth.add(searchId);
		panelNorth.add(search);

		labels = new JLabel[size];
		fields = new JTextField[size];

		// JLabel ��ü ����
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(names[i]);
			// labels[0]="���̵�",labels[1]="��й�ȣ"
			// labels[2]="�̸�",labels[3]="������"
		}

		// JTextField ��ü ����
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new JTextField();
			//fields[0] = new JTextField(),fields[1] = new JTextField()
			//fields[2] = new JTextField(),fields[3] = new JTextField()
		}

		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(size, 2));
		for (int i = 0; i < size; i++) {
			panelCenter.add(labels[i]);
			panelCenter.add(fields[i]);
		}

		update = new JButton("��������");
		delete = new JButton("ȸ��Ż��");
        insert = new JButton("ȸ������");
		
		panelSouth = new JPanel();
		panelSouth.add(update);
		panelSouth.add(delete);
		panelSouth.add(insert);

		add(panelNorth,  "North");
		add(panelCenter, "Center");
		add(panelSouth,  "South");		

		search.addActionListener(this);//3�ܰ�-������Ʈ�� ActionListener���� 
		update.addActionListener(this); //this - ���ڽ��� �����ʰ� �ȴ�.
		delete.addActionListener(this);
		insert.addActionListener(this);
		/*
		 * ������ �̺�Ʈ(WindowEvent) : �������� ���°� ���� �� �߻��ϴ� �̺�Ʈ�̴�.
           WindowEvent ����
           - WndowListener �������̽�
           - WindowAdapter Ŭ����
		 */
		this.addWindowListener( //�͸�ó��
		   new WindowAdapter(){
              public void windowClosing(WindowEvent w) { 
            	try { //����Ǵ� ������ �ؾ��� ���� ����� ��.
     			   if (pstmt != null)
     				   pstmt.close();
     			   if (con != null)
     				   con.close();
     		    } catch (Exception e) {
     			    System.out.println(e.getMessage());
     		    }//try end    
                System.out.println("������ ������ϴ�.");
                System.exit(0);// X�� ������ ����ȴ�.
              }//windowClosing    
        }//WindowAdapter
    );//addWindowListener
		
		setBounds(300, 300, 350, 300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�͸�ó���� �����ѿ���
        
	}// ������ end

	
	// Database ���� �κ�
	public void dbConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹� �ε��� ����");
		}
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "scott";
			String userPass = "tiger";
			con = DriverManager.getConnection(url, userId, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ������ ����");
		}
	}

	// Event ó�� �κ�
	public void actionPerformed(ActionEvent ae) {//2�ܰ�
		if (ae.getSource() == search) { // �˻�
			searchMember();
		} else if (ae.getSource() == update) { // ��������
			updateMember();
			clearFields();
		} else if (ae.getSource() == delete) { // ȸ��Ż��(����)
			deleteMember();
			clearFields();
		} else if (ae.getSource()== insert){ //ȸ������
			dispose(); //���� â ��������ϰ�
			new InsertMember4(); //���� ��ư�� ���� ȭ�鿡 ����.
			
		}
	}

	// �˻� ó�� �κ�
	public void searchMember() {
		String data[] = new String[4];
		String id = searchId.getText().trim();

		if (id.equals("")) { // ���̵� �Է����� �ʾ�����
			JOptionPane.showMessageDialog(this, "ID�� �Է� �ϼ���");	 //���޼��� ���
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
						
			searchId.requestFocus();//��Ŀ�� ��Ÿ���ϴ�.
		} else {
			String sql = "select * from mem02 where id = ?";
			try {
				pstmt = con.prepareStatement(sql); 
				//sql���� �о� �ͼ� ���� �� PreparedStatement �����մϴ�.
				
				pstmt.setString(1, id);//ù��° ����ǥ�� id�� �����˴ϴ�.
				rs = pstmt.executeQuery();

				if (rs.next()) { //������ ������ ����� ���� ���
					data[0] = rs.getString("id");
					data[1] = rs.getString("passwd");
					data[2] = rs.getString("name");
					data[3] = rs.getTimestamp("reg_date").toString();
					//toString()���� ����ȯ �˴ϴ�.

					// setFieldValues(data);
					//�̸��� ���� �����մϴ�.
					fields[0].setText(data[0]); // ���̵�
					fields[0].setEnabled(false);// �Է� �Ұ�
					fields[1].setText(""); // ��й�ȣ
					fields[2].setText(data[2]); // �̸�
					fields[3].setText(data[3]); // ������
					fields[3].setEnabled(false);// �Է� �Ұ�

					searchId.setText("");

				} else { //������ ������ ����� ���� ���
					JOptionPane.showMessageDialog(this, "�׷� ���̵� �����ϴ�.");
					searchId.setText("");
					return;
				}

				// setFieldValues(data);
				// searchId.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���ڵ� �˻� ����");
			}
		}// if~else end
	}

	// ���� ó�� �κ�
	public void updateMember() {
		data = getFieldValues();//getFieldValues() �޼ҵ� ȣ��
		
		//�̸��� ��¥�� �����մϴ�.
		String sql = "update mem02 set name=?, reg_date=sysdate "
				   + "where id=? ";
		//sysdate : ���糯¥�� �����ݴϴ�.��¥�� �����˴ϴ�. 
		
		
		try {
			if (passwdCompare()) {
				//passwdCompare():��й�ȣ ���ϴ� ����� ���� �޼ҵ� 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, data[2]);
				//ù��° ����ǥ�� data[2]���� �����մϴ�.
				
				pstmt.setString(2, data[0]);				
						
				int res = pstmt.executeUpdate();
				if (res == 1) {
					JOptionPane.showMessageDialog(this, "ȸ������ ���� ����.");
				} else {
					JOptionPane.showMessageDialog(this, "ȸ������ ���� ����.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� ���� �ʽ��ϴ�.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ڵ� ���� ����");
		}
	}

	// ���� ó�� �κ�
	public void deleteMember() {
		data = getFieldValues(); //�˻��� ��� �ҷ��ɴϴ�.
		String sql = "delete from mem02 where id=?";

		try {
			if (passwdCompare()) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, data[0]);
				int res = pstmt.executeUpdate(); 
				if (res == 1) {
					JOptionPane.showMessageDialog(this, "ȸ��Ż�� ����.");
				} else {
					JOptionPane.showMessageDialog(this, "ȸ��Ż�� ����.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� ���� �ʽ��ϴ�.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ڵ� ���� ����");
		}
	}

	// ��� ��ȣ �� �κ�
	public boolean passwdCompare() {
		boolean test = false;
		String sql = "select passwd from mem02 where id= ?";

		try {
			pstmt = con.prepareStatement(sql);//sql���� �о� �ɴϴ�.
			pstmt.setString(1, data[0]); //����ǥ�� ù��°�� ����� ���̵� �����մϴ�.
			rs = pstmt.executeQuery();//sql���� �����մϴ�.

			if (rs.next()) {
				if (rs.getString("passwd").equals(data[1])) 
					// �˻��� ���̵��� ������ ���̽��� �ִ� ��й�ȣ(passwd)���� 
					// �ؽ�Ʈ �ʵ忡 �Է��� ��й�ȣ(data[1])�� ���մϴ�.
					test = true; 
				    // �Է��� ��й�ȣ�� ������ ���̽��� ��й�ȣ ���� ��ġ�մϴ�.
				else
					test = false; 
				   // �Է��� ��й�ȣ�� ������ ���̽��� ��й�ȣ ���� �ٸ��ϴ�.
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��й�ȣ �񱳽���");
		}
		return test;
	}

	// �ٽ� �ۼ� ó�� �κ�
	public void clearFields() {
		for (int i = 0; i < size; i++)
			fields[i].setText("");
	}

	// �Է��� ȸ�� �������� ���ϴ� �κ�
	public String[] getFieldValues() {
		String values[] = new String[size];

		for (int i = 0; i < size; i++)
			values[i] = fields[i].getText();

		return values;
	}

	// ȸ���� �������� ���� �ϴ� �κ�(������)
	public void setFieldValues(String s[]) {
		for (int i = 0; i < size; i++)
			fields[i].setText(s[i]);

		fields[0].setEnabled(false);
		fields[1].setText("");
		fields[3].setEnabled(false);
	}


   
	public static void main(String[] args) {
		MemberManagement4 management = new MemberManagement4();
	}
}