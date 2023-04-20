
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class QuizGraph {

	private List<GraphNode> nodeList = new ArrayList<>();

	public Boolean addNode(GraphNode node) {
		if (getNode(node.getValue()) == null) { // if it doesn't exist, make it
			nodeList.add(node);
			return true;
		}
		return false; // otherwise the node is there, and cannot be added.
	}

	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		node.setValue(newNodeValue);
		return true;
	}

	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (targetFromNode == null || targetToNode == null)
			return false; // nodes don't exist, can't make the edge

		return targetFromNode.addNeighbor(targetToNode, weight);
	}

	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {

		if (fromNode.getNeighbors().contains(toNode)) {
			fromNode.removeNeighbor(toNode);
		}
		fromNode.addNeighbor(toNode, newWeight);

		return true;
	}

	public List<GraphNode> getAdjacentNodes(GraphNode node) {

		return node.getNeighbors();
	}

	// the rest is not for free
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		addNode(fromNode);
		addNode(toNode);
		Queue<GraphNode> queue = new LinkedList<>();
		Set<GraphNode> visitedNodes = new HashSet<>();
		// TODO - Set up your Queue, Set & Map

		queue.add(fromNode);
		visitedNodes.add(fromNode);

		int hops = 0;
		while (queue.peek() != null) {

			addNode(queue.peek()); // not sure if this line is necessary, just added for trial and error

			// neighbors remains empty, not sure why fromNode has no neighbors
			// tried using arraylist type and casting to arraylist
			// tried placing addNode() method a bunch to actually make sure fromNode get in graph
			// tried editing getNeighbors() method
			// would have been able to debug more and get hops correct if neighbors would actually fill in
			List<GraphNode> neighbors = queue.remove().getNeighbors();

			for (GraphNode neighbor : neighbors) {
				addNode(neighbor);
				if (!visitedNodes.contains(neighbor)) {
					hops++;
					visitedNodes.add(neighbor);
					queue.add(neighbor);
					if (neighbor == toNode) {
						System.out.println("target reached, hop = " + hops);
					}
				}
			}

			// TODO - keep track of neighbors visited && increment hops if not

			// TODO - iterate over all the neighbors of this node

			// TODO - IF target reached, done. Return number of hops

		}

		return hops;
	}

	// these are good
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		return fromNode.getDistanceToNeighbor(toNode);
	}

	public GraphNode getNode(String nodeValue) {
		for (GraphNode thisNode : nodeList) {
			if (thisNode.getValue().equals(nodeValue))
				return thisNode;
		}
		return null;
	}

	public String getNodeValue(GraphNode node) {
		return node.getValue();
	}

	public List<GraphNode> getNodes() {
		return nodeList;
	}

}
