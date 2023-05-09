package com.allan.delivery.dtos;



import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CustomerDto {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "\\d{9,11}")
    private String phone;

    public CustomerDto() {
        this.name = getName();
        this.email = getEmail();
        this.phone = getPhone();
    }
}
