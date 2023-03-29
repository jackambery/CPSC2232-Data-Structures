package MaxHeap;

public class MaxHeapTester {

	public static void main(String[] args) {
		MaxHeap theHeap = new MaxHeapImpl(15);
		runTests(theHeap);
	}

	public static void runTests(MaxHeap maxHeap) {
  	
		System.out.println("The Min Heap is ");

		// Creating object of class in main() method

		// Inserting element to minHeap
		// using insert() method

		// Custom input entries
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		maxHeap.insert(7);
		maxHeap.insert(28);
		
		// Print all elements of the heap
		maxHeap.display();;

	}
}
