import java.io.*;
import java.util.*;

public class Driver2 {

	private static Student2[] students = new Student2[100];
	private static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {

		FileReader file = new FileReader("students.txt");
		Scanner in = new Scanner(file);

		int i = 0;

		while (in.hasNextLine()) {
			String l1 = in.nextLine();
			String l2 = in.nextLine();
			String l3 = in.nextLine();
			int sem = in.nextInt();
			in.nextLine();

			students[i++] = new Student2(l1, l2, l3, sem);
		}

		runMenu();

		System.out.printf("Program Finished");

	}

	public static void runMenu() {
		do {

			menu();
			String input = kbd.next();
			int choice = Integer.parseInt(input);
			System.out.printf("%n");

			switch (choice) {
			case 1:
				displayAll();
				break;
			case 2:
				displayIndex();
				break;
			case 3:
				displayName();
				break;
			case 4:
				System.out.printf("Enter the semester (1-8): ");
				int sem = kbd.nextInt();
				displayBySemester(sem);
				break;
			case 5:
				addStudent();
				break;
			case 6:
				return;
			}
			try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
			}

		} while (true);

	}

	public static void menu() {
		System.out.printf("Choose an Option%n");
		System.out.printf("1 - Display All%n");
		System.out.printf("2 - Display by Index%n");
		System.out.printf("3 - Display Name%n");
		System.out.printf("4 - Display by Semester%n");
		System.out.printf("5 - Add a Student%n");
		System.out.printf("6 - Quit%n");
	}

	public static void displayAll() {
		int i = 0;
		while (students[i] != null)
			System.out.printf("%s%n%s%n", students[i++], "-------------------");
	}

	public static void displayIndex() {
		System.out.printf("Enter the Index ");
		String index = kbd.nextLine();
		int choice = Integer.parseInt(index);

		System.out.printf("%s%n%s%n", students[choice], "-------------------");
	}

	public static void displayName() {
		System.out.printf("Enter the Name ");
		String name = kbd.next();

		int i = 0;
		while (students[i] != null) {
			if (students[i].getName().toLowerCase().indexOf(name.toLowerCase()) != -1) {
				System.out.printf("%s%n%s%n", students[i], "-------------------");
				return;
			}
			i++;
		}

	}
	
	public static void displayBySemester(int sem) {
		for (Student2 s : students) {
			if (s.getSem() == sem) {
				s.toString();
			}
		}
	}
	
	public static void addStudent() {
		System.out.printf("Enter the Full Student Name: ");
		String name = kbd.next();
		
		System.out.printf("Enter Year (Freshman, Sophomore, Junior, Senior): ");
		String status = kbd.next();
		
		System.out.printf("Enter the Major (CPSC, ENG, MATH, PSYCH): ");
		String major = kbd.next();
		
		System.out.printf("Enter Semester Standing (1,2,3,4,5,6,7,8): ");
		int sem = kbd.nextInt();
		
		
		Student2 newStu = new Student2(name, status, major, sem);
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = newStu;
				break;
			}
		}
	}

}
