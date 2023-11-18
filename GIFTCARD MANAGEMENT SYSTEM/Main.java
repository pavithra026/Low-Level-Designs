package pavithra;
import java.util.*;
public class index {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop;
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(11,11011,"Kumar",10000,"ApipNbjm" ));
		customers.add(new Customer(22,22022,"Madhu",20000,"Cboljoh" ));
		customers.add(new Customer(33,33033,"Robin",30000,"kbwb22" ));
		
		List<GiftCard> giftcards = new ArrayList<>();

		GiftCardActivity gca = new GiftCardActivity();
		EncryptPassword encrypt = new EncryptPassword();
		
		//methods
        
		loop = true;
		while(loop) {
			System.out.println("1.Account Login\n2.Purchase\n3.Exit");
	        int c1 = Integer.parseInt(sc.nextLine());
	        
	        switch(c1) {
	        case 1:
	        	boolean loggedIn = false;
	        	Customer currentCustomer= null;
	        	while(!loggedIn) {
	        		
	        		System.out.println("Enter your Account No:");
		        	int accountNo = Integer.parseInt(sc.nextLine());
		        	System.out.println("Enter your Password:");
		        	String password = sc.nextLine();
		        	
		        	currentCustomer = encrypt.login(accountNo, password, customers);
		        	if(currentCustomer != null) {
		        		System.out.println("Login Success!");
		        		loggedIn = true;
		        	}else {
		        		System.out.println("Invalid Account Number or Password. Try Again");
		        	}
	        	}
	        	
	        	while(loggedIn) {
	        		System.out.println("1.Create new Gift Card\n2.Top up existing Gift Card\n3.Show Gift Card Transactions\n4.Block a existing Gift Card\n5.Logout");
	        		int c2 = Integer.parseInt(sc.nextLine());
	        		
	        		switch(c2) {
            		
            		case 1:
            			if(currentCustomer != null) {
            				GiftCard card = new GiftCard();
            				currentCustomer.giftcards.add(card);
            				giftcards.add(card);
            				System.out.println("Gift Card created Successfully.");
            			}else System.out.println("Something went wrong! Can't create GiftCard.");
            			break;
            		case 2:
            			currentCustomer.displayGiftCards();
            			if(!currentCustomer.giftcards.isEmpty()) {
            				System.out.println("Enter The Giftcard Number:");
                			int cn1 = Integer.parseInt(sc.nextLine());
                			System.out.println("Enter The Giftcard Pin Number:");
                			int pinNo = Integer.parseInt(sc.nextLine());
                			System.out.println("Enter The Top Up Amount");
                			double topUp = Double.parseDouble(sc.nextLine());
                			System.out.println(gca.topUp(topUp, cn1, pinNo, currentCustomer));
            			}
            			break;
            		case 3:
            			System.out.println("Enter The Giftcard Number:");
            			int cn2 = Integer.parseInt(sc.nextLine());
            			gca.displayGiftCardTransaction(cn2,currentCustomer);
            			break;
            		case 4:
            			System.out.println("Enter The Giftcard Number:");
            			int cn3 = Integer.parseInt(sc.nextLine());
            			System.out.println(gca.block(cn3, currentCustomer));
            			break;
            		case 5:
            			loggedIn = false;
            			break;
            			
            			
            		}
	        	}
	        	
	        	
	        	break;
	        case 2:
	        	System.out.println("Enter Giftcard No:");
	        	int cn3 = Integer.parseInt(sc.nextLine());
	        	System.out.println("Enter Giftcard PinNo:");
	        	int pinNo2 = Integer.parseInt(sc.nextLine());
	        	System.out.println("Enter the Bill Amount:");
	        	double amt = Double.parseDouble(sc.nextLine());

	        	
	        	boolean gno = false, pno = false;
	        	
	        	for(GiftCard g: giftcards) {
	        		if(cn3 == g.cardNo) {
	        			gno = true;
	        			if(pinNo2 == g.pinNo) {
	        				pno = true;
	        				if(!g.blocked) {
	        					if(g.balance >= amt) {
		        					g.balance -= amt;
		        					System.out.println("Purchase Success!");
			        				if(amt >= 100) {
			        					g.rewardPoints++;
			        				}
			        				if(g.rewardPoints >= 10) {
			        					g.balance += g.rewardPoints;
			        					g.rewardPoints = 0;
			        					System.out.println("Reward Points for purchase amount has been redeemed to your giftcard Balance.");
			        					System.out.println("Giftcard balance: " + g.balance);
			        				}
			        				
			        				g.transactionHistory.add(new Transaction("Debited", amt, g));
			        				
		        				}else System.out.println("Insufficient balance.");
	        				}else System.out.println("This giftcard is Blocked. Purchase Failed.");
	        				
	        			} 
	        		}
	        	}
	        	
	        	if(!gno) {
	        		System.out.println("Invalid Giftcard Number");
	        	}else if(!pno) {
	        		System.out.println("Invalid Giftcard Pin Number");
	        	}
	        	
	        	
	        	break;
	        case 3:
	        	loop = false;
	        	break;
	        default:
	        	System.out.println("---------------------------INVALID OPTION----------------------------");
	        	
	        }
		}
        
      sc.close();  
    }
}

