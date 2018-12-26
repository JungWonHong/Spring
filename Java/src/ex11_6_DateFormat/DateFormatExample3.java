//SimpleDateFormat 클래스를 사용하여 두 날짜 차이를 구하는 프로그램
//String -> Date 형으로 변환
package ex11_6_DateFormat;

import java.text.ParseException;

import java.text.*;
import java.util.Date;

public class DateFormatExample3 {

	public static void main(String[] args) {
		String start = "2017-03-23";
		String end = "2017-04-18";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {// parse가 예외처리를 해줘야하기 때문에 try문 안에 써줘야한다.
				// String -> Date 형으로 변환
			Date beginDate = dateFormat.parse(start);
			Date endDate = dateFormat.parse(end);

			System.out.println(beginDate);
			System.out.println(endDate.getTime());
			System.out.println(beginDate.getTime());

			long diff = endDate.getTime() - beginDate.getTime();
			long diffDays = diff / (1000 * 60 * 60 * 24);
			// 1일 = 24(시간) * 60(분) * 60(초) * 1000(밀리세컨드)
			System.out.println("날짜 차이 = " + diffDays + "일");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
