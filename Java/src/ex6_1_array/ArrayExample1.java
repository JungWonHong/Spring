package ex6_1_array;

public class ArrayExample1 {

	public static void main(String[] args) {
		int arr[]; 			// �迭 ������ ����, stack������ �޸�Ȯ��
		arr = new int[10];  // �迭 ����, heap������ �޸𸮻���
							// stack������ heap���� ������ �迭�޸��� �ּ�����
		// �迭 ���
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
