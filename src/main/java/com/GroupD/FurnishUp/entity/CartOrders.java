package com.GroupD.FurnishUp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CartOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private Long product_id;

    @NonNull
    private Double price;

    @NonNull
    private Long quantity;




}
