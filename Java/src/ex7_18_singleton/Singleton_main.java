package ex7_18_singleton;

public class Singleton_main {

	public static void main(String[] args) {
		//Singleton obj1 = new Singleton();  //에러발생
		//Singleton obj2 = new Singleton();  //에러발생
		Singleton obj1 = Singleton.getInstance();  //obj1에 주소값을 저장
		Singleton obj2 = Singleton.getInstance();  //obj2에 주소값을 저장

		if (obj1 == obj2) {  //정적메소드이기 때문에 주소가 같다.
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}

	}

}
