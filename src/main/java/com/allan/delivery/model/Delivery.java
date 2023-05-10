package com.allan.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rate", nullable = false)
    private String rate;
    @Column(name = "date_order", nullable = false)
    private String date_order;
    @Column(name = "date_end", nullable = false)
    private String date_end;

}
