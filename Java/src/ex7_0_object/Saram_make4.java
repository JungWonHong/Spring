package ex7_0_object;

public class Saram_make4 {

	public static void main(String[] args) {
		Saram4 s = new Saram4("김유정", 40);
		//s.name = "김유정";
		s.age = 17;
		//s.w = 40;
		s.ki = 160;
		s.eat();
		s.walk();

		Saram4 s2 = new Saram4("박보검", 65);
		//s2.name = "박보검";
		s2.age = 23;
		//s2.w = 65;
		s2.ki = 182;
		s2.eat();
		s.walk();

	}

}
