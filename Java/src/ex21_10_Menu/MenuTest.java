package ex21_10_Menu;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MenuTest extends JFrame {

	private MenuBar bar;
	private Menu file, edit, view, helpMenu;//���� ���� ���� ����
	private MenuItem open, save, print, exit;//���� ���� �μ�  ����
	private MenuItem cut, paste, clear;
	private MenuItem help, info;

	public MenuTest() {
		super("Java Edit");

		//window�� �ݱ� ��ư�� Ŭ������ ���� �̺�Ʈ�� �͸��� Ŭ������ �����߽��ϴ�.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// x ��ư�� Ŭ���������.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		bar = new MenuBar();
		file = new Menu("����");//�޴�
		edit = new Menu("����");
		view = new Menu("����");
		helpMenu = new Menu("����");

		open = new MenuItem("����");//�޴� �׸�
		save = new MenuItem("����");
		print = new MenuItem("�μ�");
		exit = new MenuItem("����");

		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(print);
		file.addSeparator();
		file.add(exit);

		edit.add(cut = new MenuItem("�߶󳻱�"));
		edit.add(paste = new MenuItem("�ٿ��ֱ�"));
		edit.add(clear = new MenuItem("�����"));

		helpMenu.add(help = new MenuItem("���� �׸�"));
		helpMenu.addSeparator();
		helpMenu.add(info = new MenuItem("Java Edit ����"));

		bar.add(file);
		bar.add(edit);
		bar.add(view);
		bar.add(helpMenu);

		setMenuBar(bar);
		setSize(400, 200);
		setVisible(true);
	}// ������ end

	public static void main(String[] args) {
		MenuTest mt = new MenuTest();
	}
}
