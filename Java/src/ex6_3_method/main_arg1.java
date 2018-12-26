//실행방법
//1. 이클립스에서 실행 순서
//	1) 해당 소스에서 Ctrl + F11
//	2) Package Explorer에서 소스를 선택 후 오른쪽 마우스 버튼 클릭
//		-> Run as -> Run Configurations
//		-> 오른쪽 화면의 Arguments 탭 선택 후
//		-> Program Arguments 상자에서 값을 입력한다.
//		-> 두 개 이상 사용시에는 blank, Enter로 구분한다.


/*2.cmd 환경
 C:\workspace_java\Java_ex\bin 밑에 패키지
 	ex6_2안에 main_arg1.class 가 있는 경우 실행방법 //이것이 있다는 것을 확인하는 것이 중요하다.
 	
첫째 : C:\User\User>Java - classpath "C:\workspace_Java\Java_ex\bin" ex6_2.main_arg1 대한이 민국이 만세
	C:\User\User>Java - cp "C:\workspace_java\Java_ex\bin" ex6_2.main_arg1 대한이 민국이 만세

둘쨰 : C:\workspace_Java\Java_ex\bin>java ex6_2.main_arg1 대s한이 민국이 만세

셋째 : 환경변수 설정 classpath란에 ";C:\workspace_Java\Java_ex\bin을 설정해 주면
	C:\User\User>Java ex6_2.main_arg1 대한이 민국이 만세

 */

package ex6_3_method;

public class main_arg1 {

	public static void main(String[] a) {

		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		
	}

}

