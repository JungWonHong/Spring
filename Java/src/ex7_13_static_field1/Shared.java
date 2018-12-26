package ex7_13_static_field1;

public class Shared {

	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("sc1.number = " + sc1.number);

		sc1.number++;
		System.out.println("sc1.number = " + sc1.number);

		StaticCount sc2 = new StaticCount();
		System.out.println("sc2.number = " + sc2.number);

		sc2.number++;
		System.out.println("sc2.number = " + sc2.number);
		// 정적 필드(멤버 변수) 사용법 : 클래스명.정적 멤버 변수이름
		// 메모리에 항상 존재하기 때문에 값을 공유로 사용할 때만 사용하면 된다.
		StaticCount.number++;
		System.out.println("StaticCount.number = " + StaticCount.number);

	}

}
