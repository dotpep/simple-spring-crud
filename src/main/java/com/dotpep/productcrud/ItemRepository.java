package com.dotpep.productcrud;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dotpep.productcrud.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

}
