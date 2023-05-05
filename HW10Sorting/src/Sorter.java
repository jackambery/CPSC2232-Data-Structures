
public class Sorter {

	private int[] data;

	public Sorter() {
		this(null);
	}

	public Sorter(int[] data) {
		this.data = data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	// helper method which calls the recursive mergesort

	public void mergesort() {
		mergesort(0, data.length - 1);
	}

	public void merge(int f, int m, int l) {

		// allocate a temp array for the merge
		int[] temp = new int[l - f + 1];

		// create the indexes for both array halves
		int f1 = f, l1 = m, f2 = m + 1, l2 = l, i = 0;

		// TODO: merge into the temp array as long as both halves have elements
		while ((f1 <= l1) && (f2 <= l2))

			if (data[f1] < data[f2])
				temp[i++] = data[f1++];
			else
				temp[i++] = data[f2++];

		// TODO: finish the remaining elements of the half that has elements left
		while (f1 <= l1)
			temp[i++] = data[f1++];

		while (f2 <= l2)
			temp[i++] = data[f2++];

		// TODO: copy from temp array into the permanent array
		i = 0;
		for (int j = f; j <= l; i++, j++)
			data[j] = temp[i];

	}

// TODO: provide the recursive code to mergesort 
// base case is to do nothing when the number of elements is 0 or 1
// recursive case is when there are 2+ elements in indexes lo to hi

	private void mergesort(int lo, int hi) {
		// TODO
	}

	public void display() {

		System.out.print("[");

		for (int i = 0; i < data.length - 1; i++)
			System.out.print(data[i] + ",");

		System.out.println(data[data.length - 1] + "]");

	}

	void display(int n) {

		System.out.print("[");

		for (int i = 0; i < n; i++)
			System.out.print(data[i] + ",");

		System.out.print(" ... ");

		for (int i = data.length - 1 - n; i < data.length; i++)
			System.out.print(data[i] + ",");

		System.out.println(data[data.length - 1] + "]");
	}

	//TODO: provide the code for bubble sort
	public void bubbleSort() {
		// TODO
	}

	// TODO: provide the code to swap elements
	void swap(int m, int n) {
		// TODO
	}

	//TODO: provide the code to binary search 
	public int binarySearch(int key) {
		// TODO: remove the return 0
		// and implement the binarySearch method
		return 0;
	}

} 