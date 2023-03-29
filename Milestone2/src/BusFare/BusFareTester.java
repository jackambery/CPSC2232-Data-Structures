package BusFare;
 

public class BusFareTester {

	public static void main(String[] args) {
		
		BusFareHandler busFare = new BusFareHandlerImpl();
		
		testBusFareHandler(busFare);

	}
	
	
	private static void testBusFareHandler (BusFareHandler fare) {
	 
		fare.grabChange();
		int initialCoin = fare.getMaxFromHeap();	
		
		System.out.println(" Exact Fare paid: " + fare.payBusFare(initialCoin) + " cents ");		
	
	}

}
