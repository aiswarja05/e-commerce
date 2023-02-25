package com.example.assignment1.services.impl;

import com.example.assignment1.models.Customer;
import com.example.assignment1.repository.CustomerRepository;
import com.example.assignment1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> findAll(Specification<Customer> specification, Pageable pageable) {
        return customerRepository.findAll(specification, pageable);
    }

    @Override
    public List<Customer> findAll(Specification<Customer> specification, Sort sort) {
        return customerRepository.findAll(specification, sort);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(customerRepository.findById(id).get());
    }

    @Override
    public Optional<Customer> save(Customer obj) {
        return Optional.of(customerRepository.save(obj));
    }

    @Override
    public Optional<Customer> update(Long id, Customer obj) {
        obj.setId(id);
        return Optional.of(customerRepository.save(obj));
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
    }
}
