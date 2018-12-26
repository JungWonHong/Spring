//직렬화 가능 클래스를 만드는 예 
// - implements java.io.Serializable 없는 클래스-직렬화 안됨
//실행 순서 : ObjectOutputExample2.java -> ObjectInputExample2.java
package ex19_2_Serialization_error;

public class GoodsStock {// 재고 정보 클래스
    String code;       
    int num;           
    GoodsStock(String code, int num) {   
        this.code = code;
        this.num = num;
    }
    void addStock(int num) {  
        this.num += num;              
    }
    int subtractStock(int num) throws Exception {  
        if (this.num < num)
            throw new Exception("재고가 부족합니다.");
        this.num -= num;            
        return num;
    }
}
