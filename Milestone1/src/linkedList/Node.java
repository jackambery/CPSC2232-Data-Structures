package linkedList;
 

public class Node {
	public String data;
	public Node next;
	
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
}
