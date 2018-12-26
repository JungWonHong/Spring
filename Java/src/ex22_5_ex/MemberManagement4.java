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
		implements ActionListener {//1단계
	Connection con;
	PreparedStatement pstmt; 

	// select 문은 ResultSet 객체 생성
	ResultSet rs;
	
	String data[]; //멤버변수로 각 메소드마다 사용 가능합니다.

	private String names[] = { "아이디", "비밀번호", "이름", "가입일" };
	private JLabel labels[], label1;
	private JTextField fields[], searchId;
	private JButton update, delete, search, insert;
	private JPanel panelNorth, panelCenter, panelSouth;
	private int size = 4;

	public MemberManagement4() {
		super("회원관리 - 회원정보 검색, 수정, 탈퇴");

		dbConnect();
         
		panelNorth = new JPanel();
		label1 = new JLabel(names[0]);
		searchId = new JTextField(10);
		search = new JButton("검색");

		panelNorth.add(label1);
		panelNorth.add(searchId);
		panelNorth.add(search);

		labels = new JLabel[size];
		fields = new JTextField[size];

		// JLabel 객체 생성
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(names[i]);
			// labels[0]="아이디",labels[1]="비밀번호"
			// labels[2]="이름",labels[3]="가입일"
		}

		// JTextField 객체 생성
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

		update = new JButton("정보수정");
		delete = new JButton("회원탈퇴");
        insert = new JButton("회원가입");
		
		panelSouth = new JPanel();
		panelSouth.add(update);
		panelSouth.add(delete);
		panelSouth.add(insert);

		add(panelNorth,  "North");
		add(panelCenter, "Center");
		add(panelSouth,  "South");		

		search.addActionListener(this);//3단계-컴포넌트와 ActionListener연결 
		update.addActionListener(this); //this - 내자신이 리스너가 된다.
		delete.addActionListener(this);
		insert.addActionListener(this);
		/*
		 * 윈도우 이벤트(WindowEvent) : 윈도우의 상태가 변할 때 발생하는 이벤트이다.
           WindowEvent 관련
           - WndowListener 인터페이스
           - WindowAdapter 클래스
		 */
		this.addWindowListener( //익명처리
		   new WindowAdapter(){
              public void windowClosing(WindowEvent w) { 
            	try { //종료되는 시점에 해야할 일을 기술한 곳.
     			   if (pstmt != null)
     				   pstmt.close();
     			   if (con != null)
     				   con.close();
     		    } catch (Exception e) {
     			    System.out.println(e.getMessage());
     		    }//try end    
                System.out.println("프레임 사라집니다.");
                System.exit(0);// X를 누르면 종료된다.
              }//windowClosing    
        }//WindowAdapter
    );//addWindowListener
		
		setBounds(300, 300, 350, 300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //익명처리와 동일한역할
        
	}// 생성자 end

	
	// Database 연결 부분
	public void dbConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩에 실패");
		}
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "scott";
			String userPass = "tiger";
			con = DriverManager.getConnection(url, userId, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("커넥션 설정에 실패");
		}
	}

	// Event 처리 부분
	public void actionPerformed(ActionEvent ae) {//2단계
		if (ae.getSource() == search) { // 검색
			searchMember();
		} else if (ae.getSource() == update) { // 정보수정
			updateMember();
			clearFields();
		} else if (ae.getSource() == delete) { // 회원탈퇴(삭제)
			deleteMember();
			clearFields();
		} else if (ae.getSource()== insert){ //회원가입
			dispose(); //현재 창 사라지게하고
			new InsertMember4(); //누른 버튼의 폼을 화면에 띄운다.
			
		}
	}

	// 검색 처리 부분
	public void searchMember() {
		String data[] = new String[4];
		String id = searchId.getText().trim();

		if (id.equals("")) { // 아이디를 입력하지 않았을때
			JOptionPane.showMessageDialog(this, "ID를 입력 하세요");	 //경고메세지 출력
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
						
			searchId.requestFocus();//포커스 나타납니다.
		} else {
			String sql = "select * from mem02 where id = ?";
			try {
				pstmt = con.prepareStatement(sql); 
				//sql문을 읽어 와서 실행 후 PreparedStatement 생성합니다.
				
				pstmt.setString(1, id);//첫번째 물음표에 id가 설정됩니다.
				rs = pstmt.executeQuery();

				if (rs.next()) { //쿼리문 실행의 결과가 있을 경우
					data[0] = rs.getString("id");
					data[1] = rs.getString("passwd");
					data[2] = rs.getString("name");
					data[3] = rs.getTimestamp("reg_date").toString();
					//toString()으로 형변환 됩니다.

					// setFieldValues(data);
					//이름만 수정 가능합니다.
					fields[0].setText(data[0]); // 아이디
					fields[0].setEnabled(false);// 입력 불가
					fields[1].setText(""); // 비밀번호
					fields[2].setText(data[2]); // 이름
					fields[3].setText(data[3]); // 가입일
					fields[3].setEnabled(false);// 입력 불가

					searchId.setText("");

				} else { //쿼리문 실행의 결과가 없는 경우
					JOptionPane.showMessageDialog(this, "그런 아이디가 없습니다.");
					searchId.setText("");
					return;
				}

				// setFieldValues(data);
				// searchId.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("레코드 검색 실패");
			}
		}// if~else end
	}

	// 수정 처리 부분
	public void updateMember() {
		data = getFieldValues();//getFieldValues() 메소드 호출
		
		//이름과 날짜를 갱신합니다.
		String sql = "update mem02 set name=?, reg_date=sysdate "
				   + "where id=? ";
		//sysdate : 현재날짜를 구해줍니다.날짜도 수정됩니다. 
		
		
		try {
			if (passwdCompare()) {
				//passwdCompare():비밀번호 비교하는 사용자 정의 메소드 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, data[2]);
				//첫번째 물음표에 data[2]값을 설정합니다.
				
				pstmt.setString(2, data[0]);				
						
				int res = pstmt.executeUpdate();
				if (res == 1) {
					JOptionPane.showMessageDialog(this, "회원정보 수정 성공.");
				} else {
					JOptionPane.showMessageDialog(this, "회원정보 수정 실패.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("레코드 수정 실패");
		}
	}

	// 삭제 처리 부분
	public void deleteMember() {
		data = getFieldValues(); //검색된 결과 불러옵니다.
		String sql = "delete from mem02 where id=?";

		try {
			if (passwdCompare()) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, data[0]);
				int res = pstmt.executeUpdate(); 
				if (res == 1) {
					JOptionPane.showMessageDialog(this, "회원탈퇴 성공.");
				} else {
					JOptionPane.showMessageDialog(this, "회원탈퇴 실패.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("레코드 삭제 실패");
		}
	}

	// 비밀 번호 비교 부분
	public boolean passwdCompare() {
		boolean test = false;
		String sql = "select passwd from mem02 where id= ?";

		try {
			pstmt = con.prepareStatement(sql);//sql문을 읽어 옵니다.
			pstmt.setString(1, data[0]); //물음표의 첫번째에 사용자 아이디를 설정합니다.
			rs = pstmt.executeQuery();//sql문을 실행합니다.

			if (rs.next()) {
				if (rs.getString("passwd").equals(data[1])) 
					// 검색한 아이디의 데이터 베이스에 있는 비밀번호(passwd)값과 
					// 텍스트 필드에 입력한 비밀번호(data[1])를 비교합니다.
					test = true; 
				    // 입력한 비밀번호와 데이터 베이스의 비밀번호 값이 일치합니다.
				else
					test = false; 
				   // 입력한 비밀번호와 데이터 베이스의 비밀번호 값이 다릅니다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("비밀번호 비교실패");
		}
		return test;
	}

	// 다시 작성 처리 부분
	public void clearFields() {
		for (int i = 0; i < size; i++)
			fields[i].setText("");
	}

	// 입력한 회원 정보값을 구하는 부분
	public String[] getFieldValues() {
		String values[] = new String[size];

		for (int i = 0; i < size; i++)
			values[i] = fields[i].getText();

		return values;
	}

	// 회원의 정보값을 설정 하는 부분(수정시)
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