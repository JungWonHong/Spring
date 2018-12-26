package report_0411;

public class PhoneExample {

	public static void main(String[] args) {
		IFunction[] arr = new IFunction[3];
		arr[0] = new APhone();
		arr[1] = new BPhone();
		arr[2] = new CPhone();
		
		printSpec(arr);
	}
	
	static void printSpec(IFunction[] arr){
		for(int i = 0;i<arr.length;i++){
			System.out.println("======" + arr[i].getClass().getSimpleName() + "======");
			//System.out.println("======" + arr[i].getClass().getName() + "======");
			arr[i].callSenderReceive();
			arr[i].canLte();
			arr[i].tvRemoteController();
		}
	}

}
