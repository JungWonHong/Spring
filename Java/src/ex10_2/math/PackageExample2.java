//다른 패키지의 클래스를 사용하는 프로그램 - 잘못된 예(컴파일 에러 발생)
package ex10_2.math;	//패키지 선언문

public class PackageExample2 {

	public static void main(String[] args) {
		Rectangle obj = new Rectangle(2, 3); //컴파일 에러  얘가 어디서 뭐하는앤지 몰라서 오류 발생!
		System.out.println("넓이 = " + obj.width);
		System.out.println("높이 = " + obj.height);
		System.out.println("면적 = " + obj.getArea());
	}

}
