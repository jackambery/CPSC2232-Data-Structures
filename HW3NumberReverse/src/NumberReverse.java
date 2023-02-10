import java.util.Scanner;

public class NumberReverse {

	private static Long val;
	private static StackArray stack = new StackArray(15);

	public static void main(String[] args) {		
		while (true) {
			init();
			process();
		}	
	}

	public static void init() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a positive long integer with 8-15 digits (-1 to quit)");
		String longString = kb.next();
		val = Long.parseLong(longString);
		
		if (val == -1) {
			System.out.println("--Program ended--");
			System.exit(0);
		}
		
		System.out.println("You entered: " + val);

	}

	public static void process() {
		Long valDub = val * 2;

		System.out.println("Doubled the value is " + valDub);

		while (valDub != 0) {
			int temp = (int) (valDub % 10);
			stack.push(temp);
			valDub = valDub / 10;
		}

		Long result = (long) 0;
		int power = 0;

		while (!stack.empty()) {
			result = (long) ((long) result + (stack.pop() * Math.pow(10, power)));
			power++;
		}

		System.out.println("Result of reverse is " + result);
	}

}
