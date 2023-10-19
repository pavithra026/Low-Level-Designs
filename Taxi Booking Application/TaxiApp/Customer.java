package TaxiApp;
import java.util.*;
public class Customer {
	int id;
	String name;
	int pass;
	int age;
	List<Ride> rides;
	public Customer(int id,String name,int pass,int age) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
		rides = new ArrayList<Ride>();
	}
	
	public void updateRide(Ride r) {
		rides.add(r);
	}

}
