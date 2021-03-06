package ex15_5_HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet2_Generics_lotto {

	public static void main(String[] args) {
		// HashSet 객체 생성
		HashSet<Integer> set = new HashSet<Integer>();

		// HashSet은 중복을 허용하지 않기 때문에 중복 체크 따로 안해줘도된다.
		while (set.size() < 6) {
			set.add((int) (Math.random() * 45 + 1));
		}

		// set 객체가 보관하고 있는 데이터 객체 출력
		System.out.println(set);

		/*int[] sortNum = sort(set);
		for (int i = 0; i < sortNum.length; i++)
			System.out.print(sortNum[i] + "\t");*/
	}

	/*static int[] sort(HashSet<Integer> set) {
		Iterator<Integer> iterator = set.iterator();
		int[] data = new int[set.size()];
		int k = 0;
		while (iterator.hasNext()) {
			data[k] = iterator.next();
			k++;
		}

		int imsi;
		for (int i = 0; i < set.size() - 1; i++) {
			for (int j = i + 1; j < set.size(); j++) {
				if (data[i] > data[j]) {
					imsi = data[i];
					data[i] = data[j];
					data[j] = imsi;
				}
			}
		}

		return data;
	}*/

}
