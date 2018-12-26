package javabean;
/* 
 * 	자바빈(JavaBean)은 데이터를 표현하는 목적으로 하는 자바빈 규약에  따르는
	자바 클래스 입니다.
 *	예를 들어 회원 정보, 게시판 글 등의 정보를 출력할 때 정보를 저장하고 있는
 	자바빈 객체를 사용하게 됩니다.
 *	다음은 자바빈의 규약입니다.
  1. 필드 마다 별도의 get/set 메서드가 존재해야 한다.
  2. get 메서드는 파라미터가 존재하지 않아야 한다.
  3. set 메서드는 반드시 하나 이상의 파라미터가 존재해야 한다.
  4. 빈즈 컴포넌트의 속성은 반드시 읽기 또는 쓰기가 가능해야 한다.
  	  단, 읽기 전용인 경우 get 또는 is 메서드만 정의할 수 있다.
  5. 생성자는 파라미터가 존재하지 않아야 한다.
  6. 필드의 접근 제어자는 private이고 각 set/get 메서드의 접근 제어자는
  	 public으로 정의되어야 하며 클래스의 접근 제어자는 public으로 정의한다.
  
 *	자바빈 클래스는 데이터를 저장하는 필드, 데이터를 읽어올 때 사용되는 메서드,
 	값을 저장할 때 사용되는 메서드로 구성됩니다.
 	프로퍼티(property)는 자바빈에 저장되어 있는 값을 나타내며 메서드 이름을
 	사용해서 프로퍼티(property)의 이름을 결정하게 됩니다.
 	
 	예를들어 프로퍼티의 이름이 name이고 값의 타입이 int인 경우
 	프로퍼티와 관련된 메서드의 이름은 다음과 같이 결정됩니다.
 	 public void setName(int value);
 	 public int getName();
 	프로퍼티의 타입이 boolean인 경우 get대신 is를 붙일 수 있습니다.
 	
 	즉, 프로퍼티의 값을 설정하는 메서드의 경우 프로퍼티의 이름 중 첫 글자를 대문자로
 	변환한 문자열 앞에 set을 붙이고
 	프로퍼티의 값을 읽어오는 메서드의 경우 프로퍼티의 이름 중 첫 글자를
 	대문자로 변환한 문자열 앞에 get을 붙입니다.
 	프로퍼티의 이름과 필드의 이름은 같지 않아도 됩니다.
 	
 	예를 들어 name 프로퍼티의 값을 실제로 저장하는 필드를 _name인 경우
 	 private String _name;
 	 
 	 public String getName(){
 	 	return _name;
 	 }
 	 
 	 public void setName(String name){
 	 	_name = name;
 	 }
*/

public class BeanTest {
	//값을 저장하는 필드
	//private String name = "honggildong";
	private String name = "홍길동";
	
	/*
	//기본 생성자
	public BeanTest(){}
	*/
	
	//필드의 값을 읽어오는 메서드
	public String getName(){
		return name;
	}
	
	//필드의 값을 저장하는 메서드
	public void setName(String name){
		this.name = name;
	}
}
