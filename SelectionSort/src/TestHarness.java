
public class TestHarness {

	public static void main(String[] args) {

		SelSortBinSearch selSortAndBinSearch = new SelSortBinSearch();
		selSortAndBinSearch.initValues();
		selSortAndBinSearch.printValues();
		System.out.println("values is sorted: " + selSortAndBinSearch.isSorted());
		System.out.println();

		TEST_SelectionSort(selSortAndBinSearch);
		//TEST_BinarySearch(selSortAndBinSearch);
	}

	public static void TEST_SelectionSort(SelSortBinSearch tester) {

		tester.selectionSort();
		tester.printValues();
		System.out.println("values is sorted: " + tester.isSorted());
		System.out.println();
	}

//	public static void TEST_BinarySearch(SelSortBinSearch tester) {
//		System.out.println("Binary Search:");
//		System.out.println("0 is in array: " + tester.binarySearch(0, 0, SelSortAndBinSearch.SIZE - 1));
//		System.out.println("1 is in array: " + tester.binarySearch(1, 0, SelSortAndBinSearch.SIZE - 1));
//
//		for (int i = (SelSortAndBinSearch.SIZE / 2 - 2); i <= (SelSortAndBinSearch.SIZE / 2 + 2); i++)
//			System.out.println(i + " is in array: " + tester.binarySearch(i, 0, SelSortAndBinSearch.SIZE - 1));
//
//		System.out.println(SelSortAndBinSearch.SIZE - 1 + " is in array: "
//				+ tester.binarySearch(SelSortAndBinSearch.SIZE - 1, 0, SelSortAndBinSearch.SIZE - 1));
//		System.out.println(SelSortAndBinSearch.SIZE + " is in array: "
//				+ tester.binarySearch(SelSortAndBinSearch.SIZE, 0, SelSortAndBinSearch.SIZE - 1));
//		System.out.println();
//
//	}

}
