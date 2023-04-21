
package graphs;

import java.util.ArrayList;
import java.util.List;

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
		if (fromNode.getDistanceToNeighbor(toNode) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean hasCycles() {
		// for every station in map, if station is reachable from itself, it has cycles
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
