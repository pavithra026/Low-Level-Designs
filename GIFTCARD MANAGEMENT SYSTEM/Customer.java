package pavithra;

import java.util.ArrayList;

public class Customer {
	int custId;
	String name;
	int accountNo;
	String password;
	double accountBalance;
	ArrayList<GiftCard> giftcards;
	
	public Customer(int custId, int accountNo ,String name ,double accountBalance, String password) {
		// TODO Auto-generated constructor stub
		this.custId = custId;
		this.name = name;
		this.accountNo = accountNo;
		this.password = password;
		this.accountBalance = accountBalance;
		this.giftcards = new ArrayList<GiftCard>();
	}
	
	public void displayGiftCards() {
		if(!giftcards.isEmpty()) {
			System.out.println("+--------------+------------+----------------+---------------+");
		    System.out.println("|  CARD NO     |  PIN NO    |  BALANCE       |STATUS");
		    System.out.println("+--------------+------------+----------------+---------------+");

		    for (GiftCard card : giftcards) {
		        String status = card.blocked ? "Blocked" : "In-Use";

		        System.out.println(String.format("| %-12s | %-10s | %-14s | %-13s |", card.cardNo, card.pinNo, card.balance, status));
		    }

		    System.out.println("+--------------+------------+----------------+---------------+");
		}else {System.out.println("No giftcard Available. Create Giftcards to TopUp.");}

	}
}




