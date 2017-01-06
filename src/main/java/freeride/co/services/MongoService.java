package freeride.co.services;

/**
 * Created by Greg on 1/5/17.
 */

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

interface Mongo<T> {
    default boolean save(T document) {return false;};
    default boolean create(T document) {return false;};
    default boolean findOneAndUpdate(T query, ArrayList<T> fields) {return false;};
    default T find(T query) {return null;};
    default boolean findOneAndRemove(T query) {return false;};
}

@Service
public class MongoService {

}
