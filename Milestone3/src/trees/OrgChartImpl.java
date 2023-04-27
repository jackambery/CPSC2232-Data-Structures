package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrgChartImpl implements OrgChart {

	// Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();

	@Override
	public void addRoot(Employee e) {
		if (nodes.isEmpty()) {
			GenericTreeNode<Employee> root = new GenericTreeNode<Employee>(e);
			nodes.add(root);
		} else {
			System.out.println("root has already been established");
		}

	}

	public Boolean isInTree(Employee target) {
		for (GenericTreeNode<Employee> e : nodes) {
			if (e.equals(getEmployee(target))) {
				return true;
			}
		}
		return false;
	}

	// helper method
	public GenericTreeNode<Employee> getEmployee(Employee target) {
		for (GenericTreeNode<Employee> e : nodes) {
			if (e.data == (target)) {
				return e;
			}
		}
		return null;
	}

	// helper method
	public GenericTreeNode<Employee> getManager(Employee target) {
		for (GenericTreeNode<Employee> e : nodes) {
			if (e.children.contains(getEmployee(target))) {
				return e;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		nodes.clear();
	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		GenericTreeNode<Employee> theManager = null;
		if (!isInTree(manager)) {
			System.out.println("Error - manager not found");
		}
		if (!isInTree(newPerson)) {
			theManager = getEmployee(manager);
			GenericTreeNode<Employee> np = new GenericTreeNode<Employee>(newPerson);
			theManager.addChild(np);
			nodes.add(np);
		}
	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		getManager(firedPerson).removeChild(firedPerson);
		nodes.remove(getEmployee(firedPerson));
	}

	@Override
	public void showOrgChartDepthFirst(Employee e) {
		GenericTreeNode<Employee> root = getEmployee(e);
		Queue<GenericTreeNode<Employee>> children = new LinkedList<GenericTreeNode<Employee>>();
		System.out.println(root.toString());
		children.addAll(root.getChildren());
		while (!children.isEmpty() ) {
			showOrgChartDepthFirst(children.remove().data);
		}
	}

	@Override
	public void showOrgChartBreadthFirst() {
		Queue<GenericTreeNode<Employee>> queue = new LinkedList<GenericTreeNode<Employee>>();
		ArrayList<GenericTreeNode<Employee>> visited = new ArrayList<GenericTreeNode<Employee>>();
		
		queue.add(nodes.get(0));
		while (!queue.isEmpty()) {
			System.out.println(queue.peek().toString());
			for (GenericTreeNode<Employee> node : queue.remove().getChildren()) {
					if (!visited.contains(node)) {
						visited.add(node);
						queue.add(node);
					}
			}
		}

		
	}

}
