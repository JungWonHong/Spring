//���� ������ Ŭ���� �����
//1�ܰ� - Cloneable �������̽� ����
//2�ܰ� - clone()�޼ҵ� �������̵��ϱ�
package ex13_8_clone_1;

public class Rectangle implements Cloneable {// Cloneable�������̽��� �����Ǿ� 
											//�ִٴ� ���� Ŭ���� �ۼ��ڰ� ����(clone)�� ����Ѵٴ� �ǹ�
	int width, height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/*
	 * Object Ŭ������ ���ǵ� clone() 
	 * protected native Object clone() throws CloneNotSupportedException 
	 * ==>�������̵��� ���� ������ ����(protected => public : ��Ӱ������ ��
	 */

	public Object clone() { // ��ȯ���� Object�� �Դϴ�.
		try {
			//���� Ŭ������ clone�޼ҵ带 ȣ���ؼ� �� ����� ����
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
