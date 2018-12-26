package ex7_11_method_exception;

//정수 배열의 합계를 구하는 클래스
class Numbers {
	int num[];

	Numbers(int num[]) { // 생성자
		this.num = num; // 매개변수도 이름 같게해주면 편리함. 변수가 다양하게 많을경우 헷갈리기때문
	}

	int getTotal() { // 배열의 합계를 구하는 메서드
		int total = 0;
		for (int cnt = 0; cnt < num.length; cnt++)
			total += num[cnt];
		return total;
	}

	//메소드 안에서 발생한 익셉션이 메소드 안에서 처리되지 못하면
	//메소드를 호출한 쪽으로 던져진다.
	int getAverage() {
		return getTotal() / num.length;
	}

}
