import java.util.ArrayList;

public class MapTester {

	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		words.add("dog");
		words.add("cat");
		words.add("fish");
		words.add("mouse");
		words.add("dog");
		words.add("fish");
		words.add("fish");
		words.add("fish");
		words.add("dog");
		words.add("mouse");

		MapInterface<String, Integer> hMapWordCount = new HMap<String, Integer>();
		MapInterface<String, Integer> arrWordCount = new ArrayListMap<String, Integer>();

		for (String word : words) {
			if (hMapWordCount.contains(word)) {
				int count = hMapWordCount.get(word) + 1;
				hMapWordCount.put(word, count);
			} else {
				hMapWordCount.put(word, 1);
			}
		}

		for (String word : words) {
			if (arrWordCount.contains(word)) {
				int count = arrWordCount.get(word) + 1;
				arrWordCount.put(word, count);
			} else {
				arrWordCount.put(word, 1);
			}
		}

		System.out.println("Hash Array Implementation:");
		MapEntry[] hmap = ((HMap<String, Integer>) hMapWordCount).getMap();
		for (int i = 0; i <= hMapWordCount.size(); i++) {
			if (hmap[i] != null) {
				System.out.println(hmap[i].toString());
			}
		}

		System.out.println("\nArrayList Implementation:");
		ArrayList<MapEntry<String, Integer>> arrmap = ((ArrayListMap<String, Integer>) arrWordCount).getMap();
		for (MapEntry entry : arrmap) {
			System.out.println(entry.toString());
		}

	}

}

/*												------- Part 2 -------
 * 		When it comes to the put method, the array list implementation dynamically grows larger when a new entry is found.
 * The array based hash map is different because there is a set size and the enlarge method must be called when more space is needed.
 * The get method for the array list is very simple, a simple for-each loop scans through the map and simply return the value when the key 
 * is found. The array based hash map is also simple but must use a location variable and increment it until the target key is found.
 * 
 */
