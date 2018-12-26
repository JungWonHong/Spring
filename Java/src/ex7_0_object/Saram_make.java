package ex7_0_object;

public class Saram_make {

	public static void main(String[] args) {
		Saram  s   =  new Saram();
	//  클래스 참조변수 = 연산자 생성자호출	
		s.name = "김유정";
		s.age = 17;
		s.w = 40;
		s.ki = 160;
		System.out.println(s.name);
		s.eat();
		
		Saram s2 = new Saram();
		s2.name = "박보검";
		s2.age = 23;
		s2.w = 65;
		s2.ki = 182;
		System.out.println(s2.name);
		s2.eat();

	}

}
