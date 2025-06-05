package kbank;

public class Kbank_Main {
    public static void main(String[] args) {
        KbankAccount dunn = new KbankAccount("Dunn", 500);
        KbankAccount dave = new KbankAccount("Dave", 1000);
        KbankQuery query = new KbankQuery();

        KbankLogin login = new KbankLogin(dunn, dave, query);

        while (login.count != -1) {
            login.logIn();  // This reuses existing Dunn and Dave accounts
        }
    }
}
