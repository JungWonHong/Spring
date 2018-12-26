package ex6_3_method;

public class Method_overloading {
	static int max(int n1, int n2) {
		return n1 < n2 ? n1 : n2;
	}

	static int max(int n1, int n2, int n3) {
		int max = n1;
		if (max < n2)
			max = n2;
		if (max < n3)
			max = n3;
		return max;
	}

	static int max(int n1, int n2, int n3, int n4) {
		int max = n1;
		if (max < n2)
			max = n2;
		if (max < n3)
			max = n3;
		if (max < n4)
			max = n4;
		return max;
	}

/*	//반환형은 메서드 오버로딩 조건과 무관해서 위의 메서드와 동일하게 취급해서 에러 발생
	static String max(int n1, int n2, int n3, int n4) {
		int max = n1;
		if (max < n2)
			max = n2;
		if (max < n3)
			max = n3;
		if (max < n4)
			max = n4;
		return "반환형 String : " + max;
	}
*/	
	public static void main(String[] args) {
		System.out.println("max(10,20) = " + max(10, 20));
		System.out.println("max(10,20, 30) = " + max(10, 20, 30));
		System.out.println("max(10,20, 30,40) = " + max(10, 20, 30, 40));

	}

}
