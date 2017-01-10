package freeride.co.factories;

/**
 * Created by Greg on 1/6/17.
 */

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoFactory {

    private static MongoOperations ops;
    
    public static MongoOperations operations() {
        if (ops == null) {
            ops = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "test"));
        }
        return ops;
    }

}

