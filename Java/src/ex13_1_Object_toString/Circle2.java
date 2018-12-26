package ex13_1_Object_toString;

public class Circle2 {
	int radius;	//반지름
	
	Circle2(int radius){
		this.radius = radius;
	}
	
	public String toString(){
		return "반지름은 " + radius + "입니다.";
	}
}
