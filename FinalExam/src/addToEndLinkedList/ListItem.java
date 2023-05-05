package addToEndLinkedList;

 

public class ListItem {
	public String data;
	public ListItem next;
	
	public ListItem(String data) {
		this.data = data;
		this.next = null;
	}
	
	public void setNext(ListItem next) {
		this.next = next;
	}
	
	public ListItem getNext() {
		return next;
	}
	
	public String toString() {
		return data;
	}
}
