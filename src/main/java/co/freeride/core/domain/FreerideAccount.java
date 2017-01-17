package co.freeride.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * @version 1.0.0
 * @author Greg Price - Created on 1/15/17.
 * The {@code FreerideAccount} is the base account for all
 * Freeride users.
 */

@Document
public class FreerideAccount {

    @Id
    private BigInteger id;
    private String email;

    public FreerideAccount(String email) {
        this.email = email;
    }

    public BigInteger getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FreerideAccount [id=" + this.id + ", email=" + email + "]";
    }
}
