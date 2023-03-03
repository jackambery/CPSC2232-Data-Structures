
import java.util.Arrays;

public class reverseArrayRecursive {

	public static void main(String[] args) {

		int[] s = new int[] { 1, 2, 3, 4, 5 , 6, 7, 8, 9, 10};
		reverseArray(s);
		System.out.println(Arrays.toString(s));// should look like: "5,4,3,2,1"

	}

	public static void reverseArray(int[] x) {
		reverse(x, 0, x.length - 1);
	}

	public static void reverse(int[] x, int i, int j) {

		int middle = x.length / 2;
		// check halting condition
		if (i > j) {
			return;
		}
		
		// swap elements in array at position i & j
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		
		// perform recursive call
		i++;
		j--;
		reverse(x, i, j);		

	}

}