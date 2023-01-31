package linkedList;

public class LinkedListImpl implements LinkedList {

	private int size = 0;
	private Node head = null;
	
	@Override
	public Boolean isItemInList(String thisItem) {
		
		// True if it is, false if it is not
		return null;
	}

	@Override
	public Boolean addItem(String data) {
		/*
		 * if head == null, nothing is in list, create new node and set it to head
		 * 
		 */
		// true if added, false if it was already there, or an error
		
		if (head == null) {
			Node head = new Node(data);
			this.head = head;
			size++;
			return true;
		}
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node newNode = new Node(data);
			current.next = newNode;
			size++;
			return true;
		}
		//need to check if node is already in list
	}

	@Override
	public Integer itemCount() {
		return size;
	}

	//did this in class 1/31
	@Override
	public void listItems() {
		
		Node temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
				
	}

	@Override
	public Boolean deleteItem(String thisItem) {
		
		if (head == null) {
			return true; //list was empty to begin with
		}
		
		return null;
	}

	@Override
	public Boolean insertBefore(String newItem, String itemToInsertBefore) {
		
		return null;
	}

	@Override
	public Boolean insertAfter(String newItem, String itemToInsertAfter) {
		
		return null;
	}

	@Override
	public void sort() {
		
	}
	
}
