package trees;

import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
		children = new ArrayList<GenericTreeNode<E>>();
	}
	
	public ArrayList<GenericTreeNode<E>> getChildren() {
		return children;
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		if (children.contains(theItem)) {
			GenericTreeNode<E> node = new GenericTreeNode<E>(theItem);
			for (GenericTreeNode<E> g : (ArrayList<GenericTreeNode<E>>) ((GenericTreeNode<E>) theItem).getChildren()) {
				this.addChild(g);
			}
			children.remove(theItem);
		}
		else {
			System.out.println("node was not a child");
		}
	}
	
	public String toString() {
		return data.toString();
	}
	
	
} 
