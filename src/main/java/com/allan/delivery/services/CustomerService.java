package com.allan.delivery.services;

import com.allan.delivery.model.Customer;
import com.allan.delivery.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
