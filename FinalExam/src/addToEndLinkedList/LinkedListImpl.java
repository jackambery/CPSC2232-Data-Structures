package addToEndLinkedList;

public class LinkedListImpl implements LinkedList {

	private ListItem head;

	public LinkedListImpl() {
		head = null;
	}

	public Boolean addToEnd(String thisItem) {
		if (head == null) {
			head = new ListItem(thisItem);
			return true;
		} else {
			ListItem temp = head;
			while (!(temp.getNext() == null)) {
				temp = temp.getNext();
			}
			temp.setNext(new ListItem(thisItem));
			return true;
		}
	}

	public void listItems() {
		ListItem temp = head;
		while (!(temp == null)) {
			System.out.println(temp.toString());
			temp = temp.getNext();
		}

	}

	@Override
	public void addItem(String item) {
		addToEnd(item);
	}

}
