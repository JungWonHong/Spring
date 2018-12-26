//자동 정렬을 해주는 TreeSet을 이용한 로또번호 6개 구하기
package ex15_5_HashSet;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet4 {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();

		while (set.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			set.add(num);
		}

		System.out.println(set);

		// 내림차순을 구하고자 하면 descendingSet()메서드가 필요한데
		// 10라인처럼 upcasting을 하면 사용할 수 없습니다.
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		//저장할 때 이미 정렬하기 때문에 읽어올 때 따로 정렬할 필요가 없습니다.
		
		while (set2.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			set2.add(num);
		}
		
		System.out.println(set2);
		//내림차순 메서드 적용합니다.
		NavigableSet<Integer> desc = set2.descendingSet();
		//NavigableSet은 오름차순으로 된것을 내림차순으로, 내림차순으로 된것을 오름차순으로 할수 있다.
		System.out.println(desc);
		
		NavigableSet<Integer> desc2 = desc.descendingSet();
		System.out.println(desc2);
	}

}
