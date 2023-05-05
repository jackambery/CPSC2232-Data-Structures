package SocialNetwork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUtils<T> {

	public Boolean isConnected(Node<T> targetFromNode, Node<T> targetToNode) {

		Queue<Node<T>> queue = new LinkedList<>();
		ArrayList<Node<T>> reachable = new ArrayList<Node<T>>();

		for (Node<T> node : targetFromNode.getFriends()) {
			queue.add(node);
			reachable.add(node);
		}
		while (!queue.isEmpty()) {
			for (Node<T> gn : queue.remove().getFriends()) {
				if (!reachable.contains(gn)) {
					reachable.add(gn);
					queue.add(gn);
				}
			}
		}

		if (reachable.contains(targetToNode)) {
			return true;
		} else {
			return false;
		}
	}

}
