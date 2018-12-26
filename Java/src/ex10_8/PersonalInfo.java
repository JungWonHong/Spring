//private 생성자를 포함하는 클래스의 예
//첫 번째 생성자는 private으로 선언되어 있기 때문에 클래스 외부에서 사용할 수 없다.
//두 번째 생성자와 세 번째 생성자는 같은 클래스 안의 첫 번째 생성자를 호출할 수 있다.
package ex10_8;

public class PersonalInfo {
	String name;
	int age;
	char gender; // 남, 여
	String bloodType; // A, B, AB, O

	private PersonalInfo(String name, int age) { //필수입력사항으로 만들어버릴때 사용.
		this.name = name;
		this.age = age;
	}

	PersonalInfo(String name, int age, char gender) {
		this(name, age); // 매개변수 두개의 생성자 호출
		this.gender = gender;
	}

	PersonalInfo(String name, int age, char gender, String bloodType) {
		this(name, age);
		this.gender = gender;
		this.bloodType = bloodType;
	}
}
