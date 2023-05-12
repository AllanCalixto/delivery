package com.allan.delivery.model;

import com.allan.delivery.dtos.RecipientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@Embeddable
public class Recipient {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "complement", nullable = false)
    private String complement;
    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    public Recipient(){}

    public Recipient(RecipientDto recipientDto) {
        this.name = recipientDto.getName();
        this.street = recipientDto.getStreet();
        this.number = recipientDto.getNumber();
        this.complement = recipientDto.getComplement();
        this.neighborhood = recipientDto.getNeighborhood();
    }

}
