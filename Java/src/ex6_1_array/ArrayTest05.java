package ex6_1_array;

public class ArrayTest05 {

	public static void main(String[] args) {
		int[][] num = new int[9][8];

		for (int i = 0; i < num.length - 1; i++) {
			System.out.print("[" + (i + 2) + "]´Ü\t");
		}

		System.out.println();

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = (i + 1) * (j + 2);
			}
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print((j + 2) + "*" + (i + 1) + "=" + num[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
