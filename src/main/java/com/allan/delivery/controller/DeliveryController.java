package com.allan.delivery.controller;

import com.allan.delivery.dtos.DeliveryDto;
import com.allan.delivery.model.Delivery;
import com.allan.delivery.services.DeliveryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @GetMapping
    public ResponseEntity<List<Delivery>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.findAll());
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Delivery> save(@RequestBody @Valid DeliveryDto deliveryDto){
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(deliveryDto, delivery);
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.save(delivery));
    }
}
