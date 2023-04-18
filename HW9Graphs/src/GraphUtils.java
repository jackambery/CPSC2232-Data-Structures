import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUtils<T> {

	public Boolean pathExists(GraphNode<T> targetFromNode, GraphNode<T> targetToNode) {
 
		//TODO:

		// create queue to manage nodes
		// create set to manage visitedNodes
		Queue<GraphNode> nodes = new LinkedList<GraphNode>();
		ArrayList<GraphNode> visited = new ArrayList<>();

		//start from the targetFromNode
		nodes.add(targetFromNode);
			
			//for all neighbors:
				//check if visited.  If not, add to the queue.  
				//if targetToNode has been visited, return true
			
			
		
		//if u get here
		return false;
	}

}
