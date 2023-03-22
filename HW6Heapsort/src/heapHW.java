
import java.util.Arrays;

// Choose 1 option for a possible 3 points 
// or do both options for a possible 5 points!
//

public class heapHW {

	public static void main(String args[]) {

		int arr[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9, 7, 28 };

		System.out.println("Array to be sorted by MinHeap: " + Arrays.toString(arr));
		heapSortByMinHeap(arr);

		System.out.println("\n");
		
		int arr2[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9, 7, 28 };

		System.out.println("Array to be sorted by native Heapify: " + Arrays.toString(arr2));
		heapSortByHeapify(arr2);
	}

	/* * * * P A R T 1 * * * */

	public static void heapSortByMinHeap(int[] arr) {
		// TODO:
		// Given an unsorted array (arr),
		// build a sorted array in ascending order using the provided minheap
		// implementation
		// print the sorted array

		MinHeap heap = new MinHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			heap.insert(arr[i]);
		}

		heap.print();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = heap.remove();
		}

		System.out.print("\nsorted array: " + Arrays.toString(arr));

	}

	/* * * * P A R T 2 * * * */

	/**
	 * Using a max-heap to sort in ascending order, 'float' the max to the front,
	 * and build the sorted list from the back. The result will be a sorted array in
	 * ascending order.
	 */
	public static void heapSortByHeapify(int[] array) {

		if (array.length == 0) {
			return;
		}

		int length = array.length;

		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(array, length, i);
		}

		/**
		 * From here the basic idea is to sort in place. Every time the algorithm polls
		 * from the heap, the heaps size shrinks by one. So one place at the end of the
		 * array is not part of the heap anymore. At this index the n-th smallest number
		 * is placed.
		 */

		for (int n = length - 1; n >= 0; n--) {
		
			// TODO:
			// swap the current root of the array to the end
			int temp = array[0];
			array[0] = array[n];
			array[n] = temp;
			
			

			// TODO:
			// heapify the reduced heap
			heapify(array, length - 1, n);

		}

		System.out.println("Heapify sorted array: " + Arrays.toString(array));
		System.out.println("");
	}

	/**
	 * heapify a subtree rooted with node i which is an index in arr[]. n is size of
	 * heap
	 * 
	 * @param arr: array
	 * @param n:   size of heap
	 * @param i:   index in array
	 */

	static void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}

	}
}