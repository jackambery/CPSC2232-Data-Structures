
public class BST<T extends Comparable<T>> implements iBST<T> {

	private BSTNode<T> root;

	public BST() {
		root = null;
	}

	public void inOrder() {
		System.out.print("[ ");
		inOrder(root);
		System.out.println("]");
		System.out.println();
	}

	private void inOrder(BSTNode<T> cur) {
		if (cur != null) {
			inOrder(cur.getLeft());
			System.out.printf("%s ", cur.data);
			inOrder(cur.getRight());
		}
	}

	public boolean insert(T data) {
		// nothing in the tree add new node and connect it to the root

		if (root == null) {
			root = new BSTNode<T>(data);
			return true;
		}

		// tree not empty, search for a parent to connect to
		BSTNode<T> parent = search(data);

		// there is a root node, so parent cannot be null
		// when parent is null return false meaning failure to insert

		if (parent == null)
			return false;

		// determine if the new value is going as left or right child
		
		if (data.compareTo(parent.getData()) < 0) // new key < parent key
		{
			// always true unless key is a duplicate
			if (parent.left == null) {
				BSTNode<T> node = new BSTNode<T>(data);
				parent.setLeft(node);
				return true;
			}
		} 
		else // new key > parent key
		{
			// always true unless key is a duplicate
			if (parent.right == null) {
				BSTNode<T> node = new BSTNode<T>(data);
				parent.setRight(node);
				return true;
			}
		}

		return false; // because found duplicate
	}

	// Search success when cur.data is not <, not >, 
	// As it then must be EQUAL 
	// in this case return parent to the matched cur

	// gurgle thru the tree & find the parent node of this T.  
	// return it
	
	public BSTNode<T> search(T data) {
		BSTNode<T> cur = root;
		BSTNode<T> parent = null;

		while (cur != null) { 
			if (data.compareTo(cur.data) < 0) {
				parent = cur;
				cur = cur.left;
			} else if (data.compareTo(cur.data) > 0) {
				parent = cur;
				cur = cur.right;
			} else  
				return parent; 
		}

		return parent;
	} 
	
	// Helper function to find minimum value node in the subtree rooted at `cur`
    public BSTNode<T> inOrderSuccessor(BSTNode<T> cur)
    {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
	
	public boolean remove(T key) {
		if (root == null)
			return false;

		BSTNode<T> parent = search(key);

		if (parent == null) // current node is root (ignore the remove for now)
			return false;

		// we can assume that the parent has a node it is referencing

		// KEY SMALLER THAN PARENT
		if (key.compareTo(parent.data) < 0) {
			if (parent.getLeft() == null) // node not in the tree
				return false;
			else // node can be deleted
			{
				BSTNode<T> cur = parent.getLeft();
	
				// TODO
		
				// DELETE THE NODE
				
				// Case 1: node to be deleted has no children, i.e., it is a leaf node
				if (cur.getLeft() == null && cur.getRight() == null) {
					parent.setLeft(null);
					return true;
				}
		 		
				// Case 2: node to be deleted has only one child
				if ((cur.getLeft() != null && cur.getRight() == null) || (cur.getLeft() == null && cur.getRight() != null)) {
					if (cur.getLeft() != null) {
						parent.setLeft(cur.getLeft());
						cur.setLeft(null);
					}
					else {
						parent.setLeft(cur.getRight());
						cur.setRight(null);
					}
					return true;
				}
				
				// Case 3: node to be deleted has two children
				if (cur.getLeft() != null && cur.getRight() != null) {
					BSTNode<T> ios = inOrderSuccessor(cur);
					T data = ios.data;
					remove(data);
					parent.getLeft().data = ios.data;;
					return true;
				}
	  	 
				
			}
		}

		// KEY > PARENT KEY
		else {
			if (parent.getRight() == null) // node not in the tree
				return false;
			else // node can be deleted
			{
				// TODO
				// DELETE THE NODE
				
				BSTNode<T> cur = parent.right;
				
				// Case 1: node to be deleted has no children, i.e., it is a leaf node
				if (cur.getLeft() == null && cur.getRight() == null) {
					parent.setRight(null);
					return true;
				}
		 		
				// Case 2: node to be deleted has only one child
				if ((cur.getLeft() != null && cur.getRight() == null) || (cur.getLeft() == null && cur.getRight() != null)) {
					if (cur.getLeft() != null) {
						parent.setRight(cur.getLeft());
						cur.setLeft(null);
					}
					else {
						parent.setRight(cur.getRight());
						cur.setRight(null);
					}
					return true;
				}
				
				// Case 3: node to be deleted has two children
				if (cur.getLeft() != null && cur.getRight() != null) {
					BSTNode<T> ios = inOrderSuccessor(cur);
					T data = ios.data;
					remove(data);
					parent.getRight().data = ios.data;
					return true;
				}
 				
			 
			}
		}
		return false;
	}

}  








