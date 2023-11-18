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


/**************************************************************************************************************************************************************************
Question : Design a simple Gift Card Management System which you can gift to any one to make Purchase

There are Three bank account pre coded in as customers namely

CustId,  Acc No,    Name,      Balance,    Encrypted Password
11,      11011,    "Kumar",    10000,      "ApipNbjm"   --------------------> ZohoMail
22,      22022,    "Madhu",    20000,      "Cboljoh"    --------------------> Banking
33,      33033,    "Robin",    30000,      "kbwb22"    --------------------> java11

you have to create a  system where
1. Account Login
2.  Purchase      -- will be shown as options


1. Account Login
    Now Login to your account and enter your Customer Id And Password
    
    Password encryption : 0->1,1->2,2->3......9->0  || a->b,b->c......z->a   || A>B,B->C......Z->A
    
    
    1.Create new Gift Card
    2.Top up existing Gift Card
    3.Show Gift Card Transactions
    4.Block a existing Gift Card
    5.Logout
    
    
    1.Create new Gift Card
    now generate a gift card with 5 digits and its pin of four digits --> should be able to create N number of Gift cards as poosible
    
    2.Top up existing Gift Card
    top up existing card using the balance in your account
    
    3.Show Gift Card Transactions
    print all available Gift card Transactions
    (Like credit ,debit, balance )
    
    4.Block a existing Gift Card
    block the card and return back the amount to the account
    
    5. Logout

2.Purchase

   Get Gift Card Id
   Get Gift Card Pin
   Get Bill Amount
  
   Deduct the bill amount from the gift card and updtae the balance in the gift card
  
   if Bill amount is greater than Rs.100
   add a reward point to the gift card and redeem the amount to balance if reward points is 10 ( 1 reward point is 1 rupee )
  
  
Apply this for various Bank Accounts and check the details

*****************************************************************************************************************************************************/


