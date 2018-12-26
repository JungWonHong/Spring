package ex7_01_object;
// 상품 재고 클래스
public class GoodsStock { // 클래스의 선언을 시작하는 키워드 : class
	String goodsCode; 	  // 상품코드
	int stockNum; 		  // 재고수량

	GoodsStock() {} // 기본생성자, 없으면 JVM이 알아서 만들어줌

	void addStock(int amount) { // 재고를 더한다 기능에 해당하는 메소드
		stockNum += amount;
	}

	int subtractStock(int amount) { // 재고를 뺀다 기능에 해당하는 메소드
		if (stockNum < amount)
			return 0;
		stockNum -= amount;
		return stockNum;
	}
}
