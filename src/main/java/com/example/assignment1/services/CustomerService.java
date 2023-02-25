package com.example.assignment1.services;

import com.example.assignment1.models.Customer;
import org.springframework.stereotype.Repository;

public interface CustomerService<T extends Customer> extends BaseService<T>{
}
