package ex16_2_System_gc;

public class ResourceUser {
	ResourceUser(){
		System.out.println("시스템 자원을 할당 받습니다.");
	}
	void use(){
		System.out.println("시스템 자원을 사용합니다.");
	}
	
	//가비지 콜렉터는 객체를 제거하기 전에 finalize() 메소드를 호출합니다.
	protected void finalize(){ //Objecr클래스의 finalize() 오버라이딩
		System.out.println("시스템 자원의 할당을 해제합니다.");
	}
}
