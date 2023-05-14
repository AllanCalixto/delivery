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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    public ResponseEntity<Customer> save(@RequestBody @Valid CustomerDto customerDto) {
        if (!customerService.existsByEmail(customerDto.getEmail())) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict: Email is already in use!");
}
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!");
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Customer> update(@PathVariable("id") Long id, @RequestBody @Valid CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setId(customerOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customer));
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!");
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            customerService.delete(customerOptional.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!");
    }
}
