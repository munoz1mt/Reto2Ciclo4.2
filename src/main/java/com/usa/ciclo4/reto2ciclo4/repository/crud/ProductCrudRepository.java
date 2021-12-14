package com.usa.ciclo4.reto2ciclo4.repository.crud;

import com.usa.ciclo4.reto2ciclo4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Sebastian
 */
public interface ProductCrudRepository extends MongoRepository<Product, String> {
    
}
