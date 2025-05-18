package kbank;

import javax.swing.JOptionPane;

public class Kbank_Main {

	public static void main(String[] args) {
		KbankLogin log = new KbankLogin();
		KbankQuery que = new KbankQuery();
		
		que.action();
		log.logIn();

		
		
		
	}

}
