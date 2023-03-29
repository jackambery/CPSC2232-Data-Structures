package BusFare;
 
import java.util.Random;

import MaxHeap.MaxHeap;
import MaxHeap.MaxHeapImpl;

public class BusFareHandlerImpl implements BusFareHandler {

	//HAS-A max-heap
	
	private MaxHeap pocket = new MaxHeapImpl(10);
	
	@Override
	public void grabChange() {
		Random rd = new Random();
		int[] choices = {5, 10, 25, 50, 100};
		for (int i = 0; i < 10; i++) {
			int coin = choices[rd.nextInt(0, 4)];
			pocket.insert(coin);
		}
		
	}

	@Override
	public int getMaxFromHeap() {
		return pocket.extractMax();
	}

	@Override
	public int payBusFare(int coin) {
		
		if (coin > 75) {
			return coin;
		}
		coin = coin + getMaxFromHeap();
		return payBusFare(coin);
		
	}
 
}
