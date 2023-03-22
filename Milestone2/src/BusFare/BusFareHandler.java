package BusFare;

public interface BusFareHandler {

	/**
	 * Initializes your available change.
	 * 
	 * 
	 * create a MaxHeap with a 1,5,10,25,50,100 coin randomly inserted
	 */

	public void grabChange();

	/**
	 * get the largest ( in this case the 100 cent ) coin from your maxHeap
	 * 
	 * @return max
	 */

	public int getMaxFromHeap();

	/**
	 * (1) The param for this method should be the result returned from
	 * getMaxFromHeap()
	 * 
	 * (2) RECURSIVSELY build up the bus fare.
	 * 
	 * 
	 * (3) Constraint: Bus only accepts 5,25,50,100 cent coins, but you should have
	 * other coins in your collection.
	 * 
	 * 
	 * @param coin
	 */
	public int payBusFare(int coin);

	// week1 test recursive call by selecting next element out of a sorted array
	// instead of calling getMaxFromHeap()

}
