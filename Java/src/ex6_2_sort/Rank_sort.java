package ex6_2_sort;

public class Rank_sort {

	public static void main(String[] args) {
		int a[][] = { { 30, 1 }, 
				      { 20, 1 }, 
				      { 10, 1 }, 
				      { 40, 1 }, 
				      { 50, 1 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				if (a[i][0] < a[j][0])
					a[i][1]++;
		}

		System.out.print("원본\t등수\n");
		for (int k = 0; k < a.length; k++)
			System.out.print(a[k][0] + "\t" + a[k][1] + "\n");
		
		System.out.println("============");
		
		
		/*// 선택정렬
		for (int i = 0;i < a.length-1 ; i++)
			for(int j = i+1 ; j<a.length;j++){
				if(a[i][0]<a[j][0]){
					int[] temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}*/
		
		// 버블정렬
		for (int i = 0; i < a.length - 1; i++)
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j][0] < a[j+1][0]) {
					int[] temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}

		System.out.print("원본\t등수\n");
		for (int k = 0; k < a.length; k++)
			System.out.print(a[k][0] + "\t" + a[k][1] + "\n");
	}

}
