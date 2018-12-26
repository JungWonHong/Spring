package ex4_08_arithmetic_op;

import java.io.InputStream;
import java.util.Scanner;

public class Oper02 {

	public static void main(String[] args) {
		InputStream is = System.in;
		
	//	클래스명	객체   연산자 생성자호출(인자값이 맞게들어가야함)
		Scanner sc = new Scanner(is);   
	//	Scanner sc = new Scanner(System.in); //위의 과정 생략 후 한번에도 가능.
		
		System.out.print("정수를 입력 하세요?");
		
		int n = sc.nextInt(); //정수값 입력
		
		System.out.println("입력값은 " + n + "입니다.");
		
		sc.close(); //쓰레기값 제거
	}

}
