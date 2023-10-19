package TaxiApp;
import java.util.*;
public class TaxiApplication {
	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		//List of taxi and customer objects
		List<Taxi> taxiList = new ArrayList<Taxi>();
		List<Customer> CustomerList = new ArrayList<Customer>();
		
		taxiList.add(new Taxi(1, "Taxi-A", 111, 25));
		taxiList.add(new Taxi(2, "Taxi-B", 222, 36));
		taxiList.add(new Taxi(3, "Taxi-C", 333, 31));
		taxiList.add(new Taxi(4, "Taxi-D", 444, 28));
		
		CustomerList.add(new Customer(1, "Customer-1", 55, 25));
		CustomerList.add(new Customer(2, "Customer-2", 66, 36));
		CustomerList.add(new Customer(3, "Customer-3", 77, 31));
		CustomerList.add(new Customer(4, "Customer-4", 88, 28));

		System.out.println("WELCOME TO ZULA CAB BOOKING APPLICATION!\n");
		
		//Prompt
		boolean loop = true;
		while(loop) {
			System.out.println("1.Driver login\n2.Customer Login\n3.ZULA Administrator\n4.Exit");
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:
				DriverLogin(taxiList);
				break;
			case 2:
				System.out.println("1.Login\n2.Sign Up");
				int op = Integer.parseInt(sc.nextLine());
				if(op == 1) {
					CustomerLogin(CustomerList,taxiList);
				}else if(op == 2) {
					System.out.println("CREATE NEW USER ACCOUNT:");
					int id = (CustomerList.get(CustomerList.size()-1).id)+1;
					System.out.println("Enter Your Name: ");
					String name = sc.nextLine();
					System.out.println("Create a new Password(only numbers):");
					int pass = Integer.parseInt(sc.nextLine());
					System.out.println("Enter Your Age: ");
					int age = Integer.parseInt(sc.nextLine());
					CustomerList.add(new Customer(id,name,pass,age));
					System.out.println("Your account has been created. Proceed to login with Your credentials.");
					CustomerLogin(CustomerList,taxiList);
				}
				break;
			case 3:
				ZulaAdmin(taxiList,CustomerList);
				break;
			case 4:
				System.out.println("Exiting from ZULA application.");
				loop = false;
				sc.close();
				break;
			default:
				System.out.println("**Enter a valid option**");
			}
		}
		
	
		
		
	}
	
	public static List<Taxi> getFreeTaxi(int pickUptime, int Source, List<Taxi> taxiList){
		List<Taxi> freeTaxies = new ArrayList<Taxi>();
		for(Taxi t: taxiList) {
			int distance = Math.abs((t.location-'0')-(Source-'0'));
			if(t.freeTime <= pickUptime && (t.freeTime+distance) <= pickUptime) {
				freeTaxies.add(t);
			}
		}
		
		return freeTaxies;
		
	}
	
	
	public static void AllocateTaxi(char Source,char destination, int pickUpTime, Customer currentCustomer, List<Taxi> taxiList) {
		List<Taxi> freeTaxi = getFreeTaxi(pickUpTime,Source, taxiList);
		List<Taxi> nearbyTaxi = new ArrayList<Taxi>();
		
		//Find nearby taxi with low income and add to the list.
		if(!freeTaxi.isEmpty()) {
			int min = Integer.MAX_VALUE;
			for(Taxi t: freeTaxi) {
				int diff = Math.abs((t.location-'0')-(Source-'0'));
				if(diff < min) {
					nearbyTaxi.clear();
					min = diff;
					nearbyTaxi.add(t);
				}else if(diff == min) {
					nearbyTaxi.add(t);
				}	
			}
			
			//sorting taxis based on their income in ASC order
			Collections.sort(nearbyTaxi,(a,b)->Integer.compare(a.totalEarnings, b.totalEarnings));
			
			//In case there are 2 taxis that has low income & nearby then choose first taxi in list or random selection(developer preference)
			System.out.println("Taxi Can be Allocated : " + nearbyTaxi.get(0).name);
			
			//Creating new ride object for every new ride
			Ride r = new Ride(currentCustomer,Source,destination,pickUpTime,nearbyTaxi.get(0));
			
			//updating their ride details to respective customer and the taxi they got allocated
			nearbyTaxi.get(0).updateRide(r);
			currentCustomer.updateRide(r);
			
			//print taxi availability every time before booking
			System.out.println("-------------TAXI DETAILS------------\n\n");
			System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|", "TAXI", "TAXI LOCATION", "AVAILABLE TIME", "TOTAL EARNINGS"));
			System.out.println("--------------------------------------------------------------");
			for (Taxi taxi : taxiList) {
				String freeTime = String.format("%d %s", (taxi.freeTime == 0) ? 12 : (taxi.freeTime > 12 ? taxi.freeTime - 12 : taxi.freeTime), (taxi.freeTime >= 12) ? "PM" : "AM");
			    System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|", taxi.name, taxi.location, freeTime, taxi.totalEarnings));
			}
			System.out.println("\n");


		}else {
			System.out.println("Sorry No taxi can be alloted at this moment. Kindly Check the availability");
			System.out.println("\n");

		}
		
	}
	
	public static void DriverLogin(List<Taxi> taxiList ) {
		sc = new Scanner(System.in);
		int userid,passwd;
		Taxi currentDriver = null;
		
		
		while(true) {
			System.out.println("Enter your UserId");
			userid = Integer.parseInt(sc.nextLine());
			System.out.println("Enter your Password");
			passwd = Integer.parseInt(sc.nextLine());
			boolean validate = false;
			for(Taxi t: taxiList) {
				if(t.id == userid) {
					if(t.pass == passwd) {
						validate = true;
						currentDriver = t;
						break;
					}
					
				}
			}
			if(validate) {
				System.out.println("Login Successfull!");
				break;
			}else {
				System.out.println("Invalid Username or Password.");
			}
			
		}
		DisplayTaxiRideHistory(currentDriver);
		
	}
	
		public static void DisplayTaxiRideHistory(Taxi taxi) {
			System.out.println("---------------DISPLAYING TAXI RIDE HISTORY----------------\n\n");
			System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|%-10s|%-15s|", "CUSTOMER", "SOURCE", "DESTINATION", "PICK-UP TIME", "FAIR", "ZULA-COMMISSION"));
			System.out.println("--------------------------------------------------------------");
			for (Ride ride : taxi.rides) {
			    System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|%-10s|%-15s|", ride.customer.name, ride.source, ride.destination, ride.pickupTime, ride.fair, ride.commission));
			}
			System.out.println("\n");

		}
	
	
	
	public static void CustomerLogin(List<Customer> customerList, List<Taxi> taxiList ) {
		sc = new Scanner(System.in);
		String userName;
		int passwd;
		Customer currentCustomer = null;
		while(true) {
			System.out.println("Enter your User Name:");
			userName = sc.nextLine();
			System.out.println("Enter your Password:");
			passwd = Integer.parseInt(sc.nextLine());
			boolean validate = false;
			for(Customer c: customerList) {
				if(c.name.equals(userName)) {
					if(c.pass == passwd) {
						validate = true;
						currentCustomer = c;
						break;
					}
					
				}
			}
			if(validate) {
				System.out.println("Login Successfull!");
				break;
			}else {
				System.out.println("Invalid Username or Password.");
			}
		}
		while(true) {
			System.out.println("1.Book a Taxi\n2.View Ride History\n3.Exit");
			int op = Integer.parseInt(sc.nextLine());
			if(op == 1) {
				System.out.println("Enter Your Pick-Up Location");
				char source = sc.nextLine().charAt(0);
				System.out.println("Enter Your Destination");
				char destination = sc.nextLine().charAt(0);
				System.out.println("Enter the Pick-up Time");
				int pickUpTime = Integer.parseInt(sc.nextLine());
				AllocateTaxi(source,destination,pickUpTime,currentCustomer,taxiList);
			}else if(op == 2) {
				DisplayCustomerRideHistory(currentCustomer);	
			}else if(op == 3) {
				break;
			}else {
				System.out.println("Invalid Choice. Try again.");
			}
		} 
		
	}
	
	public static void DisplayCustomerRideHistory(Customer customer) {
		System.out.println("------------DISPLAYING CUSTOMER RIDE HISTORY---------------\n\n");
		System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|", "CUSTOMER", "TAXI", "SOURCE", "DESTINATION", "PICK-UP TIME", "FAIR"));
		System.out.println("--------------------------------------------------------------------------------------------");
		for (Ride ride : customer.rides) {
		    System.out.println(String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|", ride.customer.name, ride.taxi.name, ride.source, ride.destination, ride.pickupTime, ride.fair));
		}
		System.out.println("\n");

		
	}
	
	public static void ZulaAdmin(List<Taxi> taxiList,List<Customer> CustomerList) {
		sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("1.Taxi Ride History\n2.Customer Ride History\n3.Exit");
			int choice = Integer.parseInt(sc.nextLine());
			
			if(choice == 1) {
				System.out.println("Enter the Taxi Id");
				int taxiId = Integer.parseInt(sc.nextLine());
				boolean taxiFound = false;
				for(Taxi t: taxiList) {
					if(t.id == taxiId) {
						DisplayTaxiRideHistory(t);
						taxiFound = true;
						break;
					}
				}
				if(!taxiFound) {
					System.out.println("No taxi was found with ID : " + taxiId);
				}
				
			}else if(choice == 2) {
				System.out.println("Enter the Customer Id");
				int custId = Integer.parseInt(sc.nextLine());
				boolean customerFound = false;
				for(Customer c: CustomerList) {
					if(c.id == custId) {
						DisplayCustomerRideHistory(c);
						customerFound = true;
						break;
					}
				}
				if(!customerFound) {
					System.out.println("No Customer was found with ID : " + custId);
				}
			}else if(choice == 3){
				loop = false;
				break;
			}else {
				System.out.println("Invalid Choice. Try Again.");
			}
		}
		
		
		
	}
	
	
}
