package ex7_10_in_method_call;

//정수 배열의 합계를 구하는 클래스
class Numbers2 {
	int num[];

	Numbers2(int num[]) { // 생성자
		this.num = num; // 매개변수도 이름 같게해주면 편리함. 변수가 다양하게 많을경우 헷갈리기때문
	}

	int getTotal() { // 배열의 합계를 구하는 메서드
		int total = 0;
		for (int cnt = 0; cnt < num.length; cnt++)
			total += num[cnt];
		return total;
	}

	int getAverage() {
		return this.getTotal() / num.length;
	}

}
