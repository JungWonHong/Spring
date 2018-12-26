package ex13_8_clone_참고_deepCopy2;

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
		//인스턴스변수가 Point형의 참조형이어서, 참조하는 객체도 복사해서 c2가 가르키는 공간이 따로 생긴다. 
	}

}
