package report_0413;

import report_0413.Lendable.State; //����Ʈ�����ָ� Lendable.State.STATE_NORMAL �̷��Խ����.

class InterfaceExample {
    public static void main(String args[]) {
        SeparateVolume obj = 
        		new SeparateVolume("863��", "����", "��������");
        printState(obj);
        obj.checkOut("�̼���", "20161012");
        printState(obj);
    }
    
    static void printState(SeparateVolume  obj) {
    	//�������̽� Lendable�� �������� ���� Ŭ���������� ����
    	//�������̽�.�ʵ�
        if (obj.state == State.STATE_NORMAL) { 
            System.out.println("------------------");
            System.out.println("�������: " + State.STATE_NORMAL.value());
            System.out.println("------------------");
        }
        
        if (obj.state == State.STATE_BORROWED) {
            System.out.println("------------------");
            System.out.println("�������: " + State.STATE_BORROWED.value());
            System.out.println("������: " + obj.borrower);
            System.out.println("������: " + obj.checkOutDate);
            System.out.println("------------------");
        }
    }
}
