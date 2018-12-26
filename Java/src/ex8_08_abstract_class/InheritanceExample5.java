package ex8_08_abstract_class;
//인스턴스화 할 수 없다(객체로 만들 수 없다) 에러 발생
public class InheritanceExample5 {

	public static void main(String[] args) {
		Account obj = 
				new Account("111-22-333333", "임꺽정", 0);
				//Cannot instantiate the type Account
	}

}
