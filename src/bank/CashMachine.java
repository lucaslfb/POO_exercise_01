package bank;

public class CashMachine {
    public static void main(String[] args) {
        BankAccount ac001 = new BankAccount();

        ac001.setAccountNumber(1111);
        ac001.setAccountHolder("Jubileu");
        ac001.openAccount("CC");

        ac001.seeAccount();
    }
}
