import java.util.Scanner;

public class NumberReverse {
	
	private static Long val;
	
	public static void main(String[] args) {
		init();
	}
	
	public static void init() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a long number of 8-15 digits");
		String longString = kb.next();
		val = Long.parseLong(longString);
	}

}
