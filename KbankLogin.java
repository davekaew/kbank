package kbank;

import javax.swing.JOptionPane;

public class KbankLogin {
	
	public void logIn( ) {
		
		String logIn = "Please enter your password";
		String welcome = "Welcome to Kasikorn Bank";
		String canceled = "User canceled";
		String password = "DD";
		int count = 3;
		
		KbankQuery que = new KbankQuery();
		
		do {
			String input = JOptionPane.showInputDialog(null, logIn, "Log In", 
					JOptionPane.QUESTION_MESSAGE);
			
			if (input == null) {
				
				JOptionPane.showMessageDialog(null, canceled, "Good bye", 
						JOptionPane.CLOSED_OPTION);
				break;
				
			}  
			
			if (input.equals(password)) {
				JOptionPane.showMessageDialog(null, welcome, "Welcome", 
						JOptionPane.PLAIN_MESSAGE);
				que.action();
				//If correct break the loop
				break;
				
			} else {
				//if password is incorrect the attempts go down and prompt the user to try again
				count--;
				JOptionPane.showMessageDialog(null, "You enter the wrong pass word \nAttempts left: " 
				+ count , "Wrong password", JOptionPane.ERROR_MESSAGE);
			}
			//while user still have attempts 
					} while (count > 0); 
					
					//if user ran out of attempts locks user out
					if (count == 0) {
						
						JOptionPane.showMessageDialog(null, "You have 0 attempts left, goodbye" 
								, "Wrong password", JOptionPane.ERROR_MESSAGE);

					}
					
		}
	
}
