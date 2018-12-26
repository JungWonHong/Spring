package ex5_6_break;

public class BreakExample1 {

	public static void main(String[] args) {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.println(cnt);
			
			if (cnt == 5)
				break;
		}
	}

}
