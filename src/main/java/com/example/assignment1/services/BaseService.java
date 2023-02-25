package com.example.assignment1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<T> {
    Page<T> findAll(Specification<T> specification, Pageable pageable);
    List<T> findAll(Specification<T> specification, Sort sort);
    List<T> findAll();
    Optional<T> findById(Long id);
    Optional<T> save(T obj);
    Optional<T> update(Long id, T obj);
    void deleteById(Long id);

}
