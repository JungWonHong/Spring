package ex7_01_object;
// ��ǰ ��� Ŭ����
public class GoodsStock2 { // Ŭ������ ������ �����ϴ� Ű���� : class

	GoodsStock2() {} // �⺻������, ������ JVM�� �˾Ƽ� �������

	void addStock(int amount) { // ��� ���Ѵ� ��ɿ� �ش��ϴ� �޼ҵ�
		stockNum += amount;
	}

	int subtractStock(int amount) { // ��� ���� ��ɿ� �ش��ϴ� �޼ҵ�
		if (stockNum < amount)
			return 0;
		stockNum -= amount;
		return stockNum;
	}
	
	String goodsCode; 	  // ��ǰ�ڵ�
	int stockNum; 		  // ������
	//��������� �Ʒ����� �ᵵ �ȴ�.
}
