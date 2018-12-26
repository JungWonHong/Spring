package ex8_15_3_interface.sample3;

public class InstanceManager {
	public static I getInstance(){ 
		//리턴이 B이기 때문에 일반적으로 반환형도 B여야 하지만 다형성으로 인해 I로 해도 B의 반환이 가능하다(업캐팅)
		return new B(); //다른 인스턴스로 바꾸려면 여기만 변경하면 됩니다. C받고싶으면 C로.
		//다형성. 리턴할때 보통 같은 자료형을 써줬지만 다형성을 이용해 반환형이 부모의 자료형이지만 자식을 리턴함.
	}
}
