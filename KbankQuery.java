package kbank;

import javax.swing.JOptionPane;

public class KbankQuery {

    public void action(KbankAccount currentUser, KbankAccount otherUser) {
        String[] choices = {"Deposit", "Withdraw", "Check Balance", "Transfer", "Log Out"};
        String input;

        do {
            input = (String) JOptionPane.showInputDialog(
                    null,
                    "Current balance: $" + currentUser.getBalance(),
                    "Action Panel - " + currentUser.getOwner(),
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]
            );

            switch (input) {
                case "Deposit":
                    String depositStr = JOptionPane.showInputDialog(null, "How much to deposit?");
                    currentUser.deposit(Double.parseDouble(depositStr));
                    break;

                case "Withdraw":
                    String withdrawStr = JOptionPane.showInputDialog(null, "How much to withdraw?");
                    if (!currentUser.withdraw(Double.parseDouble(withdrawStr))) {
                        JOptionPane.showMessageDialog(null, "Overdraft limit exceeded.");
                    }
                    break;

                case "Check Balance":
                    JOptionPane.showMessageDialog(null, "Balance: $" + currentUser.getBalance());
                    break;

                case "Transfer":
                    String transferStr = JOptionPane.showInputDialog(null, "How much to transfer?");
                    double amount = Double.parseDouble(transferStr);
                    if (currentUser.transfer(otherUser, amount)) {
                        JOptionPane.showMessageDialog(null, "Transfer successful.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Transfer failed. Not enough funds.");
                    }
                    break;

                case "Log Out":
                case null:
                    JOptionPane.showMessageDialog(null, "Logged out!");
                    return;

                    
                default:
                    break;
            }

        } while (input != null && !input.equals("Quit"));
    }
}
