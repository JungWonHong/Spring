package ex7_10_in_method_call;

//���� �迭�� �հ踦 ���ϴ� Ŭ����
class Numbers1 {
	int num[];

	Numbers1(int num[]) { // ������
		this.num = num; //�Ű������� �̸� �������ָ� ����. ������ �پ��ϰ� ������� �򰥸��⶧��
	}

	int getTotal() { // �迭�� �հ踦 ���ϴ� �޼���
		int total = 0;
		for (int cnt = 0; cnt < num.length; cnt++)
			total += num[cnt];
		return total;
	}

}
