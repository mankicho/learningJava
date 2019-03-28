package Main.java.bankbook.account.model;

public class Account {
    private int accountNumber;
    private String name;
    private double balance;

    public Account(){

    }

    public Account(int accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
    }

    public Account(int accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public boolean existAccount(){
        if(this.name == null || this.name ==""){
            System.out.println("계좌정보가 조회되지않습니다.");
            return false;
        }
        return true;
    }

    public String convertToString(){
        return accountNumber + "  " + name + "  " + balance;
    }
}
