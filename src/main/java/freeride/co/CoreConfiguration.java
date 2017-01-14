package freeride.co;

import java.net.UnknownHostException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import static freeride.co.concurrency.SpringExtension.SPRING_EXTENSION_PROVIDER;
import akka.actor.ActorSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

/**
 * Created by Greg on 1/6/17.
 */

@Configuration
@ComponentScan
public class CoreConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    public @Bean MongoClientFactoryBean mongo() throws UnknownHostException {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    public @Bean PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    public @Bean ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("Core-Akka");
        SPRING_EXTENSION_PROVIDER.get(system)
                .initialize(applicationContext);
        return system;
    }
}
