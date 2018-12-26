package ex14_1_Wrapper;

public class Wrapper8_auto_boxing_unboxing {

	public static void main(String[] args) {
		int n01 = 10;
		int n02;
		
		Integer obj01;	//obj01에는 주소값을 가지고 있지 않습니다.
		
		//박싱 - 기본형 값을 객체화
		//int -> Integer
		Integer obj02 = new Integer(20);	//Integer 객체 생성
		
		obj01 = n01; //오토 박싱(jdk 1.5이상 부터 가능)
		//obj01 = new Integer(n01); //박싱
		
		n02 = obj02;	//오토 언박싱
		//n02 = obj02.intValue(); //언박싱
		
		System.out.println(n01 + ", " + obj01);
		System.out.println(n02 + ", " + obj02);
		System.out.println(n01 + ", " + obj01.toString());
		System.out.println(n02 + ", " + obj02.toString());
	}

}
