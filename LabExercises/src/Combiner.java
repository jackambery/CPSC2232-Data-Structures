

public class Combiner {

	public void init(String s1, String s2) {
		try {
			int num1 = Integer.parseInt(s1);
			int num2 = Integer.parseInt(s2);

			int sum = num1 + num2;
			System.out.println("The sum of your numbers is: " + sum);

		} catch (Exception e) {
			System.out.println("Here is your combined output: " + s1 + s2);
		}
	}

}
