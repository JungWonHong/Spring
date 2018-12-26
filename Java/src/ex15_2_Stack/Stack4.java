package ex15_2_Stack;

import java.util.Stack;

public class Stack4 {
	// Stack 객체 생성
	public static Stack<String> back = new Stack<String>();
	public static Stack<String>	forward = new Stack<String>();
	
	public static void main(String[] args) {
		goURL("1. 할아버지");
		goURL("2. 아버지");
		goURL("3. 나");
		goURL("4. 자식");
		print("원본");
		
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
	
	static void goForward(){//앞으로 가기
		if(!forward.empty())
			back.push(forward.pop()); //다시 뒤로 갈 수 있으니 끄집어 낸 애를 back에 넣어둠
	}
	
	static void goBack(){ //뒤로 가기
		if(back.size() > 1)
			forward.push(back.pop()); //다시 앞으로 갈 수 있으니 끄집어 낸 애를 forward에 넣어둠
	}
	
	static void print(String s){
		System.out.println("========== " + s + "=============");
		if(!back.empty()){
			System.out.println(back);
			System.out.println("현재 화면은 '" + back.peek() + "' 입니다.");
		}
	}

}
