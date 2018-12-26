package ex13_7;

public class ObjectExample2 {

	public static void main(String[] args) {
		Circle2 obj1 = new Circle2(5);
		Circle2 obj2 = new Circle2(5);
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		if(obj1.equals(obj2))
			System.out.println("obj1.equals(obj2) : 같음");
		else
			System.out.println("obj1.equals(obj2) : 다름");
		
		if(obj1==obj2)
			System.out.println("obj1==obj2 : 같음");
		else
			System.out.println("obj1==obj2 : 다름");

	}

}
