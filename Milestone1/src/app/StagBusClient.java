package app;
 
import java.util.HashSet;

import linkedList.LinkedList;
import linkedList.LinkedListImpl;
import linkedList.LinkedListTester;
import queue.Queue;
import queue.QueueImpl;
import queue.QueueTester;
import stack.Stack;
import stack.StackImpl;
import stack.StackTester;

public class StagBusClient {

	public static void main(String[] args) {
		
		HashSet<String> busStops = new HashSet<>();
		busStops.add("Circle");
		busStops.add("Town Center");
		busStops.add("Whole Foods");
		busStops.add("Stop and Shop");
		
		HashSet<String> riders = new HashSet<>();
		riders.add("eddie");
		riders.add("jimi");
		riders.add("stevie");
		riders.add("john");
		riders.add("steve");
		riders.add("david");

		System.out.println("-----L I S T  T E S T------");
		
		LinkedList route = new LinkedListImpl();
		for (String stop : busStops) {
			route.addItem(stop);
		}
		
		LinkedListTester listTester = new LinkedListTester();
		listTester.clientTester(route);
		
		
		System.out.println("\n----Q U E U E  T E S T-------");
		
		Queue waitingLine = new QueueImpl(10);
		for (String name : riders) {
			waitingLine.enQueue(name);
		}
		
		QueueTester queueTester = new QueueTester();
		queueTester.clientTester(waitingLine);
		
		
		System.out.println("\n-----S T A C K  T E S T------");

		Stack onBus = new StackImpl(10);
		for (String name : riders) {
			onBus.push(name);
		}
		
		StackTester stackTester = new StackTester();
		stackTester.clientTester(onBus);
		
	}
}
