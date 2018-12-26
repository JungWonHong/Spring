package ex7_06_constructor_call;

public class SubscriberInfo {
	String name, id, password;
	String phoneNo, address;

	//매개 변수 없는 생성자 추가
	//자바컴파일러는 클래스에 선언된 생성자가 하나라도 있으면
	//디폴스 생성자를 추가하지 않습니다.
	SubscriberInfo(){} // 생성자가 정의되어있으면 디폴트생성자도 따로 정의해줘야한다.
	
	SubscriberInfo(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
//		this.name = name;
//		this.id = id;
//		this.password = password;
		this(name, id, password); //위의 세문장을 한문장으로
		//this() : 생성자로 같은 클래스의 다른 생성자를 호출할 때 사용.
		this.phoneNo = phoneNo;
		this.address = address;
//		this(name, id, password); //생성자호출문이 다른 명령문보다 뒤에 오는 것은 잘못.
		//Constructor call must be the first statement in a constructor
	}

	void changePassword(String password) {
		this.password = password;
	}

	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	void setAddress(String address) {
		this.address = address;
	}

}
