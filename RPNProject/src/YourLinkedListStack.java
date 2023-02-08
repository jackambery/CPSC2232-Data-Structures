
public class YourLinkedListStack implements YourStack {
	// YOU MUST USE THIS IMPLEMENTATION - just code the methods
	private YourStackNode head = null;
	private Integer size = 0;

	@Override
	public void push(Integer i) {
		
		if (head == null) {
			head.setItem(i);
		}
		else {
			while (head.getNext() != null) {
				head = head.getNext();
			}
			YourStackNode node = new YourStackNode();
			node.setItem(i);
			head.setNext(node);
		}

	}

	@Override
	public Integer pop() {
		if (head.getNext() == null) {
			int item = head.getItem();
			head = null;
			return item;
		}
		while (head.getNext().getNext() != null) {
			head = head.getNext();
		}
		int item = head.getNext().getItem();
		head.setNext(null);
		return item;
	}

	@Override
	public Integer size() {
		while (head.getNext() != null) {
			head = head.getNext();
			size++;
		}
		return size;
	}

}
