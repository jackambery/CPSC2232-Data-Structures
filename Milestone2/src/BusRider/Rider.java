package BusRider;

public interface Rider {
	
	/*
	
	b.	Your task is to:
		Implement the Rider Interface such that:
		Your implementation contains private members including:

			String name
			Int id // 4 digit code
			
			Your implementation overrides the hashcode() and equals() methods:
						// Hashcode: id %10 
						//equals – compare name & id

		2.	Test Harness:
			a.	Create 6 riders – 
			i.	2 with unique id’s & names
			ii.	2 with different name but same id’s
			iii.	2 with same name & id

		b.	Demonstrate equality and collision by running your riders thru the test harness & displaying hashcode/equals results for each
			

	*/

 
	boolean equals(Object object);
	
	
	//provide a simple hash code
	public int hashCode();
	
	
	//accessors & mutators
	public String getName(); 
	
	public int getId();
	
	public String toString();
	
}
