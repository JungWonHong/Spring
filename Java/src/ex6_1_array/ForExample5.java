package ex6_1_array;

public class ForExample5 {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };

		// ���� for��
		for (int num : arr)
			System.out.println(num);

		System.out.println("Done.\n");

		// for��
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		System.out.println("Done.");
	}

}
