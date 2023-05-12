package com.allan.delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String complement;
    @NotBlank
    private String neighborhood;

}
