package com.GroupD.FurnishUp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "PRODUCTS")
public class Products {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private   int price;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @NonNull
    private int d_price;

    @NonNull
    private String image;

    @NonNull
    private String category;

    @NonNull
    private String  description;

    @NonNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Users customer;


}
