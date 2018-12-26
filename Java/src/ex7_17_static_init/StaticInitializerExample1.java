package ex7_17_static_init;
//HundredNumbers 클래스를 이용하는 프로그램
//클래스 초기화 블럭과 인스턴스 블럭 사용 예
//13라인을 제거 전과 후의 결과 차이를 확인해 보세요.
public class StaticInitializerExample1 {
	public static void main(String[] args) {
		System.out.println("main 실행시작");
		
		//배열에 있는 항목들 중 3개의 항목을 가져와서 그 값을 출력합니다.
		System.out.println(HundredNumbers.arr[35]); //클래스 로딩 
		System.out.println(HundredNumbers.arr[27]);
		System.out.println(HundredNumbers.arr[63]);
		HundredNumbers h = new HundredNumbers();	//객체 생성, 인스턴스화.
	}

}
