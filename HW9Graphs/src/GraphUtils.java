import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUtils<T> {

	public Boolean pathExists(GraphNode<T> targetFromNode, GraphNode<T> targetToNode) {
 
		// create queue to manage nodes
		// create set to manage visitedNodes
		Queue<GraphNode> nodes = new LinkedList<GraphNode>();
		ArrayList<GraphNode> visited = new ArrayList<>();

		//start from the targetFromNode
		nodes.add(targetFromNode);
		
		while (!nodes.isEmpty()) {
			visited.add(nodes.peek());
			for (GraphNode<T> node : (ArrayList<GraphNode>) nodes.peek().getNeighbours()) {
				if (!visited.contains(node)) {
					nodes.add(node);
				}
			}
			nodes.poll();
		}
		
		if (visited.contains(targetToNode)) {
			return true;
		}
		
		//if u get here
		return false;
	}

}
