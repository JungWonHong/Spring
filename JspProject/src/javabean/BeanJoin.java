package javabean;

public class BeanJoin {
	private String id, pass, name, email;
	private int sex, age;
	
	public String getId(){
		return id;
	}
		
	public void setId(String id){
		this.id = id;
	}
	
	public String getPass(){
		return pass;
	}
		
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public String getName(){
		return name;
	}
		
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
		
	public void setEmail(String email){
		this.email = email;
	}
	
	public int getSex(){
		return sex;
	}
	
	public void setSex(int sex){
		this.sex = sex;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
}
