package ex15_2_Stack;

import java.util.Stack;

public class Stack4 {
	// Stack ��ü ����
	public static Stack<String> back = new Stack<String>();
	public static Stack<String>	forward = new Stack<String>();
	
	public static void main(String[] args) {
		goURL("1. �Ҿƹ���");
		goURL("2. �ƹ���");
		goURL("3. ��");
		goURL("4. �ڽ�");
		print("����");
		
		goBack();
		print("goBack");
		
		goBack();
		print("goBack");
		
		goBack();
		print("goBack");
		
		goBack();
		print("goBack");
		
		goForward();
		print("goForward");
		
		goForward();
		print("goForward");
		
		goForward();
		print("goForward");
		
		goForward();
		print("goForward");
	}
	
	static void goURL(String url){
		back.push(url);
		if(!forward.empty())
			forward.clear();
	}
	
	static void goForward(){//������ ����
		if(!forward.empty())
			back.push(forward.pop()); //�ٽ� �ڷ� �� �� ������ ������ �� �ָ� back�� �־��
	}
	
	static void goBack(){ //�ڷ� ����
		if(back.size() > 1)
			forward.push(back.pop()); //�ٽ� ������ �� �� ������ ������ �� �ָ� forward�� �־��
	}
	
	static void print(String s){
		System.out.println("========== " + s + "=============");
		if(!back.empty()){
			System.out.println(back);
			System.out.println("���� ȭ���� '" + back.peek() + "' �Դϴ�.");
		}
	}

}
