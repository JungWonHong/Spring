package ex6_1_array;

public class ArrayTest03 {

	public static void main(String[] args) {

		int data[] = { 20, 30, 40, 80, 10 };
		int max = data[0], min = data[0];

		for (int i = 0; i < data.length; i++) {
			if (max <= data[i])
				max = data[i];

			if (min >= data[i])
				min = data[i];
		}

		System.out.println("max = " + max + "\nmin = " + min);

	}

}
