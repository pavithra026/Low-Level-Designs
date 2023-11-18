package pavithra;

public class GiftCardActivity {
	
	
	public String createGiftCard(Customer c) {
		if(c == null) {
			return ("Error can't create Giftcard");
		}
		GiftCard card = new GiftCard();
		c.giftcards.add(card);
		return ("Gift Card Created Successfully");
	}
	
	
	public String topUp(double amount, int gNo, int gPinNo, Customer c) {
		for(GiftCard card: c.giftcards) {
			System.out.println(card.blocked);
				if(gNo == card.cardNo && gPinNo == card.pinNo) {
					if(!card.blocked) {
						card.balance += amount;
						card.transactionHistory.add(new Transaction("Credited", amount, card));
						return "TopUp amount is Now Added to your Giftcard.";
					}else return "This Card is blocked and cannot be ToppedUp";
					
				}
		}
		
		return "GiftCard Number/PinNo didn't Match. Try Again";
		
	}
	
	public void displayGiftCardTransaction(int cardNo, Customer cust) {
		GiftCard card = null;
		for(GiftCard c : cust.giftcards) {
			if(cardNo == c.cardNo) {
				card = c;
			}
		}
		if(card != null) {
			System.out.println("Displaying Transaction History of GiftCard Number : " + card.cardNo + " Status :" + (card.blocked ? "Blocked" : "In-Use"));
			System.out.println("-------------------");
			for(Transaction t: card.transactionHistory) {
				t.displayTransaction();
			}
			System.out.println("-------------------");
		}else System.out.println("Invalid CardNo.");//---------------!
		
	}
	
	public String block(int cardNo, Customer c) {
		for(GiftCard card: c.giftcards) {
			if(cardNo == card.cardNo && !card.blocked) {
				card.blocked = true;
				c.accountBalance += card.balance;
				card.balance = 0.0;
				return "Gift card has been Blocked.";
			}
			
		}
		return "Invalid Card No or GiftCard is already blocked.";
	}
	
	public void purchase(int cardNo, int pinNo, double billAmount) {
		
	}

}
