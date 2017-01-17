package co.freeride.core.interfaces;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @version 1.0.0
 * @author Greg Price - Created on 1/15/17.
 * The {@code FreerideRepository} is the base interface for all
 * of the freeride mongodb repositories.
 */

@NoRepositoryBean
public interface FreerideRepository<T> extends MongoRepository<T, String>, QueryDslPredicateExecutor<T> {
}
