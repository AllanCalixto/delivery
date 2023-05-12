package com.allan.delivery.dtos;

import com.allan.delivery.enums.StatusDelivery;
import com.allan.delivery.model.Delivery;
import com.allan.delivery.model.Recipient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {

    private String rate;

    private String date_order;

    private String date_end;

    @Enumerated(EnumType.STRING)
    private StatusDelivery statusDelivery;
    @Valid
    private RecipientDto recipient;

}
