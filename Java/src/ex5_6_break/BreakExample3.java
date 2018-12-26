package ex5_6_break;

public class BreakExample3 {

	public static void main(String[] args) {

		outerLoop: // 반복문 통째로 나가는것
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				System.out.println("(" + row + "," + col + ")");
				if ((row == 1) && (col == 3))
					break outerLoop;
			}
		}

		System.out.println("Done.");

	}

}
