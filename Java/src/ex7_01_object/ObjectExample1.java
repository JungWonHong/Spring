package ex7_01_object;

public class ObjectExample1 {

	public static void main(String[] args) {
		
		StringBuffer obj; 					// 변수선언
		obj = new StringBuffer("Hey, Java");// 객체생성
		obj.deleteCharAt(1); // Hy, Java
		obj.deleteCharAt(1); // H,Java
		obj.insert(1, 'i');  // Hi, Java
		System.out.println(obj); // StringBuffer 객체를 넘겨줄 수 있습니다.

	}

}
