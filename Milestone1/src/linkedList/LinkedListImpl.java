package linkedList;

public class LinkedListImpl implements LinkedList {

	private int size = 0;
	private Node head = null;
	
	@Override
	public Boolean isItemInList(String thisItem) {
			
		Node current = head;
		while (current != null) {
			if (current.getData().equals(thisItem) ) {
				return true;
			}
			current = current.getNext();
		}
		return false;
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
		if (!isItemInList(data)){
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node newNode = new Node(data);
			current.next = newNode;
			size++;
			return true;
		}
		//already in list
		else {
			return false;
		}
		
	}

	@Override
	public Integer itemCount() {
		return size;
	}

	@Override
	public void listItems() {
		
		Node current = head;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
				
	}

	@Override
	public Boolean deleteItem(String thisItem) {
		
		if (head == null) {
			return true; //list was empty to begin with
		}
		
		Node current = head;
		while (current != null) {
			if (current.getNext().getData().equals(thisItem) && current.getNext() != null) {
				current.setNext(current.getNext().getNext());
				size--;
				return true;
			}
			current = current.getNext();
		}
		
		System.out.println("node was not found, nothing removed");
		return false;
	}

	@Override
	public Boolean insertBefore(String newItem, String itemToInsertBefore) {
		
		if (!isItemInList(itemToInsertBefore)) {
			System.out.println("node to be placed before not found");
			return false;
		}
		
		Node current = head;
		while (current != null) {
			if (current.getNext().getData().equals(itemToInsertBefore)) {
				Node newNode = new Node(newItem);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				size++;
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public Boolean insertAfter(String newItem, String itemToInsertAfter) {
		
		if (!isItemInList(itemToInsertAfter)) {
			System.out.println("node to be placed after not found");
			return false;
		}
		
		Node current = head;
		while (current != null) {
			if (current.getData().equals(itemToInsertAfter)) {
				Node newNode = new Node(newItem);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				size++;
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public void sort() {
		
	}
	
}
