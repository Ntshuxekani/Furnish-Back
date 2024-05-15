package com.GroupD.FurnishUp.repository;


import com.GroupD.FurnishUp.entity.Cart;
import com.GroupD.FurnishUp.entity.Category;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnishUpRepo extends JpaRepository <Object, Long> {

    //Find all carts belonging to a specific user
    List<Cart> findAllCartsByUser(User user);

    // Find all products in a specific category
    List<Products> findAllProductsByCategory(Category category);

    // Find all products in a specific cart
    @Query("SELECT cp.product FROM CartProduct cp WHERE cp.cart = :cart")
    List<Products> findAllProductsInCart(Cart cart);

    // Find all products bought by a specific user
    @Query("SELECT cp.product FROM CartProduct cp JOIN cp.cart c WHERE c.user = :user")
    List<Products> findAllProductsBoughtByUser(User user);

    // Add more custom methods as needed
}



