//gc메소드 사용 예
package ex16_2_System_gc;

public class SystemExample {

	public static void main(String[] args) {
		//ResourceUser객체 생성
		ResourceUser obj = new ResourceUser();
		
		//ResourceUser객체 사용
		obj.use();
		
		//ResourceUser객체를 더이상 필요치 않은 상태로 만듭니다.
		obj = null;
		
		//가비지 컬렉터(garbage collector) - JVM안에 필요 없는 객체들을 자동으로 삭제하는 모듈
		System.gc(); //가비지컬렉터가 가급적 빨리 일을 하도록 JVM에게 요청하는 메소드
		//가비지 콜렉터는 객체를 제거하기 전에 finalize() 메소드를 호출합니다.
	}

}
