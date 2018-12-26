package report_0418;

public class Lotto {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		
		lottoMake(lotto);

		for (int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "\t");
		
		System.out.println();
		
		sortNum(lotto);
		
		for (int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + "\t");
	}
	
	static int[] lottoMake(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			int num = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i + 1;) {
				if (num == lotto[j]) {
					num = (int) (Math.random() * 45 + 1);
					j = 0;
				} else
					j++;

			}
			lotto[i] = num;
		}
		
		return lotto;
	}

	static int[] sortNum(int[] lotto) {
		for (int i = 0; i < lotto.length - 1; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		return lotto;
	}

}
