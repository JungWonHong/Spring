//�����ε�� �޼ҵ带 ȣ���ϴ� ���α׷�
package ex7_12_overload_call;
class MethodExample6 {
    public static void main(String args[]) {
        PhysicalInfo obj;                        
        obj = new PhysicalInfo("�ظ�", 10, 132.0f, 35.0f);
        printPhysicalInfo(obj);
        
        obj.update(11, 145.0f, 45.0f);  
        printPhysicalInfo(obj);
        
        obj.update(12, 157.0f);        
        printPhysicalInfo(obj);
        
        obj.update(13);                
        printPhysicalInfo(obj);
   }
   static void printPhysicalInfo(PhysicalInfo obj) {  // ��ü�� �ʵ� ���� ����ϴ� �޼���
        System.out.println("�̸�:" + obj.name);  
        System.out.println("����:" + obj.age);   
        System.out.println("Ű:" + obj.height);   
        System.out.println("������:" + obj.weight);   
        System.out.println();                         // �� �ٲ� ���� ���
    }
}