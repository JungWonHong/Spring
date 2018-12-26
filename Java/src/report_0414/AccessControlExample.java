/*   
 * 1) ex10_9.geometry.common.Polygon 클래스와
      ex10_9.geometry.shape.Square 클래스를 사용하여 
      (x,y)-> (100,200) 위치에
      길이가 15 인 정사각형의 각 꼭지점의 좌표를 
      출력하는 프로그램을 작성하세요.
    2) main()의 위치는 ex10_9.main이고 클래스 이름은 AccessControlExample 입니다.
    3) 출력 
       x[0]=100	y[0]=200
       x[1]=115	y[1]=200
       x[2]=115	y[2]=215
       x[3]=100	y[3]=215
       (100,200)
       (115,200)
       (115,215)
       (100,215)
*/
package report_0414;

import ex10_9.geometry.shape.Square1;

public class AccessControlExample {

	public static void main(String[] args) {
		Square1 sq = new Square1(100, 200, 15);
		
		for (int i = 0; i < 4; i++) {
			System.out.print("x[" + i + "]=" + sq.getX(i) + " ");
			System.out.print("y[" + i + "]=" + sq.getY(i));
			System.out.println();
		}

		for (int i = 0; i < 4; i++)
			System.out.println("(" + sq.getX(i) + "," + sq.getY(i) + ")");

	}

}
