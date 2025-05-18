package kbank;

import javax.swing.JOptionPane;

public class KbankQuery {
	
	int balance = 500;
	int overdraftLimit = -100;
	String deposit = "How much would you like to deposit";
	String withdraw = "How much would you like to withdraw";
	String checkBalance = "Your balance is " + balance;
	
	public void deposit() {
		
		String input = JOptionPane.showInputDialog(null, deposit, "Deposit", 
				JOptionPane.QUESTION_MESSAGE);
		double userInput = Double.parseDouble(input);
				balance += userInput;
				JOptionPane.showMessageDialog(null, "Your available balance is " + balance);
		
	}
	
	public void withdraw() {
		
		String input = JOptionPane.showInputDialog(null, withdraw, "Withdraw", 
				JOptionPane.QUESTION_MESSAGE);
		double userInput = Double.parseDouble(input);
		if (balance - userInput < overdraftLimit) {
			JOptionPane.showMessageDialog(null, "Transaction denied. Withdrawal would exceed your overdraft limit of $" + overdraftLimit);
		} else {
			balance -= userInput;
			JOptionPane.showMessageDialog(null, "Withdrawal successful. Your new balance is $" + balance);
		}
		
	}
	
	public void checkBalance() {
		JOptionPane.showMessageDialog(null, "Your balance is " + balance);
	}

}
