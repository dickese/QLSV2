package pojo;

public class Account {
    private String id;
    private String username;
    private String password;
    private int role;


    public Account(String id, String username, String password, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public int getRole() {
        return role;
    }


    public void setRole(int role) {
        this.role = role;
    }
}
