package trees;

import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	// <some list of children>
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

	public void removeChild(E theItem) { // theItem is an employee
		// have to get the node of employee
		GenericTreeNode<E> target = null;
		ArrayList<GenericTreeNode<E>> newChildren = new ArrayList<GenericTreeNode<E>>();
		for (GenericTreeNode<E> e : children) { // siblings of the target
			if (e.data.equals(theItem)) { // the target
				for (GenericTreeNode<E> g : e.getChildren()) { // children of the target
					newChildren.add(g); // children to be added to parent
				}
				target = e;
			}
		}

		this.children.remove(target);

		for (GenericTreeNode<E> child : newChildren) {
			this.addChild(child);
		}
	}

	public String toString() {
		return data.toString();
	}

}
