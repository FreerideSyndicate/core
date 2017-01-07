package freeride.co.models;

/**
 * Created by Greg on 1/6/17.
 */

public class FreerideAccount {

    private String id;
    private String email;

    public FreerideAccount(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "FreerideAccount [id=" + id + ", email=" + email + "]";
    }
}
