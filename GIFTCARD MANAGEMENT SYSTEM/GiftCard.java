package pavithra;

import java.util.*;
public class GiftCard {
	int cardNo;
	int pinNo;
	double balance;
	boolean blocked;
	int rewardPoints;
	ArrayList<Transaction> transactionHistory;
	GiftCard(){
		Random random = new Random();
		this.cardNo = random.nextInt(100000);
		this.pinNo = random.nextInt(10000);
		this.balance = 0;
		this.rewardPoints = 0;
		this.transactionHistory = new ArrayList<>();
		blocked = false;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
