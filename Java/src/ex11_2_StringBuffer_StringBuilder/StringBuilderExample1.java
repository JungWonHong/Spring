//StringBuffer는 멀티쓰레드에 안전하도록 동기화되어 있습니다.
//멀티쓰레드로 작성된 프로그램이 아닌 경우 StringBuffer의 동기화는 불필요하게
//성능만 떨어뜨리게 되어
//StringBuffer에서 쓰레드의 동기화만 뺀 StringBuilder가 추가되었습니다.
//StringBuilder는 StringBuffer와 똑같은 기능으로 작성되어 있습니다.
package ex11_2_StringBuffer_StringBuilder;

public class StringBuilderExample1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("동해물과 백두산이 마르고 ");

		System.out.println(sb.append("닳도록  보우하사 ")); // 기존 문자열에 추가
		System.out.println(sb.insert(19, "하느님이 하느님이 ")); // index가 19인 곳에 "하느님이 하느님이 "삽입
		System.out.println(sb.delete(24, 28)); // index가 24부터 27까지 문자열 삭제
		System.out.println(sb.deleteCharAt(9)); // index가 9인 곳의 문자 하나 삭제
	}

}
