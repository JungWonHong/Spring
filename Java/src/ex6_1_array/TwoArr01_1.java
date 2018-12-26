package ex6_1_array;

public class TwoArr01_1 {

	public static void main(String[] args) {
		String name[] = { "강호동", "이승기", "유재석", "하하", "이광수" };
		String sub_name[] = { "국어", "수학", "영어" };

		int[][] score = { { 10, 90, 70 },	//0행(1번학생)
						  { 90, 80, 65 },	//1행(2번학생)
						  { 55, 60, 85 },	//2행(3번학생) 
						  { 90, 75, 95 },	//3행(4번학생) 
						  { 60, 30, 80 } 	//4행(5번학생)
						};

		int[] subject = new int[3]; // 과목총점 저장
		int[] student = new int[5]; // 학생의 총점 저장
			//	subject[0] = 0, student[0] = 0; 
			//  subject와 student의 초기값 0으로 설정됨
		
		System.out.println("===각 과목별 총점 구하기===");
		//국어 과목 총점
		for(int i = 0;i<score.length;i++){
			subject[0] += score[i][0];
		}
	}

}
