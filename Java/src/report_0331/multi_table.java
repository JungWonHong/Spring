package report_0331;

public class multi_table {

	public static void main(String[] args) {
		
		int multi[][] = new int[9][9];
		
		for(int i = 1; i <= multi.length; i++) {
			System.out.print(i+"��\t\t");
		}
		
		System.out.print("\n");
		
		for(int i = 0; i < multi.length; i++) {
			for(int j = 0 ; j < multi[i].length; j++) {
				multi[i][j] = (i + 1) * (j + 1);
				System.out.print((j + 1) + " x " + (i + 1) + " = " + multi[i][j] + "\t");
			}
			
			System.out.print("\n");
		}
		/*
		int multi[][] = new int[10][9];

		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				if (i == 0) {
					System.out.print((j + 1) + "��\t\t");

					continue;
				}

				multi[i - 1][j] = i * (j + 1);

				System.out.print((j + 1) + " x " + i + " = " + multi[i - 1][j] + "\t");
			}
			System.out.print("\n");

		}*/
	}

}
