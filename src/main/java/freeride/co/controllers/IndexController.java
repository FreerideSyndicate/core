package freeride.co.controllers;

/**
 * Created by Greg on 12/20/16.
 */

import freeride.co.interfaces.MongoFactory;
import freeride.co.models.FreerideAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.MongoClient;

@RestController
public class IndexController implements MongoFactory {

    private static final Log log = LogFactory.getLog(IndexController.class);

    @GetMapping("/")
    public String index() {
        MongoOperations mongoOps = operations();
        mongoOps.insert(new FreerideAccount("Joe@freeride.co"));
        log.info(mongoOps.findOne(new Query(where("email").is("Joe@freeride.co")), FreerideAccount.class));
        mongoOps.dropCollection("freerideAccount");
        return "ping";
    }
}
