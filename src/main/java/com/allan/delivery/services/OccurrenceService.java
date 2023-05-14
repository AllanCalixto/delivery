package com.allan.delivery.services;

import com.allan.delivery.model.Occurrence;
import com.allan.delivery.repositories.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {
    @Autowired
    private OccurrenceRepository occurrenceRepository;

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }
    public Occurrence save(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }
    public Optional<Occurrence> findById(Long id) {
        return occurrenceRepository.findById(id);
    }
    public void delete(Occurrence occurrence) {
        occurrenceRepository.delete(occurrence);
    }
}
