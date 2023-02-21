package linkedList;

public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList list = new LinkedListImpl();

		// addNode with each node
		list.addItem("sweet child o mine");
		list.addItem("november rain");
		list.addItem("welcome to the jungle");
		list.addItem("paradise city");
		list.addItem("civil war");
		
		runTests(list);

	}

	public static void runTests(LinkedList list) {
		
		System.out.println("Current list items:");
		list.listItems();
		
		System.out.println("\ndeleting welcome to the jungle...");
		list.deleteItem("welcome to the jungle");
		System.out.println("\nCurrent list items:");
		list.listItems();
		
		System.out.println("\ninserting dont cry before civil war...");
		list.insertBefore("dont cry", "civil war");
		System.out.println("\nCurrent list items:");
		list.listItems();
		
		System.out.println("\ninserting knockin on heavens door after november rain...");
		list.insertAfter("knockin on heavens door", "november rain");
		System.out.println("\nCurrent list items:");
		list.listItems();
		
		System.out.println("item count: " + list.itemCount());
		System.out.println("november rain in list?: " + list.isItemInList("november rain"));
		System.out.println("welcome to the jungle in list?: " + list.isItemInList("welcome to the jungle"));
	}
	
	public void clientTester(LinkedList list) {
		System.out.println("Current Stops: ");
		list.listItems();		
		System.out.println("\nCircle in list?: " + list.isItemInList("Circle"));
		System.out.println("SHU in list?: " + list.isItemInList("SHU"));
		
		System.out.println("\nRemoving Town Center...");
		list.deleteItem("Town Center");
		System.out.println("Current Stops: ");
		list.listItems();
		
		System.out.println("\nAdding Marshalls before Stop and Shop...");
		list.insertBefore("Marshalls", "Stop and Shop");
		System.out.println("Current Stops: ");
		list.listItems();
		
		System.out.println("\nAdding The Seagrape after Marshalls...");
		list.insertAfter("The Seagrape", "Marshalls");
		System.out.println("Current Stops: ");
		list.listItems();
	}

}
