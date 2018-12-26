//printStackTrace메소드의 사용 예(getMessage()와는 다르게 에러경로까지 나옴)
//예외 발생 당시의 호출 스택에 있엇던 메서드의 정보와 예외 메시지를 화면에 출력합니다.
package ex12_1_Exception;

public class ExceptionExample7 {

	public static void main(String[] args) {
		try {
			int arr[] = new int[0];
			System.out.println("합계" + getTotal(arr));
			System.out.println("평균" + getAverage(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static double getAverage(int arr[]) throws Exception {
		if (arr.length == 0)
			throw new Exception("getAverage() : 비어 있는 배열입니다.");
		// Exception e = new Exception("getAverage() : 비어 있는 배열입니다.");
		// throw e;
		// 19라인의 문장을 두 줄로 사용할 수 있습니다.
		return getTotal(arr) / arr.length;
	}

	static int getTotal(int arr[]) throws Exception {
		if (arr.length == 0)
			throw new Exception("getTotal() : 비어 있는 배열입니다.");
		int total = 0;
		for (int num : arr)
			total += num;
		return total;
	}
}
