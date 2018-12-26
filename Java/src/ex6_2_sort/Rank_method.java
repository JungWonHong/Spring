package ex6_2_sort;

public class Rank_method {
	
	static void Rank(int a[][]){
	 for(int i = 0; i < a.length; i++){
		 for(int j = 0; j < a.length; j++){
			 if(a[i][0] < a[j][0]){     
				 a[i][1]++;
			 }//if
		 }//for j
	 }//for i
	}
	
	public static void main(String[] args) {
		
    int a[][] = {{30, 1},   
    		     {20, 1},  
    		     {10, 1},  
    		     {40, 1},  
    		     {50, 1},  
    };
	 
	
	 Rank(a);
	 System.out.print("원본\t등수\n");
	 for(int k = 0; k < a.length; k++)
		 System.out.print(a[k][0] + "\t" + a[k][1] + "\n");
  } 
	
}
