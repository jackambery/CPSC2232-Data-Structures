package linkedList;
 

public class ListItem {
	public String data;
	public ListItem next;
	
	public ListItem(String data) {
		this.data = data;
		this.next = null;
	}
	
	public ListItem(String data, ListItem next) {
		this.data = data;
		this.next = next;
	}
	
	public void setNext(ListItem next) {
		this.next = next;
	}
	
	public String getData() {
		return data;
	}
	
	public ListItem getNext() {
		return next;
	}
}
