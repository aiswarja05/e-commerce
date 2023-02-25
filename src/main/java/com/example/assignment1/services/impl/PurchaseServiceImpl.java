package com.example.assignment1.services.impl;

import com.example.assignment1.models.Purchase;
import com.example.assignment1.repository.PurchaseRepository;
import com.example.assignment1.services.PurchaseService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService<Purchase> {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Page<Purchase> findAll(Specification<Purchase> specification, Pageable pageable) {
        return purchaseRepository.findAll(specification, pageable);
    }

    @Override
    public List<Purchase> findAll(Specification<Purchase> specification, Sort sort) {
        return purchaseRepository.findAll(specification, sort);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return Optional.of(purchaseRepository.findById(id).get());
    }

    @Override
    public Optional<Purchase> save(Purchase obj) {
        return Optional.of(purchaseRepository.save(obj));
    }

    @Override
    public Optional<Purchase> update(Long id, Purchase obj) {
        obj.setId(id);
        return Optional.of(purchaseRepository.save(obj));
    }

    @Override
    public void deleteById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).get();
        purchaseRepository.delete(purchase);
    }

}
