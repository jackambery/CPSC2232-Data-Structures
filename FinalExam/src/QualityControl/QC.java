package QualityControl;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class QC {

	/*
	 *  if the defect matches the previous one, it should be ignored.
	 	For example, the string ‘ghhrkkb’ should be parsed into ‘ghrkb’ 
	 	
	 	Implement the defectParser() method by simplifying the input
		string EFFICIENTLY!
	 */
	public static String defectParser(String s) {
	
		Stack<Character> list = new Stack<Character>();
		char[] array = s.toCharArray();
		for (char c : array) {
			if (list.isEmpty() || !list.peek().equals(c)) {
				list.push(c);
			}
		}
		
		String efficient = "";
		while (!list.isEmpty()) {
			efficient = list.pop() + efficient;
		}
		
		return efficient;
    }
	
	
	
	public static void main(String args[]) {
		
		System.out.println(defectParser("ghhrkkb"));
 		
		//anticipated result: ghrkb
	}
}
