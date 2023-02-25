package done;

import java.util.ArrayList;

public interface RPNStringTokenizer {
	public static ArrayList<String> tokenize(String expression) {
		// take a string. If it is valid RPN stuff - integers or operators
		// - then put them in a list for processing.
		// anything bad (not int or one of the operators we like) and return a null.

		ArrayList<String> operators = new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");

		String[] elements = expression.split(" ");
		int tracker = 0;
		for (String element : elements) {
			// element is a digit
			try {
				int i = Integer.parseInt(element);
				tracker++;
			} catch (NumberFormatException e) {
				// valid time to use an expression
				if (operators.contains(element) && tracker >= 2) {
					tracker--;
				}
				// not enough operands
				else if (operators.contains(element) && tracker <= 1) {
					System.out.println(expression + " is not a valid expression");
					return null;
				}
				// invalid operator
				else if (!operators.contains(element)) {
					System.out.println(expression + " is not a valid expression");
					return null;
				}
			}			
			
		}
		if (tracker == 1) {
			ArrayList<String> validExp = new ArrayList<String>();
			for (String element : elements) {
				validExp.add(element);
			}
			return validExp;
		} else {
			return null;
		}

	}
}
