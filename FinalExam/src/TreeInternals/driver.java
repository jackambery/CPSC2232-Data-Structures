package TreeInternals;


public class driver {
	
	
	public static void main(String[] args)
	{
	    //builds the tree
		Node root = new Node(3);
	    root.left = new Node(1);
	    root.right = new Node(4);
	    root.left.left = new Node(0);
	    root.left.right = new Node(2);
 
	 
	    TreeUtil tu = new TreeUtil();
	    tu.printInternalNodes(root);
	    
	    System.out.println("\n\nAdditional Tests:");
	    root.left.right.right = new Node(34);
	    root.right.left = new Node(41);
	    tu.printInternalNodes(root);
	}
	
	//anticipated result:  3 1 
}
