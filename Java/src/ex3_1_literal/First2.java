package ex3_1_literal;

public class First2 {
	public static void main(String args[]){
		//System.out.println() : 괄호안의 내용을 출력한 후 한 행을 띄웁니다.
		//System.out.print()   : 괄호안의 내용을 출력한 후 한 행을 띄지 않고 유지합니다.
		//System.out.printf()  : 서실을 지정해서 출력합니다.
		
		//리터럴(literal) - 그 자체로 값을 의미 하는 것
		System.out.println("출력성공!!");
		System.out.println(30);
		System.out.println(3.14);
		System.out.println('A');
		System.out.println(true);
		System.out.println(false);
		System.out.print("문자열 출력");
		
		System.out.print("======줄이 안바뀜!!====");
		System.out.print("test");
		
		System.out.printf("%s", "자바출력");
		System.out.printf("%f", 42.195); //기본 소수점이하 6자리
		System.out.println(); //줄바꿈
		System.out.printf("%.2f", 42.195); //실수 42.195를 실수 서식 소수점 이하 2자리로 출력
		System.out.printf("%d", 42);
		System.out.printf("%c", 'A');
		System.out.println();
		
		System.out.printf("%s\n", "자바출력"); //\n 줄바꿈
		System.out.printf("%f\n", 42.195); //기본 소수점이하 6자리
		System.out.printf("%.2f\n", 42.195); //실수 42.195를 실수 서식 소수점 이하 2자리로 출력
		System.out.printf("%d\n", 42);
		System.out.printf("%c\n", 'A');
		
	}

}
