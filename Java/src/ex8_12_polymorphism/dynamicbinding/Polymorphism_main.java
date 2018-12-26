package ex8_12_polymorphism.dynamicbinding;

public class Polymorphism_main {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("-----Child c = new Child();-----");
		c.parentPrn();
		c.childPrn();

		Parent p;
		p = c;	// Parent p = new Child(); // ������, ��ĳ����
		
		System.out.println("-----Parent p = new Child(); ��ĳ�� ��-----");
		
		//���� ���ε� ���� - �������̵��� �޼��带 ȣ���� ��� ������ �ÿ��� ���� ����������
		//Ÿ�� ������ üũ�ϰ� ���α׷� ���� �߿� ��ü�� Ÿ���� �����Ǿ� ȣ��� �������̵� �޼��尡
		//�θ� Ŭ������ �޼������� �ڽ�Ŭ������ �޼������� �Ǵ��Ͽ� �����ϰ� �˴ϴ�.
		p.parentPrn();	
		//�θ� Parent�� parentPrn()�� �����ϱ� ������ ������ ������ �����ϴ�.
		//parentPrn()�� �������̵��� �޼����̰� ��ü�� Ÿ���� Child�̱� ������
		//Child�� parentPrn()�� �����ϰ� �˴ϴ�.
		
		//p.childPrn();	//The method childPrn() is undefined for the type Parent
		//������ ������ �߻��ϰ� �˴ϴ�.
		//���� ������ �ڷ��� ParentŬ�������� childPrn()�޼ҵ尡 ���� ����
		
		//������ ���� �� �ʵ�� �θ��� �ʵ尪�� ���
		//���� ���ε� ���� - ��ü�� Ÿ���� �����Ϸ��� ���� ������ �Ǵ� ������ �����Ǵ� ���� ���ϸ�
		//private, final, static �޼���, �ν��Ͻ� ���� ���� �ش��մϴ�.
		//�θ� Ŭ������ �ʵ忡 �ּ��� �޸� ���� �߻�
		System.out.println("p.message = " + p.message);
	}

}
