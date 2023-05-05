package TreeInternals;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

	public void printInternalNodes(Node root) {

		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {

			Node p = queue.peek();
			queue.remove();

			if ((!(p.left == null)) || (!(p.right == null))) {
				System.out.print(p.data + " ");
			}

			if (!(p.left == null)) {
				queue.add(p.left);
			}
			if (!(p.right == null)) {
				queue.add(p.right);
			}

		}

	}

}
