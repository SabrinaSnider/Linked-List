import java.util.Scanner;

public class Menu {
	//Makes list
	static Node first = null;
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int choice = -1;
				
		while(choice != 10){
			System.out.println("Linked List");
			System.out.println("1. Insert at end");
			System.out.println("2. Insert anywhere");
			System.out.println("3. Print");
			System.out.println("4. Count");
			System.out.println("5. Search by Name");
			System.out.println("6. Delete");
			System.out.println("7. Sort by age");
			System.out.println("8. Edit");
			System.out.println("9. N, P, or E");
			System.out.println("10. Exit");
			
			System.out.print("Choose an option: ");
			choice = scan.nextInt();
			System.out.println();
			
			switch(choice){
				case 1: //Insert end
					Node q = Node.makeNode();
					first = Template.insertEnd(first, q);
					Template.print(first);
					break;
				case 2: //Insert anywhere
					Node q2 = Node.makeNode();
					first = Template.insertAnywhere(first, q2);
					Template.print(first);
					break;
				case 3: //Print
					Template.print(first);
					break;
				case 4: //Count
					System.out.println("Length of list: " + Node.getCount() + "\n");
					break;
				case 5: //Search by name
					Node d = Template.search(first);
					
					if (d != null){
						System.out.println(d.toString());
					}
					break;
				case 6: //Delete
					Node deletion = Template.search(first);
					
					if(deletion == null){
						System.out.println("No deletions made.");
					}else{
						Template.delete(first, deletion);
					}
					Template.print(first);
					break;
				case 7: //Sort by age
					Template.sort(first);
					Template.print(first);
					break;
				case 8: //Edit
					Node editNode = Template.search(first);
					Template.edit(editNode);
					Template.print(first);
					break;
				case 9: //N, P, or E
					Template.NPE(first);
					break;
				case 10: //Exit
					break;
				default:
					System.out.println("Invalid number entered. Please choose one of the options (1-9).\n");
					break;
			}
		}
	}
}
