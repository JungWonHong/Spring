package report_0406;

public class Student_example {

	public static void main(String[] args) {

		Student[] s = new Student[5];
		s[0] = new Student("��ȣ��", 85, 60, 70);
		s[1] = new Student("�̽±�", 90, 95, 80);
		s[2] = new Student("���缮", 75, 80, 100);
		s[3] = new Student("����", 80, 70, 95);
		s[4] = new Student("�̱���", 100, 65, 80);

		System.out.println("==========   �л���   /  ���� �������ϱ�  ==========");
		System.out.println("\t����\t����\t����\t����\t���");
		for (int i = 0; i < 5; i++)
			System.out.println(s[i].name + "\t" + s[i].kor + "\t" + s[i].math + "\t" + s[i].eng + "\t" + s[i].getTotal()
					+ "\t" + s[i].getAverage());

		System.out.println("=============================================");

		int total_kor = 0, total_math = 0, total_eng = 0;
		for (int i = 0; i < s.length; i++) {
			total_kor += s[i].kor;
			total_math += s[i].math;
			total_eng += s[i].eng;
		}
		System.out.println("����\t" + total_kor + "\t" + total_math + "\t" + total_eng);
	}

}
