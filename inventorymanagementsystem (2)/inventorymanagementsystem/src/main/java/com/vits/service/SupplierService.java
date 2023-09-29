package com.vits.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.entity.Supplier;
import com.vits.repository.SupplierRepository;

@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Optional<Supplier> existingSupplier = supplierRepository.findById(id);
        if (existingSupplier.isPresent()) {
            updatedSupplier.setId(id); // Make sure you have a setId method in your Supplier entity
            return supplierRepository.save(updatedSupplier);
        } else {
            return null;
        }
    }

    public boolean deleteSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id); // Correct the variable name here
        if (supplier.isPresent()) {
            supplierRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
