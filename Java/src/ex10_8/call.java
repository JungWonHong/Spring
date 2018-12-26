package ex10_8;

public class call {

	public static void main(String[] args) {
		//PersonalInfo p1 = new PersonalInfo("티파니", 21);
		PersonalInfo p2 = new PersonalInfo("티파니", 21, '여');
		print(p2);
		PersonalInfo p3 = new PersonalInfo("티파니", 21, '여', "A");
		print(p3);
	}

	static void print(PersonalInfo obj) {
		System.out.println("이름 : " + obj.name);
		System.out.println("나이 : " + obj.age);
		System.out.println("성별 : " + obj.gender);
		System.out.println("혈액형 : " + obj.bloodType);
	}
}
