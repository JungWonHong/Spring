package ex4_10_incre_dec;

public class IncrDecExample3 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
		int result1 = num1++;
		int result2 = num2--;
		int result3 = ++num3;
		int result4 = --num4;
		
		System.out.println("num1 = " + num1 + "\t result1 = " + result1);
		
		System.out.println("num1 = " + num2 + "\t result1 = " + result2); 
		
		System.out.println("num1 = " + num3 + "\t result1 = " + result3); 
		
		System.out.println("num1 = " + num4 + "\t result1 = " + result4); 
		
		/*
		
		int num1 = 0, num2 = 0, num3 = 0, num4 =  0;
		
		int result1 = num1++;
    의미==>result1 = num1;
        num1 = num1 + 1;
        
        int result2 = num2--;
    의미==>result2 = num2;
        num1 = num1 - 1;
        
        int result3 = ++num3;
    의미==>num3 = num3 + 1;
        result3 = num3;
        
        int result1 = --num4;
    의미==>num4 = num4 - 1;
        result4 = num4;
		
		*/
	}

}
