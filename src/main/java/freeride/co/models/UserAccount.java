package freeride.co.models;

/**
 * Created by Greg on 1/5/17.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document()
public class UserAccount {
    @Id
    private BigInteger id;
}
