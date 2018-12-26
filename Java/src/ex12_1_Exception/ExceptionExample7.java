//printStackTrace�޼ҵ��� ��� ��(getMessage()�ʹ� �ٸ��� ������α��� ����)
//���� �߻� ����� ȣ�� ���ÿ� �־��� �޼����� ������ ���� �޽����� ȭ�鿡 ����մϴ�.
package ex12_1_Exception;

public class ExceptionExample7 {

	public static void main(String[] args) {
		try {
			int arr[] = new int[0];
			System.out.println("�հ�" + getTotal(arr));
			System.out.println("���" + getAverage(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static double getAverage(int arr[]) throws Exception {
		if (arr.length == 0)
			throw new Exception("getAverage() : ��� �ִ� �迭�Դϴ�.");
		// Exception e = new Exception("getAverage() : ��� �ִ� �迭�Դϴ�.");
		// throw e;
		// 19������ ������ �� �ٷ� ����� �� �ֽ��ϴ�.
		return getTotal(arr) / arr.length;
	}

	static int getTotal(int arr[]) throws Exception {
		if (arr.length == 0)
			throw new Exception("getTotal() : ��� �ִ� �迭�Դϴ�.");
		int total = 0;
		for (int num : arr)
			total += num;
		return total;
	}
}
