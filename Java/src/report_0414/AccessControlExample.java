/*   
 * 1) ex10_9.geometry.common.Polygon Ŭ������
      ex10_9.geometry.shape.Square Ŭ������ ����Ͽ� 
      (x,y)-> (100,200) ��ġ��
      ���̰� 15 �� ���簢���� �� �������� ��ǥ�� 
      ����ϴ� ���α׷��� �ۼ��ϼ���.
    2) main()�� ��ġ�� ex10_9.main�̰� Ŭ���� �̸��� AccessControlExample �Դϴ�.
    3) ��� 
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
