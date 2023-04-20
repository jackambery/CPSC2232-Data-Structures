
import java.util.ArrayList;
import java.util.List;

class GraphNode<T> {
	
	T data;
	boolean visited;
	List<GraphNode<T>> neighbours;

	GraphNode(T data) {
		this.data = data;
		this.neighbours = new ArrayList<>();
		visited = false;
	}

	public void addNeighbours(GraphNode<T> neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<GraphNode<T>> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<GraphNode<T>> neighbours) {
		this.neighbours = neighbours;
	}
	
	public Boolean getVisited() {
		return visited;
	}
	
	public void setVisited(Boolean setter) {
		visited = setter;
	}

}
