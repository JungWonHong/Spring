//공유 영역 클래스
package ex17_14_Thread_state_2;

public class SharedArea {
	double result;
	
	//공유 데이터가 쓰여졌는지 여부를 표현하는 필드 - 디폴트(false)
	boolean isReady;
}
