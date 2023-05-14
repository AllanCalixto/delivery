package com.allan.delivery.model;

import com.allan.delivery.dtos.OccurrenceDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Occurrence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "registration_date")
    private String registration_date;

    public Occurrence() {}

    public Occurrence(OccurrenceDto occurrenceDto) {
        this.description = occurrenceDto.getDescription();
        this.registration_date = occurrenceDto.getRegistration_date();
    }
}
