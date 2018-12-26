

/*
 * create  table  mem02(
 * id         varchar2(20)  primary key,  --기본키 : 중복 될 수 없어요
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
  { // 1단계
	// 클래스와 인터페이스를 동시에 상속 받을 때는 순서에 맞게 사용해야 합니다.

	Connection con;
	PreparedStatement pstmt;// SQL 실행 시켜 주기 위해 사용, 
	                        //SQL문이 복잡할 경우에 사용하면 좋아요
	Timestamp reg_date; // 날짜 관련 클래스 
       //Date, Calendar, Timestamp 

	private String names[] = { "아이디", "비밀번호", 
			                   "비밀번호 재입력", "이름" };
	private JLabel labels[];
	private JTextField fields[];
	private JButton register, cancle, reWrite;
	private JPanel panelCenter, panelSouth;
	private int size = 4;

	public InsertMember4() {//생성자
		super("회원등록");//매개변수 : 제목 표시줄 출력될 문자열

		labels = new JLabel[size];
		fields = new JTextField[size];

		for (int i = 0; i < labels.length; i++)
			labels[i] = new JLabel(names[i]); // 레이블 값 설정
		// labels[0]="아이디"       ,labels[1]="비밀번호"
		// labels[2]="비밀번호 재입력",labels[3]="이름"
		
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

		register = new JButton("회원등록");
		cancle = new JButton("종료");
		reWrite = new JButton("다시작성");

		panelSouth = new JPanel();
		panelSouth.add(register);
		panelSouth.add(cancle);
		panelSouth.add(reWrite);
		
		//JFrame의 메소드들
		//기존의     Container contentPane = frame.getContentPane();와
		//contentPane.add(); 기능을     add메소드로 처리 가능(JDK 1.5버전부터)
		add(panelCenter, "Center");
		add(panelSouth, "South");  
				
		setBounds(300, 300, 300, 250);// 위치(x,y)와 크기(가로,세로)
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3단계
		register.addActionListener(this); // 회원 등록
		cancle.addActionListener(this); // 종료
		reWrite.addActionListener(this); // 다시 작성			
		
	}// 생성자 end

	// Database 연결 부분
	public void dbConnect() {		
		try {
			// JDBC 로딩부터 체크 : 해당 위치에 드라이버 파일이 없으면 에러 발생합니다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userId = "scott";
			String userPass = "tiger";
			
			// 데이터 베이스 접속 체크
			con = DriverManager.getConnection(url, userId, userPass);
			}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩에 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("커넥션 설정에 실패");
		}
	}//연결 끝

	// Event 처리 부분
	public void actionPerformed(ActionEvent ae) { // 2단계
		if (ae.getSource() == register) { // 회원 등록 버튼 클릭한 경우
			dbConnect();
			insertMember();
			clearFields();
		} else if (ae.getSource() == cancle) { // 종료 버튼 클릭한 경우
			// System.exit(0); //열려 있는 모든 창 닫아줍니다.
			dispose();// 현재 창만 닫아 줍니다.
		} else if (ae.getSource() == reWrite) { // 다시작성 버튼 클릭한 경우
			clearFields();
		}
	}

	// 회원 가입 처리 부분
	public void insertMember() {
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());// 현재 날짜,시간
		String data[] = getFieldValues();// 메소드 호출 
		 if(data[0].equals("") || 
		    data[1].equals("") || 
		    data[2].equals("") ||
		    data[3].equals(""))		
		{
			JOptionPane.showMessageDialog(this, "모든 정보를 입력 하세요!");
		 }else if(data[1].equals(data[2])){ //비밀 번호가 일치하면 query문 실행
			String sql = "insert into mem02 values(?,?,?,?)";
			try {
				// sql문 읽어 오고 수행 결과	PreparedStatement 객체가
				// 생성됩니다.
				pstmt = con.prepareStatement(sql); 
				
				pstmt.setString(1,data[0]); //아이디
				pstmt.setString(2,data[1]); //비밀번호
				pstmt.setString(3,data[3]); //이름
				pstmt.setTimestamp(4, reg_date); // 네번째 물음표에 회원가입 날짜 시간이 설정됩니다.
				                                                 
				int result = pstmt.executeUpdate();  //SQL문 실행

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "회원 가입 완료");
					 this.dispose(); //첫번째 프레임 닫는다. 
					// 주석이면 닫지 않아 첫번째 프레임과 두번째 프레임이 나타난다.
										
					MemberManagement4 management = new MemberManagement4(); //두번째 프레임 열립니다.

				} else {
					JOptionPane.showMessageDialog(this, "회원 가입 실패");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("새로운 레코드 추가에 실패");
			}

		} else { // 비밀 번호가 일치하지 않으면 메시지 박스
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
		}
	}

	// 다시 작성 처리 부분
	public void clearFields() {
		for (int i = 0; i < size; i++) {
			fields[i].setText("");
		}
	}

	// 입력한 회원 정보값을 구하는 부분
	public String[] getFieldValues() { // 반환형(String[]): 배열 참조형(주소값을 가지고 있어요)
		String values[] = new String[size]; // 주소값을 넘겨 주기 위해서는 new로 생성해야 합니다.
											// 힙 영역에 String형으로 4개를 만들고 그 주소를
											// values에 할당합니다.
		for (int i = 0; i < size; i++)
			values[i] = fields[i].getText();

		return values;
	}

	public static void main(String[] args) {
		InsertMember4 insert = new InsertMember4();
	}
}











