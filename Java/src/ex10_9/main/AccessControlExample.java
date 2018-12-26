package ex10_9.main;

import ex10_9.geometry.shape.Square1;


public class AccessControlExample {

	public static void main(String[] args) {
		Square1 sq = new Square1(100, 200, 15);

		for(int i = 0;i<4;i++){
			System.out.print("x["+i+"]="+sq.getX(i)+" ");
			System.out.print("y["+i+"]="+sq.getY(i));
			System.out.println();
		}
		
		for (int i = 0; i < 4; i++)
			System.out.println("(" + sq.getX(i) + "," + sq.getY(i) + ")");

	}

}
