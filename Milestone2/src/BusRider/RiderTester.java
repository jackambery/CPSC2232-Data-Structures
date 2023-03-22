package BusRider;

import java.util.ArrayList;
import java.util.List;

public class RiderTester {

	public static void main(String[] args) {
		
		Rider rider1 = new RiderImpl("emily", 1010);
		Rider rider2 = new RiderImpl("amy", 1919);
		Rider rider3 = new RiderImpl("jack", 1234);
		Rider rider4 = new RiderImpl("joe", 1234);
		Rider rider5 = new RiderImpl("jeff", 3333);
		Rider rider6 = new RiderImpl("jeff", 3333);
		
		List<Rider> riders = new ArrayList<>();
		riders.add(rider1);
		riders.add(rider2);
		riders.add(rider3);
		riders.add(rider4);
		riders.add(rider5);
		riders.add(rider6);
		
		for (Rider r : riders) {
			System.out.println(r.toString());
		}
		
		System.out.println("\n" + rider1.getName() + " and " + rider2.getName() + " equal? - " + rider1.equals(rider2));
		System.out.println(rider3.getName() + " and " + rider4.getName() + " equal? - " + rider3.equals(rider4));
		System.out.println(rider5.getName() + " and " + rider6.getName() + " equal? - " + rider5.equals(rider6));
	}

}
