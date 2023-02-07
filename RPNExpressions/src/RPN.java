
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RPN {

	private static StackInterface<String> stack;
	private static Scanner in;
	private static FileReader file;
	private static Set<String> operators;

	public static void main(String[] args) {

		try {
			// update path to file on your system
			file = new FileReader("src/postfix.txt");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("File has not been found");
			System.exit(0);
		}

		in = new Scanner(file);

		// a set with all operators: +, ^, ...
		operators = new HashSet<>();
		operators.add("+");
		operators.add("^");
		operators.add("-");
		operators.add("*");
		operators.add("/");

		while (in.hasNextLine()) {

			String line = in.nextLine();

			// display the current line
			System.out.println("Line:" + line);

			// split the line. note the result is a string array
			String[] elements = line.split(" ");

			// create a StackInterface<String> instance of a StackRef
			stack = new StackRef<String>();

			// (loop) FOR every element in the result array just obtained on the last line:
			for (String s : elements) {
				// IF the operators set does not .contain() the current element from the result
				// array
				// we know it's an operand ( a number )
				if (!operators.contains(s)) {
					// ==> the current element is not an operand, PUSH it to the stack
					stack.push(s);
				}
				// ELSE we know it is an operator - perform a calculation according to your RPN
				// processing algorithm:
				else {
					// POP & capture right & left elements from the stack
					// convert to int
					int right = Integer.parseInt(stack.pop());
					int left = Integer.parseInt(stack.pop());

					// switch on the operator
					// perform your calculation ( so if your operation is '+', perform addition... )
					int answer = 0;
					switch (s) {
					case "+":
						answer = left + right;
						break;
					case "-":
						answer = left - right;
						break;
					case "*":
						answer = left * right;
						break;
					case "/":
						answer = left / right;
						break;
					case "^":
						answer = (int)Math.pow(left, right);
						break;
					default:
						System.out.println("----invalid operator----");
						break;
					}
					// PUSH result onto stack
					stack.push(Integer.toString(answer));
				}
			}
			System.out.println("Result: " + stack.pop() + "\n");
		}
	}
}
