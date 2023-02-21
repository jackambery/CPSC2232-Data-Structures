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

}
