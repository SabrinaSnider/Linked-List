import java.util.Scanner;

public class Node {
	
	Info info = new Info();
	Node next = null;
	Node previous = null;
	private static int count = 0;
	
	public Node(){
		count++;
	}
	
	public Node(String fname, String mname, String lname, int age){
		getInfo().setFirstName(fname);
		getInfo().setMiddleName(mname);
		getInfo().setLastName(lname);
		getInfo().setAge(age);
		
		count++;
	}
	
	public static Node makeNode(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is the first name? ");
		String fname = scan.next();
		System.out.println("What is the middle name? ");
		String mname = scan.next();
		System.out.println("What is the last name? ");
		String lname = scan.next();
		System.out.println("What is the age? ");
		int age = scan.nextInt();
		
		Node newNode = new Node(fname, mname, lname, age);
		return newNode;
	}
	
	public Info getInfo(){
		return info;
	}
	
	public void setInfo(Info info){
		this.info = info;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getPrevious(){
		return previous;
	}
	
	public void setPrevious(Node previous){
		this.previous = previous;
	}
	
	public static int getCount(){
		return count;
	}
	
	public static void setCount(int newCount){
		count = newCount;
	}
	
	public String toString(){
		return getInfo().toString();
	}
	
}
