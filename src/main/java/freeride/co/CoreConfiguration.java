package freeride.co;

import java.net.UnknownHostException;

import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

/**
 * Created by Greg on 1/6/17.
 */

@Configuration
public class CoreConfiguration {
    public @Bean MongoClientFactoryBean mongo() throws UnknownHostException {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        ServerAddress[] replicaSetSeeds = {new ServerAddress("mongodb://ec2-34-195-193-52.compute-1.amazonaws.com:27017"), new ServerAddress( "ec2-54-146-19-176.compute-1.amazonaws.com:27017,ec2-54-198-212-93.compute-1.amazonaws.com:27017")};
        mongo.setReplicaSetSeeds(replicaSetSeeds);
        return mongo;
    }
}
