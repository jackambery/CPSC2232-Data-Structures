
package graphs;

import java.util.ArrayList;
import java.util.List;

public class ListBasedDiGraph implements DiGraph {
	private List<GraphNode> nodeList = new ArrayList<>();

	@Override
	public Boolean addNode(GraphNode node) {
		nodeList.add(node);
		return true;
	}

	@Override
	public Boolean removeNode(GraphNode node) {
		nodeList.remove(node);
		return true;
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
		fromNode.addNeighbor(toNode, weight);
		return true;
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		fromNode.removeNeighbor(toNode);
		return true;
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		if (fromNode.getNeighbors().contains(toNode)) {
			fromNode.removeNeighbor(toNode);
			fromNode.addNeighbor(toNode, newWeight);
			return true;
		}
		fromNode.addNeighbor(toNode, newWeight);
		return true;
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		return fromNode.getDistanceToNeighbor(toNode);
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
		if (fromNode.getDistanceToNeighbor(toNode) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean hasCycles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GraphNode> getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}

}
