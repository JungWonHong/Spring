package ex6_1_array;

public class TwoArr_print {

	public static void main(String[] args) {

		int[][] score = new int[][] { { 100, 100, 100 }, 
									{ 20, 20, 20, }, 
									{ 30, 30, 30 }, 
									{ 40, 40, 40 },
									{ 50, 50, 50 }
								  };
								  
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i][0] + "\t" + score[i][1] + "\t" + score[i][2]);
		}
		
		System.out.println("====================");
								  
		for (int[] num1 : score) {
			for (int num2 : num1) {
				System.out.print(num2 + "\t");
			}

			System.out.print("\n");
		}
		
		System.out.println("====================");
		
		for (int i = 0; i < score.length; i++) {  //score가 가리키는것의 갯수
			for (int j = 0; j < score[i].length; j++) { //score[i]가 가리키는것의 갯수
				System.out.print(score[i][j] + "\t");
			}

			System.out.print("\n");

		}
		
	}

}
