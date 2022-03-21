package com.accolite.study.mongodb.repository;

import com.accolite.study.mongodb.model.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
