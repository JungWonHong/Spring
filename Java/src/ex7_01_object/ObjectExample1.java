package ex7_01_object;

public class ObjectExample1 {

	public static void main(String[] args) {
		
		StringBuffer obj; 					// ��������
		obj = new StringBuffer("Hey, Java");// ��ü����
		obj.deleteCharAt(1); // Hy, Java
		obj.deleteCharAt(1); // H,Java
		obj.insert(1, 'i');  // Hi, Java
		System.out.println(obj); // StringBuffer ��ü�� �Ѱ��� �� �ֽ��ϴ�.

	}

}
