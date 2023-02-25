package done;
import givens.YourStack;
import givens.YourStackNode;

public class YourLinkedListStack implements YourStack {
	// YOU MUST USE THIS IMPLEMENTATION - just code the methods
	private YourStackNode head = null;
	private Integer size = 0;

	@Override
	public void push(Integer i) {
		YourStackNode node = new YourStackNode();
		node.setItem(i);
		if (head == null) {
			head = node;
			
		}
		else {
			YourStackNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}			
			current.setNext(node);
		}

	}

	@Override
	public Integer pop() {
		YourStackNode current = head;
		if (current.getNext() == null) {
			int item = current.getItem();
			current = null;
			return item;
		}
		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		int item = current.getNext().getItem();
		current.setNext(null);
		return item;
	}

	@Override
	public Integer size() {
		YourStackNode current = head;
		while (current.getNext() != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

}
