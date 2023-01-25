 
import java.util.Random;
import java.text.DecimalFormat;

public class SelSortBinSearch {
	 static int SIZE = 100; // size of array to be searched
	 int[] values = new int[SIZE]; // values to be sorted

	 void initValues()
	// Initializes the values array with random integers from 0 to SIZE.
	{
		Random rand = new Random();
		for (int index = 0; index < SIZE; index++)
			values[index] = Math.abs(rand.nextInt()) % SIZE;
	}

	 public boolean isSorted()
	// Returns true if the array values are sorted and false otherwise.
	{
		boolean sorted = true;
		for (int index = 0; index < (SIZE - 1); index++)
			if (values[index] > values[index + 1])
				sorted = false;
		return sorted;
	}

	 public void swap(int index1, int index2)
	// Precondition: index1 and index2 are >= 0 and < SIZE.
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	 public void printValues()
	// Prints all the values integers.
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("000");
		System.out.println("The values array is:");
		for (int index = 0; index < SIZE; index++) {
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println();
	}

	/////////////////////////////////////////////////////////////////
	//
	// Selection Sort
	 
	 void selectionSort() {
		//for each element from 0 to SIZE -1
			//find the index of the smallest value in values[startIndex]..values[endIndex].
			//(another for)
		// Swap the current element with the smallest unsorted one
		 for (int i = 0; i < SIZE; i++) {
			 int min = i;
			 for (int j = i+1; j < SIZE; j++) {
				 if (values[j] < values[min]) {
					 min = j;
				 }
				 swap(i, min);
			 }
			 
			 		 
		 }
	}

	//
	// Selection Sort End
	/////////////////////////////////////////////////////////////////

	 
	 /*
	  * In the binary search method, the collection is repeatedly divided into half 
	  * and the key element is searched in the left or right half of the collection 
	  * depending on whether the key is less than or greater than the mid element of the collection.
	  */
	 
	 boolean binarySearch(int target, int first, int last) {
	 
		return false;
	}

	
}
