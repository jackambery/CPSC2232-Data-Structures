import java.util.Scanner;

public class TestHarness {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter a number or word:");
		String s1 = kb.nextLine();
		System.out.println("Please enter another number or word:");
		String s2 = kb.nextLine();

		
		Combiner tester = new Combiner();
		tester.init(s1, s2);
		
		kb.close();
	}

}
