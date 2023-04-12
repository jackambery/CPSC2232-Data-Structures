package trees;
 
public class testOrgChart {

	/**
	* 
	* 
	* 						ROB
	* 					/		\		\
	* 				todd		ralph    tim
	* 
	* 				/				\ 
	* 			sally				ronnie
	* 
	*/
	
	private static OrgChart orgChart = new OrgChartImpl();
	private static Employee e1 = new Employee();
	private static Employee e2 = new Employee();
	private static Employee e3 = new Employee();
	private static Employee e4 = new Employee();
	private static Employee e5 = new Employee();
	private static Employee e6 = new Employee();
	
	
	public static void main(String[] args) {
	
		createEmployees();
		createOrgChart();
	}
	
	static void createEmployees() {
		
	 	e1.setId(100);
		e1.setName("Rob");
		e1.setPosition("CEO");
	
	 	e2.setId(200);
		e2.setName("todd");
		e2.setPosition("manager");
		
		
	 	e3.setId(300);
		e3.setName("sally");
		e3.setPosition("worker");
		
		
	 	e4.setId(400);
		e4.setName("ralph");
		e4.setPosition("manager");
		
	 	e5.setId(500);
		e5.setName("ronnie");
		e5.setPosition("worker");
		
	 	e6.setId(600);
		e6.setName("tim");
		e6.setPosition("manager");
		
	}

	static void createOrgChart() {
		
		
		orgChart.addRoot(e1);
		orgChart.addDirectReport(e1, e2);
		//todd reports to rob
		
		printBreadthFirst();
		printDepthFirst();

		
		orgChart.addDirectReport(e2, e3);
		//sally reports to todd

		printBreadthFirst();
		printDepthFirst();		
		
		 
		orgChart.addDirectReport(e1, e4);
		//ralph reports to rob


		printBreadthFirst();
		printDepthFirst();
		
		orgChart.addDirectReport(e4, e5);
		//ronnie reports to ralph
		

		printBreadthFirst();
		printDepthFirst();
		 	
		orgChart.addDirectReport(e1, e6);
		//tim reports to rob

		printBreadthFirst();
		printDepthFirst();

		 
 		orgChart.removeEmployee(e2);
 		//remove todd
 		//sally should then report to rob
		printBreadthFirst();
		printDepthFirst();

		
	}
	
	static void printBreadthFirst() {
		System.out.println("- - - ");
		System.out.println("- Breadth First - - ");
		
		orgChart.showOrgChartBreadthFirst();	
 		System.out.println("- - - ");
		System.out.println(" ");
	}
	
	static void printDepthFirst() {
		System.out.println("- - - ");
		System.out.println("- Depth First - - ");
		orgChart.showOrgChartDepthFirst();	 
		System.out.println("- - - ");
		System.out.println(" ");
	}
	
	
}
