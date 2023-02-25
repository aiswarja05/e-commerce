package com.example.assignment1.repository;

import com.example.assignment1.models.Product;
import com.example.assignment1.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends BaseRepository<Purchase, Long>{

}

