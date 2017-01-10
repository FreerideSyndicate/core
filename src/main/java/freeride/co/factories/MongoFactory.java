package freeride.co.factories;

/**
 * Created by Greg on 1/6/17.
 */

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public final class MongoFactory {

    private MongoOperations ops;

    public MongoOperations operations() {
        if (ops == null) {
            ops = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "test"));
        }
        return ops;
    }

}

