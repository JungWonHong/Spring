package ex7_17_static_init;
//HundredNumbers Ŭ������ �̿��ϴ� ���α׷�
//Ŭ���� �ʱ�ȭ ������ �ν��Ͻ� ���� ��� ��
//13������ ���� ���� ���� ��� ���̸� Ȯ���� ������.
public class StaticInitializerExample1 {
	public static void main(String[] args) {
		System.out.println("main �������");
		
		//�迭�� �ִ� �׸�� �� 3���� �׸��� �����ͼ� �� ���� ����մϴ�.
		System.out.println(HundredNumbers.arr[35]); //Ŭ���� �ε� 
		System.out.println(HundredNumbers.arr[27]);
		System.out.println(HundredNumbers.arr[63]);
		HundredNumbers h = new HundredNumbers();	//��ü ����, �ν��Ͻ�ȭ.
	}

}