package ex11_5_Calendar;

public enum Week {
	SUNDAY("�Ͽ���"), MONDAY("������"), TUESDAY("ȭ����"), WEDNESDAY("������"), THURSDAY("�����"), FRIDAY("�ݿ���"), SATURDAY("�����");
	
	final private String name;
	
	private Week(String name){
		this.name = name;
	}
	
	String value(){
		return name;
	}
}
