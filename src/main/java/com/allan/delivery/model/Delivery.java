package com.allan.delivery.model;

import com.allan.delivery.dtos.DeliveryDto;
import com.allan.delivery.enums.StatusDelivery;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "delivery")
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rate", nullable = false)
    private String rate;
    @Column(name = "date_order", nullable = false)
    private String date_order;
    @Column(name = "date_end", nullable = false)
    private String date_end;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_delivery", nullable = false)
    private StatusDelivery statusDelivery;
    @Embedded
    private Recipient recipient;

    public Delivery(){}

    public Delivery(DeliveryDto deliveryDto) {
        this.rate = deliveryDto.getRate();
        this.date_order = deliveryDto.getDate_order();
        this.date_end = deliveryDto.getDate_end();
        this.statusDelivery = deliveryDto.getStatusDelivery();
        this.recipient = new Recipient(deliveryDto.getRecipient());
    }

}
