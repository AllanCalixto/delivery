package com.allan.delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OccurrenceDto {
    @NotBlank
    private String description;
    @NotBlank
    private String registration_date;

}
