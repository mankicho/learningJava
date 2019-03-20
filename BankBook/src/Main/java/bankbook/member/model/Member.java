package Main.java.bankbook.member.model;

public class Member {
    private String id;
    private String password;
    private String name;

    public Member() {

    }

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    // Private 을 쓰는이유
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean existMember() {
        if (this.id == null || this.id.equals("")) {
            return false;
}
        return true;
                }
}
