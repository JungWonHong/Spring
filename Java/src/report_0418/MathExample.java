//1~45까지 난수 6개를 순서대로 발생하는 프로그램
/*
난수 발생 공식
난수=(정수화)((상한값-하한값+1)*난수발생장치+하한값)
*/

package report_0418;

public class MathExample {

	public static void main(String[] args) {

		int num[] = new int[6];// 중복된 데이터 확인하고자 배열 사용함
		lottomake(num); //로또 번호 6개를 만듭니다.
		sort(num);      //6개의 로또를 정렬합니다.
		for(int l : num)//출력합니다.
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
