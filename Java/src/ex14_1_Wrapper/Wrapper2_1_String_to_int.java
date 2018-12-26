//문자열로 입력된 값을 연산 처리하기 위한 방법?
package ex14_1_Wrapper;

public class Wrapper2_1_String_to_int {

	public static void main(String[] args) {
		int total = 0;
		
		for(int cnt = 0;cnt<args.length;cnt++){
			//에러발생(String -> int 형변환 요구)
			total = args[i] + total;
		}
		System.out.println(total);
	}

}
