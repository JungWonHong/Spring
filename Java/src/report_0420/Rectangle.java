package report_0420;
/*   

1. 예외처리의 정의와 목적에 대해서 설명하시오.
  예외란 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류를 뜻한다. 
  예외처리는 프로그램 실행시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것으로 프로그램의 비정상 종료를 막고 정상적인 실행상태를 유지하기 위함이다.
2. 다음은 실행도중 예외가 발생하여 화면에 출력된 내용입니다.
 	설명을 해보세요. 
	java.lang.Exception: getTotal() : 비어 있는 배열입니다.
		at ex12_1_Exception.ExceptionExample7.getTotal(ExceptionExample7.java:27)
		at ex12_1_Exception.ExceptionExample7.main(ExceptionExample7.java:8)
		
		==>예외가 발생했을 때, 모두 2개의 메소드(main, getTotal)가 호출스택에 있으며,
			예외가 발생한곳은 제일 윗줄에 getTotal이고 main메서드가 getTotal메소드를 호출 했다는 것을 알수있다.
			getTotal메소드 내에서 "getTotal() : 비어 있는 배열입니다."를 출력해주며 예외를 처리해 준다.
 
*/
//3.
public class Rectangle {
	int width, height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectangle)
			return (width == ((Rectangle)obj).width) && (height == ((Rectangle)obj).height);
		else
			return false;
	}

	public String toString() {
		return "가로는 " + width + ", 세로는 " + height;
	}
}
