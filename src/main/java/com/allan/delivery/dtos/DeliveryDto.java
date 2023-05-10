package com.allan.delivery.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeliveryDto {
    @NotBlank
    private String rate;
    @NotBlank
    private String date_order;
    @NotBlank
    private String date_end;


    public DeliveryDto() {
        this.rate = getRate();
        this.date_order = getDate_order();
        this.date_end = getDate_end();
    }

}
