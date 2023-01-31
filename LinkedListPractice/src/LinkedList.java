
public class LinkedList<T> implements List<T>{

	private Node<T> head;
	
	@Override
	public boolean add(T key) {
		
		//if head == null, nothing in the list
		//create a new node with the data
		//set that to head
		// return
		
		if (head == null) {
			Node<T> temp = new Node(key);
			head = temp;
			return true;
		}

		//else
		//set head to local Node current
		//step thru each element in the list, checking if the .next of this node is null
		//once found, create a new node out of incoming data & set that to current.next

		else {
			Node<T> current = head;
			while (current.getNext() != null) {				
				current = current.getNext();
			}
			Node<T> temp = new Node(key);
			current.setNext(temp);
			return true;
		}
	}

	@Override
	public boolean delete(T key) {
		Node<T> current = head;
		
		//if head == null, nothing in the list, return
		if (current == null) {
			return false;
		}
		 
		//if head.data == incoming data
		// set head = the node head points to.  return.
		if (current.getData() == key) {
			current = current.getNext();
			return true;
		}
		
		//else
				//create a new local node with the head
				//step thru each element in the list.  if the next is non null
				//check if that data == the data we want to delete
				//if yes, this is the element to delete.  
				//do that by setting current.next = current.next.next
				//else, set current to the next element in the list
		else {
			while (current.getNext() != null) {
				if (current.getData() == key) {
					current.setNext(current.getNext().getNext());
				}
				current = current.getNext();
			}
			return true;
		}
	}

	@Override
	public void display() {
		
		//iterate over the list, displaying the data for each node.
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	 
}
