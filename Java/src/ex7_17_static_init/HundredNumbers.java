//초기화 블록을 포함하는 클래스의 예
/*멤버변수의 초기화 방법
1. 명시적 초기화 - 변수 선언과 동시에 초기화 하는 것
 예) int sum = 0;			//기본형 변수의 초기화
 	Circle c = new Circle();//참조형 변수의 초기화
2. 생성자
3. 초기화 블럭
	1) 인스턴스 변수 초기화 블럭 : 인스턴스 변수를 초기화 하는데 사용
	  -인스턴스 변수가 생성될 때마다 각 인스턴스별로 초기화가 이루어 집니다.
	  -인스턴스 변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자
	2) 클래스 변수 초기화 블럭 : 클래스 변수를 초기화 하는데 사용
	     클래스 변수가 처음 로딩될 때 단 한번 초기화 됩니다.
	  -클래스 변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블럭
 */
package ex7_17_static_init;

public class HundredNumbers {

	static int arr[];

	HundredNumbers() {
		System.out.println("여기는 생성자 입니다.");
	}

	// 클래스 초기화(정적 초기화) 블록
	static {
		System.out.println("클래스 초기화 블럭");
		arr = new int[100];
		for (int cnt = 0; cnt < 100; cnt++) {
			arr[cnt] = cnt;
			System.out.print(arr[cnt] + "\t");
		}
	}
	
	// 인스턴스 초기화 블럭
	{
		System.out.println("인스턴스 초기화 블럭");
	}

}
