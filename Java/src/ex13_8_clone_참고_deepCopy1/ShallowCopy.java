package ex13_8_clone_참고_deepCopy1;

public class ShallowCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = c1.clone();
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		
		c1.p.x = 9;
		c1.p.y = 9;
		
		System.out.println("===== c1의 변경 후 ======");
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		//c1과 c2가 같은 공간을 가르키고 있기 때문에 c1이 변하면  c2도 같이 변한다.
	}

}
