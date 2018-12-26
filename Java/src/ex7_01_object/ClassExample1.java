package ex7_01_object;

public class ClassExample1 {

	public static void main(String[] args) {
		GoodsStock obj;				//변수 선언
		obj = new GoodsStock();		//객체 생성
		obj.goodsCode = "52135";	//필드에 값을 대입
		obj.stockNum = 200;			//필드에 값을 대입

		System.out.println("상품코드:" + obj.goodsCode); //필드 값 사용
		System.out.println("재고수량:" + obj.stockNum);

		obj.addStock(1000);	//메서드 호출

		System.out.println("상품코드:" + obj.goodsCode);
		System.out.println("재고수량:" + obj.stockNum);
	}

}
