package ex7_15_static_method;
//정적 메서드를 포함하는 클래스
public class Accumulator {
	int total = 0;
	static int grandTotal = 0;
	
	void accumulate(int amount){
		total += amount;
		grandTotal += amount;
	}
	
	static int getGrandTotal(){ //정적 메서드 선언
		//total = 5;		   // 에러발생
		//Cannot make a static reference to the non-static field total
		//저장되는 장소와 만들어지는 시점이 다르다. 
		//인스턴스변수는 new를 통해서 객체 생성시 메모리(Heap)에 생기지만 
		//정적변수는 클래스생성시 메모리(MethodArea)에 생긴다. 
		return grandTotal;
	}
}
