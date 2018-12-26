//JTable - 표 형태로 데이터를 보여주는 테이블 컴포넌트
//이벤트 미적용
package ex21_6_1_JTable;

import java.awt.*;
import javax.swing.*;

public class WindowExample2_event_no extends JFrame {
	public WindowExample2_event_no() {
		super("참가자 명단 프로그램");

		setLocation(500, 100);

		setPreferredSize(new Dimension(300, 300));

		Container contentPane = getContentPane();

		// 컬럼 이름이 있는 1차원 배열
		String colNames[] = { "이름", "나이", "성별" };
		// 데이터 항목이 있는 2차원 배열
		Object data[][] = { { "김철수", 24, '남' }, 
							{ "이순희", 21, '여' }, 
							{ "박지영", 26, '여' } };

		//javax.swing.JTable.JTable(Object[][] rowData, Object[] columnNames)
		//첫번째 파라미터 : 2차원 배열(데이터 항목), 두번째 파라미터 : 1차원 배열(컬럼 이름)
		//JTable 생성합니다.
		JTable table = new JTable(data, colNames);
		
		//테이블에 올려진 ScrollPane을 생성합니다.
		JScrollPane scrollPane = new JScrollPane(table);
		
		//contentPane에 scrollPane을 BorderLayout.CENTER에 배치합니다.
		contentPane.add(scrollPane, BorderLayout.CENTER);

		//버튼을 생성합니다.
		JButton button = new JButton("출력");

		//new PrintActionListener(table) : 리스너 생성
		//출력 버튼 처리 리스너를 등록합니다.
		button.addActionListener(new PrintActionListener(table));
		contentPane.add(button, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample2_event_no w = new WindowExample2_event_no();
	}

}
