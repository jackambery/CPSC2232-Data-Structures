
public class Driver {

	public static void main(String args[]) {
		TEST_CITIES();
	}

	public static void TEST_CITIES() {

		// Create Vertices
		GraphNode austin = new GraphNode("austin");
		GraphNode dallas = new GraphNode("dallas");
		GraphNode denver = new GraphNode("denver");
		GraphNode washington = new GraphNode("washington");
		GraphNode houston = new GraphNode("houston");
		GraphNode atlanta = new GraphNode("atlanta");
		GraphNode chicago = new GraphNode("chicago");

		// Create Edges
		// hint - build the edge by adding a neighbor to a node
		austin.addNeighbours(dallas);
		austin.addNeighbours(houston);

		dallas.addNeighbours(austin);
		dallas.addNeighbours(chicago);
		dallas.addNeighbours(denver);

		washington.addNeighbours(dallas);
		washington.addNeighbours(atlanta);

		atlanta.addNeighbours(houston);

		houston.addNeighbours(atlanta);

		chicago.addNeighbours(denver);

		denver.addNeighbours(chicago);
		denver.addNeighbours(atlanta);

		// Create an instance of a new GraphUtils<String>();
		// invoke the pathExists method of your GraphUtils & print the result for each
		// of the following routes:

		// Austin -> Chicago
		// Denver -> Austin
		// Houston -> Dallas
		// Austin -> Atlanta
		// Denver -> Dallas
		// Washington -> Houston

		GraphUtils<String> myGraph = new GraphUtils<>();
		System.out.println("Routes Available: \n--------------------------------");
		System.out.println("Austin -> Chicago: " +  myGraph.pathExists(austin, chicago));		
		System.out.println("Denver -> Austin: " + myGraph.pathExists(denver, austin));
		System.out.println("Houston -> Dallas: " + myGraph.pathExists(houston, dallas));
		System.out.println("Austin -> Atlanta: " + myGraph.pathExists(austin, atlanta));
		System.out.println("Denver -> Dallas: " + myGraph.pathExists(denver, dallas));
		System.out.println("Washington -> Houston: " + myGraph.pathExists(washington, houston));

		
		
		
		
		

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
