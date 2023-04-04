import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal implements iTreeTraversal {

	@Override
	public void preorder(TreeNode TreeNode) {
		if (TreeNode != null) {
			System.out.print(TreeNode);
			preorder(TreeNode.left);
			preorder(TreeNode.right);
		}

	}

	@Override
	public void inorder(TreeNode TreeNode) {
		if (TreeNode != null) {
			inorder(TreeNode.left);
			System.out.print(TreeNode);
			inorder(TreeNode.right);
		}

	}

	@Override
	public void postorder(TreeNode TreeNode) {
		if (TreeNode != null) {
			postorder(TreeNode.left);
			postorder(TreeNode.right);
			System.out.print(TreeNode);
		}

	}

	@Override
	public void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

	}

}
