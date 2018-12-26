//시스템 프로퍼티를 모두 가져와서 출력하는 프로그램
//시스템 프로퍼티는 자바 프로그램의 실행 환경에 대한 여러 가지 정보를 담는 역할을 하는
//일종의 변수로
//자바 가상 기계가 자바 프로그램을 시작할 때 운영체제로부터 읽어와서 자동으로 설정합니다.
package ex16_1_System_in_out_error;
import java.util.*;
public class System5_getProperties {

	public static void main(String[] args) {
		//시스템 프로퍼티를 모두 가져옵니다.
		Properties props = System.getProperties();
		
		//가져온 시스템 프로퍼티를 출력합니다.
		// props 객체에 있는 모든 프로퍼티들을 System.out으로 출력합니다.
		props.list(System.out);
	}

}
