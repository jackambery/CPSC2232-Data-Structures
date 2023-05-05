package SocialNetwork;

public class Driver {

	public static void main(String args[]) {

	  
	 
		Node<String> harry = new Node<>("Harry");
		Node<String> sally = new Node<>("Sally");
		Node<String> timmy = new Node<>("Timmy");
		Node<String> tammy = new Node<>("Tammy");
		Node<String> ronnie = new Node<>("Ronnie");
		Node<String> bonnie = new Node<>("Bonnie"); 

		harry.addFriend(sally); 
		harry.addFriend(timmy);

		sally.addFriend(bonnie);
		timmy.addFriend(ronnie);
		
	
		GraphUtils<String> dft2 = new GraphUtils<String>();

		System.out.println(" Routes Available: ");

		System.out.println(" -------------------------------- ");

		System.out.println(" Timmy -> Tammy:\t " + dft2.isConnected(timmy, tammy));
		System.out.println(" Tammy -> Sally:\t " + dft2.isConnected(tammy, sally));
		System.out.println(" Ronnie -> Bonnie:\t " + dft2.isConnected(ronnie, bonnie));
		System.out.println(" Harry -> Ronnie:\t " + dft2.isConnected(harry, ronnie));
		System.out.println(" Bonnie -> Timmy:\t " + dft2.isConnected(bonnie, timmy)); 
		
		System.out.println("\nAdditional test:");
		System.out.println(" sally -> bonnie:\t " + dft2.isConnected(sally, bonnie));
		System.out.println(" timmy -> ronnie:\t " + dft2.isConnected(timmy, ronnie));
		System.out.println(" harry -> bonnie:\t " + dft2.isConnected(harry, bonnie));
		
	}

}
