import java.util.Scanner;

public class Template {
	
	public static Node insertEnd(Node start, Node insert){
		if(start == null){ //If new linked list, make the first node q
			start = insert;	
		}else{ //If linked list already made, increment down until last node is reached
			Node pointer = start;
			while(pointer.getNext() != null){
				pointer = pointer.getNext();
			}
			pointer.setNext(insert);
			insert.setPrevious(pointer);
		}
		System.out.println();
		return start;
	}
	
	public static Node insertAnywhere(Node start, Node insert){ //Insert before any node
		if(Node.getCount() == 1){ //If insert is the first node, set first = insert
			return insert;
		}else if(Node.getCount() > 1){ //If the new node isn't the only one in the list
			System.out.println("Choose where to add the new person before.");
			Node next = Template.search(start); //New node goes before next
			
			if(start == next){ //if next is the first node then inserting at beginning
				insert.setNext(next);
				next.setPrevious(insert);
				start = insert;
			}else{
				Node previous = start; //pointer is the node before next
				Boolean found = false;
				while(previous != null && found != true){
					if(previous.getNext().equals(next)){
						found = true;
					}else{
						previous = previous.getNext();
					}
				}
				insert.setNext(next);
				insert.setPrevious(previous);
				previous.setNext(insert);
				next.setPrevious(insert);
			}
			
		}
		return start;
	}
	
	public static void print(Node pointer){ //Pass in first
		while(pointer != null){
			System.out.println(pointer.toString());
			pointer = pointer.getNext();
		}
		System.out.println();
	}
	
	public static Node search(Node start){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first name of the person to search for: \n");
		String name = scan.next();
		
		Node pointer = start;
		
		while(pointer != null){;
			//check for null first to avoid null pointer in the line below
			if(pointer.getInfo().getFirstName() != null && pointer.getInfo().getFirstName().equals(name)){
				return pointer;
			}
			pointer = pointer.getNext();
		}
		
		System.out.println("Person not found.");
		return null;
	}
	
	public static void delete(Node first, Node deletion){
		Node pointer = first;
		
		if(pointer.equals(deletion)){ //first = node to be deleted
			Menu.first = pointer.getNext(); //Set first to the second node
			pointer.getNext().setPrevious(null);
			Node.setCount(Node.getCount() - 1);
			System.out.println("Deleted.");
		}else if(deletion != null){ //If a node after the first node is to be deleted
			while(!pointer.getNext().equals(deletion)){ //While the next node isn't the deletion node
				pointer = pointer.getNext();
			}
			//By here, pointer.getNext() is the deletion node
			if(pointer.getNext().getNext() != null){
				pointer.getNext().getNext().setPrevious(pointer);
			}
			pointer.setNext(pointer.getNext().getNext());
			Node.setCount(Node.getCount() - 1);
			System.out.println("Deleted.");
		}else{ //if search returns null
			System.out.println("Person not found.");
		}
	}
	
	public static void sort(Node start){ //sorting by age from low to high
		//Instead of moving nodes, move info objects
		if(Node.getCount() > 1){ //if no items in list or only 1 item in list, no change
			for(int i = 0; i < Node.getCount(); i++){
				for(int j = 0; j< Node.getCount() - i; j++){
					Node current = start;
					Node next = start.getNext();
					
					for(int counter = 0; counter < j; counter++){ //Problem is ages are equal or with the last node
						if(current.getInfo().getAge() > next.getInfo().getAge()){
							
							Info temp = current.getInfo();
							current.setInfo(next.getInfo());
							next.setInfo(temp);
						}
						current = current.getNext();
						next = current.getNext();
					}
					
				}
			}
			
		}
	}
	
	public static void edit(Node editNode){
		Scanner scan = new Scanner(System.in);
		System.out.print("Which attribute do you want to change? Enter first name, middle name, last name, or age.");
		String choice = scan.nextLine().toLowerCase();
		
		if(choice.equals("first name")){
			System.out.print("Enter the new first name: ");
			String change = scan.next();
			editNode.getInfo().setFirstName(change);
		}else if(choice.equals("middle name")){
			System.out.print("Enter the new middle name: ");
			String change = scan.next();
			editNode.getInfo().setMiddleName(change);
		}else if(choice.equals("last name")){
			System.out.print("Enter the new last name: ");
			String change = scan.next();
			editNode.getInfo().setLastName(change);
		}else if(choice.equals("age")){
			System.out.print("Enter the new age: ");
			int change = scan.nextInt();
			editNode.getInfo().setAge(change);
		}else{
			System.out.println("Not one of the choices.\n");
			return;
		}
		
		System.out.println("Change made.\n");
	}
	
	public static void NPE(Node first){
		Scanner scan = new Scanner(System.in);
		String choice = "";
		
		Node iterator = first;
		System.out.println(iterator.toString());
		
		while(!choice.toLowerCase().equals("e")){
			System.out.print("N, P, or E? ");
			choice = scan.nextLine();
			if(choice.toLowerCase().equals("n")){
				if(iterator.getNext() != null){
					iterator = iterator.getNext();
					System.out.print("\n" + iterator.toString());
				}else{
					System.out.println("\nEnd of list- cannot get next.");
				}
			}else if(choice.toLowerCase().equals("p")){
				if(iterator.getPrevious() != null){
					iterator = iterator.getPrevious();
					System.out.print("\n" + iterator.toString());
				}else{
					System.out.println("\nBeginning of list- cannot get previous.");
				}
			}else if(choice.toLowerCase().equals("e")){
				System.out.println();
				return;
			}else{
				System.out.println("Not a valid option");
				System.out.print("\n" + iterator.toString());
			}
		}
	}
	
}
