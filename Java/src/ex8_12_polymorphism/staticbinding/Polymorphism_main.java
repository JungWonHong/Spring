package ex8_12_polymorphism.staticbinding;

public class Polymorphism_main {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("-----Child c = new Child();-----");
		c.parentPrn();
		c.childPrn();

		Parent p;
		p = c;	// Parent p = new Child(); // ������, ��ĳ����
		
		System.out.println("-----Parent p = new Child(); ��ĳ�� ��-----");
		
		//���� ���ε� ���� - ��ü�� Ÿ���� �����Ϸ��� ���� ������ �Ǵ� ������ �����Ǵ� ���� ���ϸ�
		//private, final, static �޼���, �ν��Ͻ� ���� ���� �ش��մϴ�.
		p.parentPrn();	

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
