package kbank;

import javax.swing.JOptionPane;

public class KbankLogin {

    private final KbankAccount Dunn;
    private final KbankAccount Dave;
    private final KbankQuery query;
    private String DunnPass = "0";
    private String DavePass = "0";
    
    int count = 3;

    public KbankLogin(KbankAccount dunn, KbankAccount dave, KbankQuery query) {
        this.Dunn = dunn;
        this.Dave = dave;
        this.query = query;
    }


    public void logIn() {
        String logInMsg = "Please enter your username";
        String welcome = "Welcome to Kasikorn Bank";
        String canceled = "User canceled";

        

        do {
            String input = JOptionPane.showInputDialog(null, logInMsg, "LOG IN", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, canceled, "Good bye", JOptionPane.CLOSED_OPTION);
                break;
            }

            if (input.equals("Dunn")) {
            	logInMsg = "Please enter your password";
            	input = JOptionPane.showInputDialog(null, logInMsg, "LOG IN", JOptionPane.QUESTION_MESSAGE);
            		if (input.equals(DunnPass)) {
            			count = 3; //reset attempt count if login successful
            			JOptionPane.showMessageDialog(null, welcome, "Welcome Dunn", JOptionPane.PLAIN_MESSAGE);
                        query.action(Dunn, Dave); //this log in as Dunn
                        break;
            		}
            	
            }

            if (input.equals("Dave")) {
            	logInMsg = "Please enter your password";
            	input = JOptionPane.showInputDialog(null, logInMsg, "LOG IN", JOptionPane.QUESTION_MESSAGE);
                	if (input.equals(DavePass)) {
                		count = 3; //reset attempt count if login successful
		            	JOptionPane.showMessageDialog(null, welcome, "Welcome Dave", JOptionPane.PLAIN_MESSAGE);
		                query.action(Dave, Dunn); //this log in as Dave
		                break;
                	}
            }

            count--;
            logInMsg = "Please enter your username"; //start over if input unregistered username or password
            JOptionPane.showMessageDialog(null, "Wrong password\nAttempts left: " + count, "Error", JOptionPane.ERROR_MESSAGE);
            
            if (count == 0) {
            	resetPassword();
            
            }
            
        } while (count >= 0);
    }


	private void resetPassword() {
		String input;
		String[] choices = {"Dunn","Dave","None"};
		String pr = "PASSWORD RESET";
		do {
			input = (String) JOptionPane.showInputDialog(
	                null,
	                "Which User do you wish to reset password?",
	                pr,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                choices,
	                choices[0]
	                );
			
			switch (input) {
			case "Dunn":
				input = JOptionPane.showInputDialog(null, "What is your favorite color?", pr, JOptionPane.QUESTION_MESSAGE);
				if (input.toLowerCase().equals("black")) {
					JOptionPane.showMessageDialog(null, "SUCCESS", "", JOptionPane.PLAIN_MESSAGE);
					input = JOptionPane.showInputDialog(null, "NEW PASSWORD", "Enter your new password", JOptionPane.QUESTION_MESSAGE);
					DunnPass = input;
					JOptionPane.showMessageDialog(null, "Your new password is: " + input, "NEW PASSWORD", JOptionPane.PLAIN_MESSAGE);
					count = 3;
					break;
				}
			case "Dave":
				input = JOptionPane.showInputDialog(null, "What is your favorite color?", pr, JOptionPane.QUESTION_MESSAGE);
				if (input.toLowerCase().equals("black")) {
					JOptionPane.showMessageDialog(null, "SUCCESS", "", JOptionPane.PLAIN_MESSAGE);
					input = JOptionPane.showInputDialog(null, "NEW PASSWORD", "Enter your new password", JOptionPane.QUESTION_MESSAGE);
					DavePass = input;
					JOptionPane.showMessageDialog(null, "Your new password is: " + input, "NEW PASSWORD", JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}
			break;
					
		} while (input != null && !input.equals("None"));
	}
}
