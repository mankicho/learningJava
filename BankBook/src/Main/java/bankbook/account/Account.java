package Main.java.bankbook.account;

public class Account {
    private String id;
    private String name;
    private String balance;


    public Account(){

    }

    public Account(String id, String name, String balance){
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String convertToDataFile(){
        return id + " " + name;
    }
}
