package com.allan.delivery.controller;

import com.allan.delivery.dtos.CustomerDto;
import com.allan.delivery.model.Customer;
import com.allan.delivery.services.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Customer> save(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!");
    }
}
