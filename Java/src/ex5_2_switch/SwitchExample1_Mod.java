package ex5_2_switch;

public class SwitchExample1_Mod {

	public static void main(String[] args) {
		int num = 3;

		switch (num) {
		case 1:
			System.out.println("Good Morning, Java");
		case 2:
			System.out.println("Good Afternoon, Java");
		case 3:
			System.out.println("Good Evening, Java");
		default:
			System.out.println("Hello, Java");
		}
		System.out.println("Done.");
	}

}
