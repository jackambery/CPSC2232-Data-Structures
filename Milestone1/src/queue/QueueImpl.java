package queue;

import linkedList.Node;

public class QueueImpl implements Queue {

	private int capacity;
	private int size;
	private Node head;
	
	public QueueImpl(int capacity) {
		this.capacity = capacity;
		size = 0;
		head = null;
	}
	
	@Override
	public boolean isFull() {
		if (size == capacity) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}		
	}

	@Override
	public void enQueue(String element) {
		if (head == null && capacity != 0) {
			head = new Node(element);
			size++;
		}
		else if (size < capacity) { 
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.setNext(new Node(element));
			size++;
		}
		else {
			System.out.println("---queue is full---");
		}
		
	}

	@Override
	public String deQueue() {
		if (head != null) {
			Node temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
		else {
			return "queue is empty";
		}
	}

	@Override
	public void display() {
		Node current = head;
		System.out.println("Current queue:");
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		
	}

	@Override
	public String peek() {
		String data = head.data;
		return data;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}

}
