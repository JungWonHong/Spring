package ex21_10_Menu;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MenuTest extends JFrame {

	private MenuBar bar;
	private Menu file, edit, view, helpMenu;//파일 편집 보기 도움말
	private MenuItem open, save, print, exit;//열기 저장 인쇄  종료
	private MenuItem cut, paste, clear;
	private MenuItem help, info;

	public MenuTest() {
		super("Java Edit");

		//window의 닫기 버튼을 클릭했을 때의 이벤트를 익명의 클래스로 구현했습니다.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// x 버튼을 클릭했을경우.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		bar = new MenuBar();
		file = new Menu("파일");//메뉴
		edit = new Menu("편집");
		view = new Menu("보기");
		helpMenu = new Menu("도움말");

		open = new MenuItem("열기");//메뉴 항목
		save = new MenuItem("저장");
		print = new MenuItem("인쇄");
		exit = new MenuItem("종료");

		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(print);
		file.addSeparator();
		file.add(exit);

		edit.add(cut = new MenuItem("잘라내기"));
		edit.add(paste = new MenuItem("붙여넣기"));
		edit.add(clear = new MenuItem("지우기"));

		helpMenu.add(help = new MenuItem("도움말 항목"));
		helpMenu.addSeparator();
		helpMenu.add(info = new MenuItem("Java Edit 정보"));

		bar.add(file);
		bar.add(edit);
		bar.add(view);
		bar.add(helpMenu);

		setMenuBar(bar);
		setSize(400, 200);
		setVisible(true);
	}// 생성자 end

	public static void main(String[] args) {
		MenuTest mt = new MenuTest();
	}
}
