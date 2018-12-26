package ex5_2_switch;

public class SwitchExample4 {

	public static void main(String[] args) {
		String ch = "+";

		switch (ch) {
		case "+":
			System.out.println("+");
			break;
		case "-":
			System.out.println("-");
			break;
		case "*":
			System.out.println("*");
			break;
		case "/":
			System.out.println("/");
			break;
		default:
			System.out.println("+, -, *, / 중 한개를 입력하세요");
			break;
		}
	}

}
