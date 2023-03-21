
class MinHeap {

 	private int[] Heap;
	private int size;
	private int maxsize;

	// Initializing front  
	private static final int FRONT = 1;

	// Constructor
	public MinHeap(int maxsize) {

		// This keyword refers to current object itself
		this.maxsize = maxsize;
		this.size = 0;

		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}
 
	// Returning the position of
	// the parent for the node currently
	// at pos
	private int parent(int pos) {
		return pos / 2;
	}
 
	// Returning the position of the
	// left child for the node currently at pos
	private int leftChild(int pos) {
		return (2 * pos);
	}
 
	// Returning the position of
	// the right child for the node currently
	// at pos
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}


	// Returning true if the passed
	// node is a leaf node
	private boolean isLeaf(int pos) {

		if (pos > (size / 2.0)) {
			return true;
		}

		return false;
	}

	
	// swap two nodes of the heap
	private void swap(int fpos, int spos) {

		int tmp;
		tmp = Heap[fpos];

		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

 
	// heapify the node at pos.   recursive call.
	
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			
			int swapPos = pos;
			
			// swap with the minimum of the two children to check if right child exists. 
			// Otherwise default value will be '0' and that will be swapped with parent node.
			
			if (rightChild(pos) <= size)
				swapPos = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
			else
				swapPos = Heap[leftChild(pos)];

			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				swap(pos, swapPos);
				minHeapify(swapPos);
			}

		}
	}

	 
	//insert a node into the heap
	public void insert(int element) {

		if (size >= maxsize) {
			return;
		}

		Heap[++size] = element;
		int current = size;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}


	// To print the contents of the heap
	public void print() {
		for (int i = 1; i <= size / 2; i++) {

			// Printing the parent and both children
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);

			// formating
			System.out.println();
		}
	}

	// Remove and return the minimum
	// element from the heap
	public int remove() {

		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);

		return popped;
	}


	//  driver 
	public static void main(String[] arg) {

		// Display message
		System.out.println("The Min Heap is ");

		// Creating object of class in main() method
		MinHeap minHeap = new MinHeap(29);

		// Inserting element to minHeap
		// using insert() method

		// Custom input entries
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.insert(7);
		minHeap.insert(28);
		
		// Print all elements of the heap
		minHeap.print();

		// Removing minimum value from above heap
		// and printing it
		System.out.println("The Min val is " + minHeap.remove());

		System.out.println("The Min val is " + minHeap.remove());
		System.out.println("The Min val is " + minHeap.remove());
		System.out.println("The Min val is " + minHeap.remove());
		System.out.println("The Min val is " + minHeap.remove());
		System.out.println("The Min val is " + minHeap.remove());
		System.out.println("The Min val is " + minHeap.remove());

		System.out.println("The Min val is " + minHeap.remove());

		System.out.println("The Min val is " + minHeap.remove());

		System.out.println("The Min val is " + minHeap.remove());

		System.out.println("The Min val is " + minHeap.remove());
	}
}