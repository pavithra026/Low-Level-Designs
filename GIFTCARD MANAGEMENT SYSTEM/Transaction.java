package pavithra;

public class Transaction {
	
	GiftCard card;
	String message;
	double amount;
	
	Transaction(String message, double amount, GiftCard card){
		this.message = message;
		this.amount = amount;
		this.card = card;
	}
	
	public void displayTransaction() {
		System.out.println("|" + message + "  |  " + amount + "|");
	}

}
