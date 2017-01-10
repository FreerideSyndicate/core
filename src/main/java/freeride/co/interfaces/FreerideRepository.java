package freeride.co.interfaces;

/**
 * Created by Greg on 1/9/17.
 */

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.mongodb.repository.MongoRepository;

@NoRepositoryBean
public interface FreerideRepository<T> extends MongoRepository<T, String>, QueryDslPredicateExecutor<T> {
}
