package ex3_2_variable;

public class variable1 {

	public static void main(String[] args) {
		
		//������ ����
		byte b = 10;     //1����Ʈ(���� ������ ���� �����ϱ⿡ �����մϴ�)
		short s = 100;   //2����Ʈ
		int i = 1000;    //4����Ʈ
		long l = 10000L; //8����Ʈ(l �Ǵ� L�� ���� �ڿ� ���Դϴ�)
		
		System.out.println("b=" + b);
		System.out.println("s=" + s);
		System.out.println("i=" + i + " l=" + l);
		
		//�Ǽ��� ����
		float ft = 3.14f;   //f �� F�� ���� �ڿ� ���Դϴ�
		double d = 42.195d; //d �� D�� ���� �ڿ� ���̰ų� ������ �� �ֽ��ϴ�
		System.out.println("f=" + ft + " d=" + d);
		
		//������ ����
		char c1 = 'A'; // 2byte �̱� ������ �����ڵ� ��밡��
		char c2 = '@';
		char c3 = 'ȫ';
		System.out.println("c1=" + c1 + " c2=" + c2 + " c3=" + c3);
		
		//char cerror='AB'; //2byte �� ���� �Է��ϸ� ����
		
		//������ ����
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1�� ���� " + b1);
		System.out.println("b2�� ������ " + b2);

	}

}