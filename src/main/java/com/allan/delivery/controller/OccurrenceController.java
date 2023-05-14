package com.allan.delivery.controller;

import com.allan.delivery.dtos.OccurrenceDto;
import com.allan.delivery.model.Occurrence;
import com.allan.delivery.services.OccurrenceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("occurrence")
public class OccurrenceController {
    @Autowired
    private OccurrenceService occurrenceService;

    @GetMapping
    public ResponseEntity<List<Occurrence>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(occurrenceService.findAll());
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Occurrence> save(@RequestBody @Valid OccurrenceDto occurrenceDto) {
        Occurrence occurrence = new Occurrence();
        BeanUtils.copyProperties(occurrenceDto, occurrence);
        return ResponseEntity.status(HttpStatus.CREATED).body(occurrenceService.save(occurrence));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Occurrence> findById(@PathVariable("id") Long id) {
        Optional<Occurrence> occurrenceOptional = occurrenceService.findById(id);
        if (occurrenceOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(occurrenceOptional.get());
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Occurence not found!");
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Occurrence> update(@PathVariable("id") Long id, @RequestBody @Valid OccurrenceDto occurrenceDto) {
        Optional<Occurrence> occurrenceOptional = occurrenceService.findById(id);
        if (occurrenceOptional.isPresent()) {
            Occurrence occurrence = new Occurrence();
            BeanUtils.copyProperties(occurrenceDto, occurrence);
            occurrence.setId(occurrenceOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(occurrenceService.save(occurrence));
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Occurrence not found");
    }
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Occurrence> occurrenceOptional = occurrenceService.findById(id);
        if (occurrenceOptional.isPresent()) {
            occurrenceService.delete(occurrenceOptional.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Occurrence not found!");
    }

}
