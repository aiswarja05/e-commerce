package com.example.assignment1.controllers;

import com.example.assignment1.models.Pageable;
import com.example.assignment1.models.Response;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BaseController<S,T> {
    ResponseEntity<Response<S>> findById(Long id);

    //ResponseEntity<?> findAll(Specification<T> specification, Pageable pageable);
    ResponseEntity<?> findAll();

    ResponseEntity<Response<S>> save(T param);
    ResponseEntity<Response<S>> update(Long id, T param);
    ResponseEntity<Response> deleteById(Long id);
}
