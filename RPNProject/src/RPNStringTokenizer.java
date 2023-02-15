
import java.util.ArrayList;

public interface RPNStringTokenizer {
	public static ArrayList<String> tokenize(String expression) {
		// take a string. If it is valid RPN stuff - integers or operators
		// - then put them in a list for processing.
		// anything bad (not int or one of the operators we like) and return a null.

		ArrayList<Character> operators = new ArrayList<Character>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
		operators.add('^');
		
		char[] chars = expression.toCharArray();
		int tracker = 0;
		for (char c : chars) {
			if (Character.isDigit(c)) {
				tracker++;
				break;
			}
			//valid time to use expression
			if (operators.contains(c) && tracker == 2) {
				tracker = 0;
				break;
			}
			//too many operands
			if (operators.contains(c) && tracker != 2) {
				System.out.println(expression + "is not a valid expression");
				return null;
			}
			//invalid operator
			if (!operators.contains(c)) {
				System.out.println(expression + "is not a valid expression");
				return null;
			}
			
		}
		if (tracker == 0 ) {
			ArrayList<String> validExp = new ArrayList<String>();
			for (char c : chars) {
				validExp.add(Character.toString(c));
			}
			return validExp;
		}
		else {
			return null;
		}
		

	}
}
