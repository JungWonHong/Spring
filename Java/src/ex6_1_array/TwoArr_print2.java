package ex6_1_array;

public class TwoArr_print2 {

	public static void main(String[] args) {
		
		int[][] score = new int[][]{{100,100,100},
									{20, 20},
									{30, 30, 30},
									{40, 40, 40, 40},
									{50, 50, 50, 50, 50}
								   };
				
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i + "].length : " + score[i].length);
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}

			System.out.println();
		}

	}

}
