//SimpleDateFormat Ŭ������ ����Ͽ� �� ��¥ ���̸� ���ϴ� ���α׷�
//String -> Date ������ ��ȯ
package ex11_6_DateFormat;

import java.text.ParseException;

import java.text.*;
import java.util.Date;

public class DateFormatExample3 {

	public static void main(String[] args) {
		String start = "2017-03-23";
		String end = "2017-04-18";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {// parse�� ����ó���� ������ϱ� ������ try�� �ȿ� ������Ѵ�.
				// String -> Date ������ ��ȯ
			Date beginDate = dateFormat.parse(start);
			Date endDate = dateFormat.parse(end);

			System.out.println(beginDate);
			System.out.println(endDate.getTime());
			System.out.println(beginDate.getTime());

			long diff = endDate.getTime() - beginDate.getTime();
			long diffDays = diff / (1000 * 60 * 60 * 24);
			// 1�� = 24(�ð�) * 60(��) * 60(��) * 1000(�и�������)
			System.out.println("��¥ ���� = " + diffDays + "��");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
