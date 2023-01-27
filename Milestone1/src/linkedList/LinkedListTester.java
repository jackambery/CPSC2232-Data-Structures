package linkedList;

public class LinkedListTester {

	public static void main(String[] args) {
		init();

	}
	
	public static void init() {
		
		LinkedList list = new LinkedListImpl();
		//addNode with each node
		list.addItem("dog");
		list.addItem("cat");
		list.addItem("frog");
		list.addItem("sheep");
		list.addItem("cow");
		
	}

}
