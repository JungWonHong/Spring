//특정 시스템 프로퍼티 값을 가져와서 출력하는 프로그램
package ex16_1_System_in_out_error;

public class System6_getProperty {

	public static void main(String[] args) {
		//uesr.dir 시스템 프로퍼티의 값을 가져옵니다.
		String str = System.getProperty("user.dir");
		
		//가져온 값을 출력합니다.
		System.out.println(str);
	}

}
