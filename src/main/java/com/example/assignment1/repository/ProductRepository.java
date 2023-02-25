package com.example.assignment1.repository;

import com.example.assignment1.models.Customer;
import com.example.assignment1.models.Product;
import com.example.assignment1.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long>{

}

