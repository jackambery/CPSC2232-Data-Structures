package MaxHeap;

public class MaxHeapImpl implements MaxHeap {

	private int[] heap;
	private int size;
	private int maxsize;

	// initializing front like example from class
	private static final int FRONT = 1;

	public MaxHeapImpl(int maxsize) {

		this.maxsize = maxsize;
		this.size = 0;

		heap = new int[this.maxsize + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	// ---------------helper methods----------
	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {

		if (pos > (size / 2.0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void swap(int fpos, int spos) {

		int temp;
		temp = heap[fpos];

		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}
	
	private void maxHeapify(int pos) {
		if (!isLeaf(pos)) {
			
			int swapPos = pos;
			
			if (rightChild(pos) <= size)
				swapPos = heap[leftChild(pos)] > heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
			else
				swapPos = heap[leftChild(pos)];

			if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
				swap(pos, swapPos);
				maxHeapify(swapPos);
			}

		}
	}

	// ---------------------------------------

	@Override
	public void insert(int element) {
		
		if (size >= maxsize) {
			return;
		}

		heap[++size] = element;
		int current = size;

		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	@Override
	public void display() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + heap[i] +
					" LEFT CHILD : " + heap[2 * i] +
					" RIGHT CHILD :" + heap[2 * i + 1] + "\n");
		}

	}

	@Override
	public int extractMax() {
		
		int top = heap[FRONT];
		heap[FRONT] = heap[size--];
		maxHeapify(FRONT);

		return top;
	}

}
