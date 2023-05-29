package bank;

import java.util.Objects;

public class BankAccount {
    public int accountNumber;
    protected String accountType;
    private String accountHolder;
    private float accountBalance;
    private boolean accountStatus;

    public BankAccount() {
        this.setAccountBalance(0);
        this.setAccountStatus(false);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void openAccount(String type) {
        this.setAccountType(type);
        this.setAccountStatus(true);
        if (Objects.equals(type, "CC")) {
            this.setAccountBalance(getAccountBalance() + 50f);
            System.out.println("Parabéns! " + this.getAccountHolder() + ", Você acaba de abrir sua conta corrente e recebeu um bônus de R$50.");
        } else if (Objects.equals(type, "CP")) {
            this.setAccountBalance(getAccountBalance() + 150f);
            System.out.println("Parabéns! " + this.getAccountHolder() + ", Você acaba de abrir sua conta poupança e recebeu um bônus de R$150.");
        } else {
            this.setAccountStatus(false);
            System.out.println("Não entendi, por favor repita a operação.");
        }
    }

    public void closeAccount() {
        if (this.getAccountBalance() > 0 || this.getAccountBalance() < 0) {
            System.out.println("Não foi possível fechar a conta, por favor contate o banco através do SAC.");
        } else {
            this.setAccountStatus(false);
            System.out.println("Sua conta foi fechada.\nPoxa que pena! não vá embora assim de vez " + this.getAccountHolder() + "...");
        }
    }

    public void deposit(float add) {
        if (this.isAccountStatus() && add > 0) {
            this.setAccountBalance(getAccountBalance() + add);
            System.out.println("Transação completa, você depositou: R$" + add + ", tenha um bom dia!");
        } else {
            System.out.println("Transação impossibilitada, por favor contate o banco através do SAC.");
        }
    }

    public void withdraw(float remove) {
        if (this.isAccountStatus() && this.getAccountBalance() >= remove) {
            this.setAccountBalance(getAccountBalance() - remove);
            System.out.println("Saque efetuado, aproveite seu dinheiro como quiser!");
        } else {
            System.out.println("Operação incompleta, por favor apenas saque um valor igual ou menor que seu saldo, ou contate o banco através do SAC.");
        }
    }

    public void payMonthly() {
        float monthly;
        if (Objects.equals(this.getAccountType(), "CC")) {
            monthly = 12f;
            this.setAccountBalance(getAccountBalance() - monthly);
            System.out.println(this.getAccountHolder() + ", confirmamos o recebimento de R$12 da sua mensalidade.");
        } else if (Objects.equals(this.getAccountType(), "CP")) {
            monthly = 20f;
            this.setAccountBalance(getAccountBalance() - monthly);
            System.out.println(this.getAccountHolder() + ", confirmamos o recebimento de R$20 da sua mensalidade.");
        } else {
            System.out.println("Não entendi, por favor repita a operação.");
        }
    }


    public void seeAccount() {
        System.out.println("---------------\n" + this.getAccountNumber() + "\n" +
                this.getAccountType() + "\n" + this.getAccountHolder() +
                "\n" + this.getAccountBalance() + "\n" + this.isAccountStatus() +
                "\n---------------");
    }

}