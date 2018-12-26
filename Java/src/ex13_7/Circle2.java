package ex13_7;

public class Circle2 {
	int radius; // 반지름

	Circle2(int radius) {
		this.radius = radius;
	}

	//obj가 Object타입이므로 radius를 참조하기 위해서 Circle2타입으로 형변환이 필요
	public boolean equals(Object obj) {
		//obj를 Circle2로 형변환 가능한지 체크
		if (obj != null && obj instanceof Circle2){
			return radius == ((Circle2) obj).radius; //radius값이 같으면 true 다르면 false값을 리턴
			//Circle2 circle = (Circle2)obj;
			//return radius == circle.radius;
		}
		else
			return false;
	}
}
