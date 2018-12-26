package ex11_6_DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample4 {

	public static void main(String[] args) {
		//String -> Date 형으로 변환
		String from = "2016-10-18 10:10:10";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date changeDate = transFormat.parse(from);
			System.out.println(changeDate);
		} catch (ParseException e){
			e.printStackTrace();
		}
		
		//Date -> String 형 변환하기
		Date from2 = new Date();
		SimpleDateFormat transFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String to = transFormat2.format(from2);
		System.out.println(to);

	}

}
