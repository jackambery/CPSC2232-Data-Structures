package BusRider;
 

public class RiderImpl implements Rider {

	private String name;
	private int id;
	
	public RiderImpl(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RiderImpl)) {
			return false;
		}
		else {
			if (this.getName().equals(((RiderImpl) object).getName()) && this.id == ((RiderImpl) object).getId()) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
	@Override
	public int hashCode() {
		return id % 10;
	}
	
	@Override
	public String toString() {
		return "Rider: " + name + " Id: " + id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}


 
}
