package report_0407;

public class Student {
	String name; //�л��̸�
	int kor;	 //��������
	int eng;	 //��������
	int math;	 //��������
	//�ʵ��߰�
	int total;   //����
	int rank = 1;    //���
	float avg;   //���
	
	Student(String name, int kor, int math, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		//this.rank = 1;
		this.total = getTotal();
		this.avg = getAverage();
	}
	
	int getTotal(){ // ���� ����
		return kor+eng+math;
	}
	
	float getAverage() { // ��� ����
		float average = getTotal() / 3.0f;
		int result = (int) (average * 10 + 0.5);
		return (float)result / 10;
	}
	
}
