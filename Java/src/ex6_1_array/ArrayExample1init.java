package ex6_1_array;

public class ArrayExample1init {

	public static void main(String[] args) {
		int arr[]; 			// �迭 ���� ����
		arr = new int[10];  // �迭 ����
							// new�� ���� �迭�� �ڵ� �ʱ�ȭ - int�� : 0, double�� : 0.0
		// for(int i=0;i<10;i++)
		for (int i = 0; i < arr.length; i++) //length�� �迭�� �Ӽ����� �迭�� ũ�⸦ �����ش�.
			System.out.println("arr[" + i + "]" + "=" + arr[i]);

	}

}
