package ex8_15_1_interface_polymorphism;
//단행본 클래스와 부록 CD 클래스를 사용하는 프로그램
public class InterfaceExample2 {

	public static void main(String[] args) {
		Lendable[] arr = new Lendable[3];
		
		arr[0] = new SeparateVolume("883ㅇ", "푸코의 진자", "에코");
		arr[1] = new SeparateVolume("609.2", "서양미술사", "곰브리치");
		arr[2] = new AppCDInfo("02-17", "XML을 위한 자바 프로그래밍");
		
		checkOutAll(arr, "윤지혜", "20161012");
		// 배열의 시작주소를 넘겨준다.
	}
	
	//자바 컴파일러는 컴파일 할 때 변수의 타입만 보고 메소드나
	//필드의 존재 여부를 체크하기 때문에
	//Lendable 인터페이스에 checkOut 메소드가 있어야 컴파일 에러가 없습니다.
	static void checkOutAll(Lendable[] arr, String borrower, String date) {
		for (int i = 0; i < arr.length; i++)
			arr[i].checkOut(borrower, date);
	}

}
