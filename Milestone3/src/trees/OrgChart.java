package trees;

public interface OrgChart {
	public void addRoot(Employee e); 
		// if there is no orgchart, start it
	
	
	public void clear();
		// get rid of the org chart
	
	public void addDirectReport(Employee manager, Employee newPerson);
		// add the newPerson as a direct report (child) of manager
	
	public void removeEmployee(Employee firedPerson);
		// remove the employee, give their direct reports to their supervisor
	
	 /* I altered this method to take in an employee that acts as the root, so
	 * that this algorithm could be done recursively
	 * original header - public void showOrgChartDepthFirst();
	 */
	public void showOrgChartDepthFirst(Employee e);
	
	public void showOrgChartBreadthFirst();
	

}
