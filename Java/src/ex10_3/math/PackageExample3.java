//�ٸ� ��Ű��(ex10_3.geometry.polygon)�� �ִ� Rectangle Ŭ���� ����ϱ�
package ex10_3.math;	//��Ű�� ����

public class PackageExample3 {

	public static void main(String[] args) {
		ex10_3.geometry.polygon.Rectangle obj = 
				new ex10_3.geometry.polygon.Rectangle(2, 3); 
		System.out.println("���� = " + obj.width);
		System.out.println("���� = " + obj.height);
		System.out.println("���� = " + obj.getArea());

	}

}
