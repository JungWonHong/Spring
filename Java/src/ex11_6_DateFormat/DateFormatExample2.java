//SimpleDateFormat Ŭ������ ����Ͽ� ��¥�� �ð��� �����ϴ� ���α׷�
//SimpleDateFormat Ŭ������ format()�޼ҵ��� �Ű������� Date�� �ʿ�
//Calendar�� getTime() �޼ҵ带 �̿��ؼ�  Date�� ���ϰ� ����
//Calendar -> Date ��
package ex11_6_DateFormat;

import java.text.*;//SimpleDateFormat Ŭ������ ���ϴ� ��Ű��
import java.util.*;

public class DateFormatExample2 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY�� MM�� dd�� aa HH�� mm�� ss��");

		SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY�� M�� d�� a h�� m�� s��");

		SimpleDateFormat dateFormat3 = new SimpleDateFormat("YYYY�� M�� d�� E a h�� m�� s��");
		
		//calendar.getTime() : calendar��ü�� ������ �ִ� ��¥�� �ð��� �Ȱ���
		//Date ��ü�� ���� �����ϴ� �޼����Դϴ�.
		System.out.println(calendar.getTime());
		System.out.println(new Date());
		System.out.println(calendar.getTimeInMillis());
		
		//calendar.getTime()�� �������� Date��
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
		
		String str2 = dateFormat2.format(calendar.getTime());
		System.out.println(str2);
		
		String str3 = dateFormat3.format(calendar.getTime());
		System.out.println(str3);
	}

}
