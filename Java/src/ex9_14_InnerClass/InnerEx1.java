package ex9_14_InnerClass;

public class InnerEx1 {
	//�ν��Ͻ� Ŭ����(instance class)
	class InstanceInner {
		int iv = 100;
		//static int cv = 100; //����! static������ ������ �� �����ϴ�.
		final static int CONST = 100; // final static�� ����̹Ƿ� ���
	}
	
	//static class
	static class StaticInner{
		int iv = 200;
		static int cv = 200; //staticŬ������ static����� ������ �� �ֽ��ϴ�.
	}
	
	void myMethod(){
		//���� Ŭ����(local class)
		class LocalInner{
			int iv = 300;
			//static int cv = 300;	//����! static������ ������ �� �����ϴ�.
			final static int CONST = 300; // final static�� ����̹Ƿ� ���
		}
	}
	
	public static void main(String args[]){
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
