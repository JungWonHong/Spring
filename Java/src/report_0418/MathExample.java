//1~45���� ���� 6���� ������� �߻��ϴ� ���α׷�
/*
���� �߻� ����
����=(����ȭ)((���Ѱ�-���Ѱ�+1)*�����߻���ġ+���Ѱ�)
*/

package report_0418;

public class MathExample {

	public static void main(String[] args) {

		int num[] = new int[6];// �ߺ��� ������ Ȯ���ϰ��� �迭 �����
		lottomake(num); //�ζ� ��ȣ 6���� ����ϴ�.
		sort(num);      //6���� �ζǸ� �����մϴ�.
		for(int l : num)//����մϴ�.
			System.out.print(l + "\t");
	}

	static void lottomake(int num[]) {
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break;
				} // if end
			} // for end
		} // for end
	}

	static void sort(int[] num) {
		int imsi;
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					imsi = num[i];
					num[i] = num[j];
					num[j] = imsi;
				}
			}
		}
	}
}
