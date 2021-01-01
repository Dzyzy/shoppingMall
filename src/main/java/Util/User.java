package Util;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;

    public User(int id, String name, String password, String email) {
        this.user_id = id;
        this.user_name = name;
        this.user_password = password;
        this.user_email = email;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public String getPassword() {
        return user_password;
    }

    public void setPassword(String password) {
        this.user_password = password;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }

    public int getId() {
        return user_id;
    }

    public String getName() {
        return user_name;
    }
}
