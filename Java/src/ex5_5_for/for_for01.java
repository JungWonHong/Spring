package ex5_5_for;

public class for_for01 {

	public static void main(String[] args) {
		System.out.println("=== ������ ===");

		for (int i = 1; i <= 10; i++) {
			System.out.println("=== " + i + "��" + " ===");
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
	}

}
