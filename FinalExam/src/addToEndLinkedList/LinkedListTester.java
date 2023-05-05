package addToEndLinkedList;

public class LinkedListTester {

	public static void main(String[] args) {
		// create implementation, then
		LinkedList theList = new LinkedListImpl();
		runTests(theList);
	}

	/**
	 * simply exercises all methods
	 * @param list
	 */
	public static void runTests(LinkedList list) {
		 
		list.addItem("two things that dont last");
		list.addItem("dogs that chase cars");
		list.addItem("golf pros that putt for pars");
		
		list.addToEnd(" whow");
		
		list.listItems();
	}

	
	
}

/**
   	Anticipated result:
 
	
	two things that dont last
	dogs that chase cars
	golf pros that putt for pars
 	 whow

*/