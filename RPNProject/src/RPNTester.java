
import java.util.ArrayList;

public class RPNTester {

	public static void main(String[] args) {
		// don't change this method!
		YourRPNCalculator calc = new YourRPNCalculator(new YourArrayListStack());
		System.out.println("Testing ArrayList version");
		testRPNCalculator(calc);

		calc = new YourRPNCalculator(new YourLinkedListStack());
		System.out.println("Testing LinkedList version");
		testRPNCalculator(calc);
	}

	private static void testRPNCalculator(SimpleRPNCalculator calc) {
		ArrayList<String> testExpressions = new ArrayList<>();
		testExpressions.add("1 1 +"); // 2
		testExpressions.add("1 3 -"); // 2
		testExpressions.add("1 1 + 2 *"); // 4
		testExpressions.add("1 1 2 + *"); // 3
		testExpressions.add("1 1 + 2 2 * -"); // 2
		testExpressions.add("11 bv +"); // bad token
		testExpressions.add("2 3 + -"); // underflow on an operator
		testExpressions.add("2 3 + 4 5 -"); // leftover tokens
		
		// YOU SHOULD ADD MORE TEST CASES!
		testExpressions.add("4 5 7 2 + - *");
		testExpressions.add("3 4 + 2 * 7 +");
		testExpressions.add("5 7 + 6 2 - *");		
		testExpressions.add("4 2 3 5 1 - + * *");		
		testExpressions.add("4 2 + 3 5 1 - * +");		
		testExpressions.add("5 3 7 9 + +");
		
		for (String s : testExpressions) {
			System.out.println(calc.calculate(s));
		}

	}

}
