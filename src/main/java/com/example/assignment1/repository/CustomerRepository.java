package com.example.assignment1.repository;

import com.example.assignment1.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
    boolean existsById(Long id);
}

