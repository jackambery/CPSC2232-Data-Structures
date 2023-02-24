

public class QueueArray<T> implements Queue<T> {
	private int front;
	private int rear;
	private int MAX_SIZE = 100;
	private T[] data;
	private int numElements = 0;

	public QueueArray() {
		data = (T[]) new Object[MAX_SIZE];
		front = 0;
		rear  = 0;
	}
	
	public boolean empty() {
		if (numElements <= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean full() {
		if (numElements == 100) {
			return true;
		}
		else { 
			return false;
		}
	
	}

	public boolean enqueue(T el) {
		// TODO:
		// return false IF the queue is full
		
		if (full()) {
			return false;
		}
	 			
		
		// TODO:
		// IF queue if empty
		// 		add new element into position 0
		// 		both front and rear markers need to be updated to 0
		//		increment the numElements counter
		// 		return true		
		if (empty()) {
			data[0] = el;
			front = 0;
			rear = 0;
			numElements++;
			return true;
		}
		
		
		// TODO:
		// ELSE 	 (we know the queue is not full or empty )
		// 		bump the rear index
		// 		add the new element into the rear index
		//		increment the numElements counter
		// 		return true
		
		rear = bump(rear);
		data[rear] = el;
		numElements++;
		return true;
		
	}

	public T dequeue() {

		// TODO 
		// IF queue is empty
		// 	return null 
		if (empty()) {
			return null;
		}

		
		// TODO
		// (queue not empty)
		// store the element at the front of the queue into a local variable of type T
		T out = data[front];
	
		// TODO
		// check if there is ONLY 1 element in the queue
		// IF only one element:
		//	set front and rear to initial empty values
		// 	decrement the numElements counter
		if (numElements == 1) {
			front = 0;
			rear = 0;
			numElements--;
		}
		
		// TODO
		// ELSE (we know queue has 2+ elements)
		// bump the front marker
		// decrement the numElements counter
		front = bump(front);
		numElements--;
				
				
	
		//TODO: return the local variable into which you removed the front element
		return out;		

	}

	public void display() {
		// if queue is empty, print only [ ]
		if (empty())
			System.out.println("[ ]");

		// TODO: ELSE IF  queue has 1 element in it only
		// print [ <data front element> ]
	
		// Else if (front == rear){
		// System.out.print("[ " + data[front] + " ]");
		// }

		else if (front == rear)
			System.out.print("[ " + data[front] + " ]");


		
		// ELSE
		// initialize int index to front
		// while (true)
			// print data[index]
			// if index == rear, break
			// otherwise bump the index continue the loop

		else {

			System.out.print("[ ");

			int i = front;
			while (true) {
				System.out.print(data[i] + " ");

				if (i == rear)
					break;
				i++;
				
				if(numElements == 0)
					break;
			}
			System.out.print("] ");
			System.out.println(" ");

		}


		// print ]

	}

	private int bump(int index) {
		return (index + 1) % data.length;
	}

	// TODO:
	// this is a test program for the QueueArray class
	// AFTER this main can be run successfully, you may
	// remove it or comment it out, and run the REAL client program: TestQueue

	public static void main(String[] arg) {

		System.out.printf("Helo World%n");

		Queue<Integer> q = new QueueArray<>();
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(55);
		q.enqueue(12);
		q.enqueue(7);
		q.display();
		q.dequeue();
		q.display();
		q.enqueue(3);
		q.display();
	}
}
