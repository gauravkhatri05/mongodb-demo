package com.accolite.study.mongodb.service;

import com.accolite.study.mongodb.exception.ResourceNotFoundException;
import com.accolite.study.mongodb.model.domain.Product;
import com.accolite.study.mongodb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

        Optional<Product> productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {

            Product productUpdate = productDb.get();

            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());

            this.productRepository.save(productUpdate);

            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional<Product> productDb = this.productRepository.findById(productId);

        if (!productDb.isPresent()) throw new ResourceNotFoundException("Record not found with id : " + productId);

        return productDb.get();
    }

    @Override
    public void deleteProduct(long productId) {

        Optional<Product> productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {

            this.productRepository.delete(productDb.get());
        } else {

            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }
}
