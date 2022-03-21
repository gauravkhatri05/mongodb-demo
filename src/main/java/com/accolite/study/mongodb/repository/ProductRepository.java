package com.accolite.study.mongodb.repository;

import com.accolite.study.mongodb.model.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long>, ProductCustomRepository {
}
