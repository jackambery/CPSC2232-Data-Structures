
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import done.RPNStringTokenizer;
import givens.SimpleRPNCalculator;
import givens.YourStack;

public class YourRPNCalculator implements SimpleRPNCalculator {
	// don't change these...
	YourStack theStack = null;

	public YourRPNCalculator(YourStack stack) {
		theStack = stack;
	}

	@Override
	public String calculate(String inputString) {
		// this is probably helpful, but you can remove...
		ArrayList<String> tokens = RPNStringTokenizer.tokenize(inputString);
		if (tokens == null) {
			return "";
		}
		
		int answer = 0;
		
		Set<String> operators = new HashSet<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		
		for (String token : tokens) {	
			
			switch (token) {
			case "+":
				answer = theStack.pop() + theStack.pop();
				theStack.push((int) answer);
				break;
			case "-":
				answer = theStack.pop() - theStack.pop();
				theStack.push((int) answer);
				break;
			case "*":
				answer = theStack.pop() * theStack.pop();
				theStack.push((int) answer);
				break;
			default:
				theStack.push(Integer.valueOf(token));
				break;
			}
		}
		return "Experession: " + inputString + "\nAnswer: " + String.valueOf(theStack.pop());

	}

}
