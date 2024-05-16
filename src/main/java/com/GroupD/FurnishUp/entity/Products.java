package com.GroupD.FurnishUp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LongSummaryStatistics;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "PRODUCTS")
public class Products {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;


    private Double price;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id", referencedColumnName = "category_id")

    private int d_price;


    private String image;


    private String category;


    private String  description;


    private int quantity;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Users customer;


}
