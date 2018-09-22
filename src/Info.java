
public class Info {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private int age = -1;
	
	public Info(){
		
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getMiddleName(){
		return middleName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName){
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String toString(){
		String value = "First name: " + firstName + "\nMiddle name: " + middleName
						+ "\nLast name: " + lastName + "\nAge: " + age + "\n"; 
		return value;
	}

}
