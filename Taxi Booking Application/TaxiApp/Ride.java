package TaxiApp;
public class Ride {
	Customer customer;
	Taxi taxi;
	char source;
	char destination;
	int pickupTime,fare,commission,distance;
	
	public Ride(Customer customer, char source,char destination,int pickupTime, Taxi taxi) {
		this.customer = customer;
		this.source = source;
		this.destination = destination;
		this.pickupTime = pickupTime;
		this.taxi = taxi;
		updateFare();
	}
	
	public void updateFare() {
		distance = Math.abs((source-'0')-(destination-'0'));
		fare = (distance*10)*10;
		commission = (int)(0.3*fare);
	}

}
