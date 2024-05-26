package com.GroupD.FurnishUp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Users customer;
    public Cart(){}

    private Long quantity;

    private Long price;
}
