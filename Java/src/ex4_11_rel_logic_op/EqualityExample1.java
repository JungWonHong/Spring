package ex4_11_rel_logic_op;

public class EqualityExample1 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 2 + 3;
		
		if(num1 == num2){
			System.out.println("num1�� num2�� ���� �����մϴ�.");
		}
		
		if(num1 != num2){
			System.out.println("num1�� num2�� ���� ���� �ʽ��ϴ�.");
		}
		
		if((num1 != num2) == false){
			System.out.println("�ٸ��ٰ� �ϸ� ������!");
		}
	}

}
