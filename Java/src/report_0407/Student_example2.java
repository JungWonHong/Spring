package report_0407;

public class Student_example2 {

	public static void main(String[] args) {
		Student[] s = new Student[5];
		s[0] = new Student("강호동", 85, 60, 70);
		s[1] = new Student("이승기", 90, 95, 80);
		s[2] = new Student("유재석", 75, 80, 100);
		s[3] = new Student("하하", 80, 70, 95);
		s[4] = new Student("이광수", 100, 65, 80);
		
		for (int i = 0; i < s.length; i++) {
	         for (int j = 0; j < s.length; j++) {
	            if (s[i].total < s[j].total)
	               s[i].rank++;
	         }
	      }
		
		//순위는 크기가 작은게 높은순위이므로 내림차순 정렬 (선택정렬 사용)
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].rank > s[j].rank) {
					Student temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}

		/*//버블정렬 사용
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = 0; j < s.length - i - 1; j++) {
				if (s[j].rank > s[j + 1].rank) {
					Student temp = s[j];
					s[j] = s[j + 1];
					s[j + 1] = temp;
				}
			}
		}*/
		
		System.out.println("==============   학생별   /  과목별 총점구하기  ==============");
		System.out.println("\t국어\t수학\t영어\t총점\t평균\t등수");
		for (int i = 0; i < s.length; i++)
			System.out.println(s[i].name + "\t" + s[i].kor + "\t" + s[i].math + "\t" + s[i].eng + "\t" + s[i].total
					+ "\t" + s[i].avg + "\t" +s[i].rank);

		System.out.println("=====================================================");

		int total_kor = 0, total_math = 0, total_eng = 0;
		for (int i = 0; i < s.length; i++) {
			total_kor += s[i].kor;
			total_math += s[i].math;
			total_eng += s[i].eng;
		}
		
		System.out.println("총점\t" + total_kor + "\t" + total_math + "\t" + total_eng);
		
	}

}
