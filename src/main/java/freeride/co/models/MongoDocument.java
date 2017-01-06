package freeride.co.models;

/**
 * Created by Greg on 1/6/17.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.math.BigInteger;
import java.util.List;

@Document()
public abstract class MongoDocument implements MongoInterface {
    @Id
    private BigInteger id;
}

interface MongoInterface extends MongoRepository<MongoDocument, String> {
    default List<MongoDocument> findAll() { return null; };
    default MongoDocument findOne(String userId) { return null; };
}