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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NonNull
     private String title;
       @NonNull
       private   Long price;
        //@OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "category_id", referencedColumnName = "category_id")
        @NonNull
          private Long d_price;
        @NonNull
    private String image;
        @NonNull
    private String category;
        @NonNull
    private String  description;
    @NonNull
    private Long quantity;
@ManyToOne
@JoinColumn(name="customer_id")
    private Users customer;


}
