package TreeInternals;

public class Node
{
    //package scope - no need for accessors mutators
	
	int data;
    Node left, right;
    Node(int data)
    {
        left = right = null;
        this.data = data;
    }
}
