package TaxiApp;
import java.util.*;
public class Taxi {
	int id;
	String name;
	int pass;
	int age;
	int totalEarnings;
	List<Ride> rides;
	char location;
	int freeTime;
	
	

	public Taxi(int id,String name,int pass,int age) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
		totalEarnings = 0;
		rides = new ArrayList<Ride>();
		location = 'A';	
		freeTime = 6;
	}
	
	public void updateRide(Ride r) {
		location = r.destination;
		freeTime = (r.pickupTime + r.distance) % 24;
		totalEarnings += r.fair;
		rides.add(r);
	}

}
