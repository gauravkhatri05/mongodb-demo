package com.accolite.study.mongodb.repository;

import com.accolite.study.mongodb.model.domain.Product;

import java.util.List;

public interface ProductCustomRepository {

    List<Product> getAllProducts();
}
