//환경 변수는 운영체제에 속하는 변수로 주로 프로그램의 실행환경을 설정하는 데 사용합니다.
//환경변수 path의 값을 읽어오는 예제
package ex16_1_System_in_out_error;

public class System4_getenv {

	public static void main(String[] args) {
		//getenv() 메소드 : 환경 변수 "path"를 읽어옵니다.
		//"path"를 제외한 다른 환경 변수들을 운영체제마다 이름도 다르고
		//사용 목적도 달라서 시스템 프로퍼티를 사용합니다.
		String str = System.getenv("path");
		System.out.println(str);
	}

}
