//오버로드된 메소드를 포함하는 클래스
package ex7_12_overload_call;
class PhysicalInfo {
    String name;   
    int age; 
    float height, weight;
    PhysicalInfo(String name, int age, float height, 
                 float weight) { 
        this.name = name; 
        this.age = age; 
        this.height = height; 
        this.weight = weight; 
    }
    void update(int age)  {  
        this.age = age; 
    }
    void update(int age, float height)  {  
        this.age = age; 
        this.height = height; 
    }
    void update(int age, float height, float weight)  {  
        this.age = age; 
        this.height = height; 
        this.weight = weight; 
    }
}