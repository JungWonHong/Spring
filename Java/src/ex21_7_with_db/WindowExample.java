//테이블에 행을 추가/삭제하는 윈도우 프로그램
//테이블의 추가는 DefaultTableModel 클래스의 addRow 메소드와
//insertRow메소드를 호출한다.
//테이블에 있는 특정 행을 삭제하기 위해서는 DefaultTableModel 클래스의
//removeRow 메소드를 사용한다.
package ex21_7_with_db;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class WindowExample extends JFrame{
	WindowExample(){
		super("참가자 명단 프로그램");

		setLocation(500, 100);

		setPreferredSize(new Dimension(400, 200));

		Container contentPane = getContentPane();
		
		//테이블 생성해서 contentPane에 추가합니다.
		String colNames[] = {"이름", "나이", "성별"};
		Object data[][];
		JdbcEx5 je = new JdbcEx5();
		data = je.infoselect(); //DB접속해서 데이터 가져오는 메소드
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		
		for(int i=0;i<data.length;i++)
			model.addRow(data[i]); //DB에서 가져온 데이터 테이블에 추가하기

		//contentPane에 JScrollPane을 BorderLayout.CENTER로 배치합니다.
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//패널, TextField, Button 생성합니다.
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField(6); //괄호안의 숫자는 텍스트필드의 사이즈(크기)
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(2);
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		
		//패널에 위에서 만든 컴포넌트들을 추가합니다.
		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("나이"));
		panel.add(text2);
		panel.add(new JLabel("성별"));
		panel.add(text3);
		panel.add(button1);
		panel.add(button2);
		
		//패널을 contentPane에 BorderLayout.SOUTH으로 배치합니다.
		contentPane.add(panel, BorderLayout.SOUTH);
		
		//3단계
		//추가 버튼을 리스너에 등록합니다.
		button1.addActionListener(new AddActionListener(table, text1, text2, text3));
		
		//삭제 버튼을 리스너에 등록합니다.
		button2.addActionListener(new RemoveActionListener(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();

		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowExample w = new WindowExample();
	}
}
