package ex5_7_continue;

public class ContinueExample3 {

	public static void main(String[] args) {
		outerLoop: for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				if ((row) == 1 && (col == 3))
					continue outerLoop;

				System.out.println("(" + row + "," + col + ")");
			}
		}
		System.out.println("Done.");
	}

}
