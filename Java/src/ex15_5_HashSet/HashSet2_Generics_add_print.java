package ex15_5_HashSet;
import java.util.*;
public class HashSet2_Generics_add_print {

	public static void main(String[] args) {
		//HashSet 객체 생성
		HashSet<String> set = new HashSet<String>();
		
		//데이터 저장
		set.add("자바");
		set.add("카푸치노");
		set.add("에스프레소");
		set.add("자바");
		System.out.println("저장된 데이터의 수 = " + set.size());
		
		//set 객체가 보관하고 있는 데이터 객체 출력
		System.out.println(set);
		
		//iterator(): set안에 있는 데이터를 모두 가져옵니다.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str);
		}
	}
}
