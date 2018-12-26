//���� �簢�� Ŭ������ �޼ҵ带 �߰��� ���
//���� �߻� : ����ȭ�� �� ����� Ŭ������ ������ȭ�� �� ����� Ŭ������ ������ �ٸ��� ����
package ex19_6_serialVersionUID_no;

public class Rectangle implements java.io.Serializable{
	int width, height;
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	/* ������
	 * 
	 * 1. �Ʒ� getArea �޼ҵ��� �ּ��� �ް� ������ ��쿡�� ���� ����
	 * ObjectOutputExample.java�� ����
	 * ObjectIntputExample.java ����
	 * 
	 * 2. �Ʒ� �޼ҵ��� �ּ��� Ǭ �� - ���� �߻�
	 * 	  ObjectInputExample.java ����
	 * 
	 * 	  ex19_6_serialVersionUID_no.Rectangle;
	 * 	  local class incompatible : //Ŭ������ ȣȯ���� �ʴ´�.
	 *	  //��Ʈ���� ���� �о���� ���� �ȿ� ��ϵǾ� �ִ� ���� ��ȣ
	 *	  stream classdesc serialVersionUID = -3385310283108755664,
	 *    //������ȭ ���α׷��� ����� Ŭ������ ���� ��ȣ
	 *    local calss serialVersionUID = 8970372987272490158
	 *    
	 *    serialVersionUID�� ���� Ŭ�������� �˷��ִ� �ĺ��� ������ �ϸ�
	 *    Serializable �������̽��� ������ Ŭ������ �������ϸ� �ڵ�������
	 *    serialVersionUID ���� �ʵ尡 �߰��˴ϴ�.
	 *    
	 *    �̷� ���� ��ȣ�� �ڹ��� ����ȭ ��Ŀ����� ������ȭ ��Ŀ������ ������ ��
	 *    �ڵ����� �ο��Ǵµ� ����ȭ ���� Ŭ������ ������ �״���̸� ���� ��ȣ�� �ο��ǰ�
	 *    Ŭ������ ������Ұ� �ϳ��� �ٲ�� ������ �ٸ� ���� ��ȣ�� �ο��˴ϴ�.
	 *    
	 *    ������ ��������� Ŭ������ serialVersionUID�� ����Ǿ� ������
	 *    ������ �� �߰� ���� �ʱ� ������ ������ ���� ������ �� �ֽ��ϴ�.
	 */
	
	int getArea(){
		return width * height;
	}
	 
}
