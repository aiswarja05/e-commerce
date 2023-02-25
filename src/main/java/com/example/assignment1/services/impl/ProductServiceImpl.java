package com.example.assignment1.services.impl;

import com.example.assignment1.models.Customer;
import com.example.assignment1.models.Product;
import com.example.assignment1.repository.ProductRepository;
import com.example.assignment1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(Specification<Product> specification, Pageable pageable) {
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public List<Product> findAll(Specification<Product> specification, Sort sort) {
        return productRepository.findAll(specification, sort);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(productRepository.findById(id).get());
    }

    @Override
    public Optional<Product> save(Product obj) {
        return Optional.of(productRepository.save(obj));
    }

    @Override
    public Optional<Product> update(Long id, Product obj) {
        obj.setId(id);
        return Optional.of(productRepository.save(obj));
    }

    @Override
    public void deleteById(Long id) {
        Product customer = productRepository.findById(id).get();
        productRepository.delete(customer);
    }
}
