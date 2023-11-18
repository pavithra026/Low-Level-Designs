package pavithra;

import java.util.List;

public class EncryptPassword {

	
		public Customer login(int accountNo, String password, List<Customer> customers) {
			
			String encryptedPass = "";
			for(char c: password.toCharArray()) {
				if(Character.isAlphabetic(c)) {
					if(Character.isUpperCase(c)) {
						int Ch = (((((int)c) - 65)+ 1 + 26)% 26)+ 65;
						encryptedPass += (char)Ch;
					}
					if(Character.isLowerCase(c)) {
						int ch = (((((int)c) - 97)+1 + 26)% 26)+ 97;
						encryptedPass += (char)ch;
					}

						
				 }else if(Character.isDigit(c)) {
						int n = ((c-'0') + 1)%10;
						encryptedPass += Integer.toString(n);
				}
			}
			
			for(Customer c: customers) {
				if(accountNo == c.accountNo && encryptedPass.equals(c.password)) {
					return c;
				}
			}
			
			return null;
		}
		
		public Customer getCurrentCustomer(List<Customer> customers, int accountNo) {
			for(Customer customer: customers) {
				if(customer.accountNo == accountNo) {
					return customer;
				}
			}
			return null;
		}
}

/*
int Ch = (((((int)'B') - 65)+ 1)% 26)+ 65;
int ch = (((((int)'b') - 97)+ 1)% 26)+ 97;
int n = (9 + 1)%10;
System.out.print((char)Ch);
System.out.println((char)ch);
System.out.print(n);
*/