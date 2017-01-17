package co.freeride.core;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

@Configuration
public class CoreConfiguration {

    public @Bean MongoClientFactoryBean mongo() throws UnknownHostException {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    public @Bean PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
