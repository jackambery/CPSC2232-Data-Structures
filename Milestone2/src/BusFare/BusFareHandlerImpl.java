package BusFare;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import MaxHeap.MaxHeap;
import MaxHeap.MaxHeapImpl;

public class BusFareHandlerImpl implements BusFareHandler {

	//HAS-A max-heap
	
	private int[] pocket = new int[10];
	private int count = 1;
	
	@Override
	public void grabChange() {
		int[] choices = {1, 5, 10, 25, 50, 100};
		for (int i = 0; i < 10; i++) {
			int coin = (int) Math.random() * 6;
			pocket[i] = coin;
		}
		
	}

	@Override
	public int getMaxFromHeap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int payBusFare(int coin) {
		
		//in class 3/1/23
		//with an already sorted array
//		if (coin > 75) {
//			return coin;
//		}
//		coin = coin + pocket[count++];
//		return payBusFare(coin);
		
	}
 
}
