
public class ListImpl<T extends Comparable<T>> implements List<T> {

	private ListNode<T> head;

	public ListImpl() {
		head = null;
	}

	// insert adds a node into the list in key order
	public boolean insert(T key) {
		if (head == null) {
			head = new ListNode<T>(key, null);
			return true;
		}
		// TODO if list is empty, create a new ListNode with key and null as parameters
		// set head to that new node and return true
		// List has at least one element

		// CALL search and get the prev reference
		ListNode<T> prev = search(key);

		// TODO if prev != null, we have a prev node, and we will insert after it
		// create a local reference, nextOfPrev, to the node that the prev node points
		// to // create new ListNode with key and nextOfPrev as parameters
		// set the next of the prev node to the new node
		if (prev != null) {
			// we insert after the prev node
			ListNode<T> nextOfPrev = prev.getNext();
			ListNode<T> temp = new ListNode<T>(key, nextOfPrev);
			// nextOfPrev = temp;
			prev.setNext(temp);
			;

		}
		// TODO create a new ListNode with key and head as parameters // set head to the
		// new node
		else {
			// we insert a new first node
			ListNode<T> newHead = new ListNode<T>(key, head);
			head = newHead;
			return true;
		}
		return false;
	}

	// Search is looking for value Key in the list
	// It will return the pointer to the previous node where key is (or should be)
	// // or null if key is or should be in the first node
	private ListNode<T> search(T key) {
		ListNode<T> prev = null, curr = head;
		boolean done = false;
		while (curr != null && !done) {
			if (curr.getData().compareTo(key) < 0) {
				prev = curr;
				curr = curr.getNext();
			} else // key <= curr.getData()
				done = true;

		}
		return prev;
	} // search

	public boolean remove(T key) {
		ListNode<T> prev = search(key);

		// TODO if head is null you can return false (nothing in the list)
		if (head == null) {
			return false;
		}
		// TODO
		// if head.data is same as key
		// set head to head next
		// return true
		// else return false – no match
		if (head.getData() == key) {
			head = head.getNext();
			return true;
		}
		// TODO
		// if prev next is null
		// there is nothing to remove
		// return false
		if (prev != null) {
			if (prev.getNext() == null) {
				return false;
			}
			
			// TODO
			// if prev next data matches the key
			// create local reference del to the prev next node
			// set prev next to the del next reference to bypass the node // return true
			if (prev.getNext().getData() == key) {
				ListNode<T> del = prev.getNext().getNext();
				prev.setNext(del);
				return true;
			}
		}
		
		// TODO
		// else return false
		return false;

	}

	// TODO
	// displays prints the list content in [ ]'s separated by commas
	public void display() {
		if (head != null) {
			ListNode<T> current = head;
			System.out.print("[");
			while (current != null) {
				// if/else for removing last comma
				if (current.getNext() == null) {
					System.out.print(current.getData());
				} else {
					System.out.print(current.getData() + ", ");
				}
				current = current.getNext();
			}
			System.out.println("]");
		} else {
			System.out.println("List is empty.");
		}
	} // display()

} // end of the class
