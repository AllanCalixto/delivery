package com.allan.delivery.dtos;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class CustomerDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;

    public CustomerDto() {
        this.name = getName();
        this.email = getEmail();
        this.phone = getPhone();
    }
}
