
public class Driver {

	public static void main(String args[]) {
		TEST_CITIES();
	}

	public static void TEST_CITIES() {

		// TODO:
		// Create Vertices
		GraphNode austin = new GraphNode(200);
		GraphNode dallas = new GraphNode(200);
		GraphNode denver = new GraphNode(200);
		GraphNode washington = new GraphNode(200);
		GraphNode houston = new GraphNode(200);
		GraphNode atlanta = new GraphNode(200);
		GraphNode chicago = new GraphNode(200);
		

		// TODO:
		// Create Edges
		// hint - build the edge by adding a neighbor to a node

		// TODO:
		// Create an instance of a new GraphUtils<String>();
		// invoke the pathExists method of your GraphUtils & print the result for each
		// of the following routes:

		// Austin -> Chicago
		// Denver -> Austin
		// Houston -> Dallas
		// Austin -> Atlanta
		// Denver -> Dallas
		// Washington -> Houston

	}

	/**
	 * Expected results:
	 * 
	 * Routes Available: -------------------------------- Austin -> Chicago: true
	 * Denver -> Austin: false Houston -> Dallas: false Austin -> Atlanta: true
	 * Denver -> Dallas: false Washington -> Houston: true
	 * 
	 */

}
