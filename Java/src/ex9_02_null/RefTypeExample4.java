package ex9_02_null;
//obj변수에 null이라는 참조값이 있기 때문에 컴파일 에러는 없지만
//실행시 에러 발생(런타임 에러발생) - 아무 데이터도 가르키지 않기때문
public class RefTypeExample4 {

	public static void main(String[] args) {
		Point obj = null;
		//obj = new Point(10,20);
		System.out.println(obj.x);
		System.out.println(obj.y);
		//java.lang.NullPointerException
	}

}
