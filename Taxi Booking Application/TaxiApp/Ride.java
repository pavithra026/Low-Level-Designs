package TaxiApp;
public class Ride {
	Customer customer;
	Taxi taxi;
	char source;
	char destination;
	int pickupTime,fair,commission,distance;
	
	public Ride(Customer customer, char source,char destination,int pickupTime, Taxi taxi) {
		this.customer = customer;
		this.source = source;
		this.destination = destination;
		this.pickupTime = pickupTime;
		this.taxi = taxi;
		updateFair();
	}
	
	public void updateFair() {
		distance = Math.abs((source-'0')-(destination-'0'));
		fair = (distance*10)*10;
		commission = (int)(0.3*fair);
	}

}
