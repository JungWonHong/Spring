//toString �޼ҵ� �������̵�
package ex13_2;

public class GoodsStock {
	String goodsCode; // ��ǰ�ڵ�
	int stockNum; // �������

	GoodsStock(String goodsCode, int stockNum) {
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}

	public String toString() {
		String str = "��ǰ�ڵ�:" + goodsCode + " �������:" + stockNum;
		return str;
	}
}