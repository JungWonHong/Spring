package ex7_0_object;

public class Saram_make5 {

	public static void main(String[] args) {
		Saram5 s = new Saram5(40, "김유정");
		//s.name = "김유정";
		s.age = 17;
		//s.w = 40;
		s.ki = 160;
		s.eat();
		s.walk();

		//Saram5 s2 = new Saram5("박보검", 65);
		Saram5 s2 = new Saram5(65, "박보검");
		//s2.name = "박보검";
		s2.age = 23;
		//s2.w = 65;
		s2.ki = 182;
		s2.eat();
		s2.walk();

	}

}
