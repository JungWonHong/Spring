//오버로드된 메소드를 호출하는 프로그램
package ex7_12_overload_call;
class MethodExample6 {
    public static void main(String args[]) {
        PhysicalInfo obj;                        
        obj = new PhysicalInfo("해리", 10, 132.0f, 35.0f);
        printPhysicalInfo(obj);
        
        obj.update(11, 145.0f, 45.0f);  
        printPhysicalInfo(obj);
        
        obj.update(12, 157.0f);        
        printPhysicalInfo(obj);
        
        obj.update(13);                
        printPhysicalInfo(obj);
   }
   static void printPhysicalInfo(PhysicalInfo obj) {  // 객체의 필드 값을 출력하는 메서드
        System.out.println("이름:" + obj.name);  
        System.out.println("나이:" + obj.age);   
        System.out.println("키:" + obj.height);   
        System.out.println("몸무게:" + obj.weight);   
        System.out.println();                         // 줄 바꿈 문자 출력
    }
}
