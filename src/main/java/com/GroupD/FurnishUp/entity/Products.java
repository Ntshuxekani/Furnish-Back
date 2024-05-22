package com.GroupD.FurnishUp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity(name = "PRODUCTS")
@Table
public class Products {

    @Id
    //@Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private   Double price;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @NonNull
    private Double d_price;

    @NonNull
    private String image;

    @NonNull
    private String category;

    @NonNull
    private String description;

    @NonNull
    private Integer quantity;

    //@ManyToOne
    //@JoinColumn(name="customer_id")
    //private Users customer;

}
