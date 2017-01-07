package freeride.co.interfaces;

/**
 * Created by Greg on 1/6/17.
 */

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public interface MongoFactory {
    default MongoOperations operations() { return new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "test")); }
}
