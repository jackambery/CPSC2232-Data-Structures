package queue;

public class QueueTester {

	public static void main(String[] args) {

		Queue queue = new QueueImpl(8);
		queue.enQueue("ripple");
		queue.enQueue("franklins tower");
		queue.enQueue("friend of the devil");
		queue.enQueue("eyes of the world");
		queue.enQueue("althea");
		queue.enQueue("touch of grey");
		
		runTests(queue);
	}
	
	public static void runTests(Queue queue) {
		
		queue.display();
		System.out.println("\ncapacity: " + queue.getCapacity());
		System.out.println("current size: " + queue.getSize());
		System.out.println("is full?: " + queue.isFull());
		System.out.println("is empty?: " + queue.isEmpty());
		System.out.println("peeking... " + queue.peek());
		
		System.out.println("\ndequeuing...");
		queue.deQueue();
		queue.display();
		
		System.out.println("\ndequeuing...");
		queue.deQueue();
		queue.display();
		System.out.println("peeking... " + queue.peek());
		
		System.out.println("\ndequeuing...");
		queue.deQueue();
		queue.display();
		
		System.out.println("\ncapacity: " + queue.getCapacity());
		System.out.println("current size: " + queue.getSize());
		System.out.println("is full?: " + queue.isFull());
		System.out.println("is empty?: " + queue.isEmpty());
		System.out.println("peeking... " + queue.peek());
	}

}
