
package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ListBasedDiGraph implements DiGraph {
	private List<GraphNode> nodeList = new ArrayList<>();

	@Override
	public Boolean addNode(GraphNode node) {
		// if it doesn't exist, make it
		if (getNode(node.getValue()) == null) {
			nodeList.add(node);
			return true;
		}
		// otherwise the node is there, and cannot be added.
		return false;
	}

	// overlook this, needs to be checked
	@Override
	public Boolean removeNode(GraphNode node) {
		// if a to b to c
		// and b is removed, c must point to a
		if (nodeList.contains(new GraphNode(node.getValue()))) {
			nodeList.remove(node);
			for (GraphNode gn : nodeList) {
				if (gn.getNeighbors().contains(node)) {
					gn.removeNeighbor(node);
				}
			}
		}

		return false;
	}

	@Override
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		node.setValue(newNodeValue);
		return true;
	}

	@Override
	public String getNodeValue(GraphNode node) {
		return node.getValue();
	}

	@Override
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		// have to create new node that actually reference the ones in the graph
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (targetFromNode == null || targetToNode == null)
			return false; // nodes don't exist, can't make the edge

		return targetFromNode.addNeighbor(targetToNode, weight);
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (nodeList.contains(targetToNode) && nodeList.contains(targetToNode)) {
			targetFromNode.removeNeighbor(targetToNode);
			return true;
		}
		return false;
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		if (targetFromNode.getNeighbors().contains(targetToNode)) {
			targetFromNode.removeNeighbor(targetToNode);
		}
		targetFromNode.addNeighbor(targetToNode, newWeight);
		return true;
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		return targetFromNode.getDistanceToNeighbor(targetToNode);
	}

	@Override
	public List<GraphNode> getAdjacentNodes(GraphNode node) {
		return node.getNeighbors();
	}

	@Override
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {
		if (fromNode.getNeighbors().contains(toNode)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		Queue<GraphNode> queue = new LinkedList<>();
		ArrayList<GraphNode> reachable = new ArrayList<GraphNode>();

		for (GraphNode node : targetFromNode.getNeighbors()) {
			queue.add(node);
			reachable.add(node);
		}
		while (!queue.isEmpty()) {
			for (GraphNode gn : queue.remove().getNeighbors()) {
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

	@Override
	public Boolean hasCycles() {
		// for every station in map, if station is reachable from itself, it has cycles
		Boolean flag = true;
		for (GraphNode gn : nodeList) {
			if (!nodeIsReachable(gn, gn)) {
				System.out.println("I do not have a cycle: " + gn.getValue());
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public List<GraphNode> getNodes() {
		return nodeList;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		for (GraphNode gn : nodeList) {
			if (gn.getValue().equals(nodeValue)) {
				return gn;
			}
		}
		return null;
	}

	@Override
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		GraphNode tFromNode = getNode(fromNode.getValue());
		GraphNode tToNode = getNode(toNode.getValue());
		if (!nodeIsReachable(tFromNode, tToNode)) {
			System.out.println("These nodes are not connected");
			return -1;
		}

		Queue<GraphNode> queue = new LinkedList<>();
		ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
		Map<GraphNode, Integer> hops = new HashMap<>();
		
		queue.add(tFromNode);
		visited.add(tFromNode);
		hops.put(tFromNode, 0);
		
		while (!queue.isEmpty()) {
			GraphNode current = queue.remove();
			
			for (GraphNode gn : current.getNeighbors()) {
				if (!visited.contains(gn)) {
					queue.add(gn);
					visited.add(gn);
					hops.put(gn, hops.get(current) + 1);
				}
				if (gn.getValue().equals(tToNode.getValue())) {
					return hops.get(gn);
				}
			}
		}
		return -1;
	}

	@Override
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		GraphNode tFromNode = getNode(fromNode.getValue());
		GraphNode tToNode = getNode(toNode.getValue());
		
		if (!nodeIsReachable(tFromNode, tToNode)) {
			System.out.println("These nodes are not connected");
			return -1;
		}

		Queue<GraphNode> queue = new LinkedList<>();
		ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
		Map<GraphNode, Integer> distance = new HashMap<>();
		
		queue.add(tFromNode);
		visited.add(tFromNode);
		distance.put(tFromNode, 0);
		
		while (!queue.isEmpty()) {
			GraphNode current = queue.remove();
			
			for (GraphNode gn : current.getNeighbors()) {
				if (!visited.contains(gn)) {
					queue.add(gn);
					visited.add(gn);
					distance.put(gn, distance.get(current) + getEdgeValue(current, gn));
				}
				if (gn.getValue().equals(tToNode.getValue())) {
					return distance.get(gn);
				}
			}
		}
		return -1;
	}

}
