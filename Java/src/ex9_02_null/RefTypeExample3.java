package ex9_02_null;
//지역 변수 obj에 초기화 하지 않아 발생하는 에러
public class RefTypeExample3 {

	public static void main(String[] args) {
		Point obj;
		
		//The local variable obj man not have been initialized
		System.out.println(obj.x);

		System.out.println(obj.y);
	}

}
