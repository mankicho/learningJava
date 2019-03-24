package Main.java.bankbook.account;

public class Account {
    private String id;
    private String name;
    private double balance;
    private int accountNumber;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(){

    }


    public Account(String id, String name, int accountNumber){
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;

    }

    public Account(String id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String convertToDataFile(){
        return id + " " + name + " " + balance + " " + accountNumber;
    }
}
