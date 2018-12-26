package ex7_15_static_method;
//���� �޼��带 �����ϴ� Ŭ����
public class Accumulator {
	int total = 0;
	static int grandTotal = 0;
	
	void accumulate(int amount){
		total += amount;
		grandTotal += amount;
	}
	
	static int getGrandTotal(){ //���� �޼��� ����
		//total = 5;		   // �����߻�
		//Cannot make a static reference to the non-static field total
		//����Ǵ� ��ҿ� ��������� ������ �ٸ���. 
		//�ν��Ͻ������� new�� ���ؼ� ��ü ������ �޸�(Heap)�� �������� 
		//���������� Ŭ���������� �޸�(MethodArea)�� �����. 
		return grandTotal;
	}
}
