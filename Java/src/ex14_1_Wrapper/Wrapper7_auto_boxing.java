//�⺻�� �� -> Wrapper ��ü���� �ڵ�(����) Boxing
package ex14_1_Wrapper;

public class Wrapper7_auto_boxing {

	public static void main(String[] args) {
		printDouble(new Double(123.45));
		
		//doubleŸ���� ���� ������ DoubleŸ�� ���ڸ� �޴� �޼ҵ带 ȣ���Ѵ�.
		printDouble(123.45);

	}
	
	//�ڵ�(����) Boxing
	static void printDouble(Double obj){
		System.out.println("obj="+obj);
		System.out.println("obj.toString()="+obj.toString());
	}

}
