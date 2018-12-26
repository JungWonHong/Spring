package report_0424;

public class MemberInfo {
	private String name;
	private int age;
	private String email;
	private String address;
	
	//getter메서드
	public String getName(){
		return name;
	}
	//setter메서드
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
}
