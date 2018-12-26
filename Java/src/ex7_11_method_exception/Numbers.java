package ex7_11_method_exception;

//���� �迭�� �հ踦 ���ϴ� Ŭ����
class Numbers {
	int num[];

	Numbers(int num[]) { // ������
		this.num = num; // �Ű������� �̸� �������ָ� ����. ������ �پ��ϰ� ������� �򰥸��⶧��
	}

	int getTotal() { // �迭�� �հ踦 ���ϴ� �޼���
		int total = 0;
		for (int cnt = 0; cnt < num.length; cnt++)
			total += num[cnt];
		return total;
	}

	//�޼ҵ� �ȿ��� �߻��� �ͼ����� �޼ҵ� �ȿ��� ó������ ���ϸ�
	//�޼ҵ带 ȣ���� ������ ��������.
	int getAverage() {
		return getTotal() / num.length;
	}

}
