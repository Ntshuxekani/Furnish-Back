package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.FurnishUpApplication;
import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;

import java.util.List;

public interface FurnishUpService {
    List<Users> getAllUsers();

    void saveUsers(Users users);

    void updateUsers(Long id, Users users);

    Users getUsersById(Long id);

    void deleteUsers(Long id);

    List<Products> getAllProducts();

    void saveProducts(Products products);

    Products getProductsById(Long id);

    void updateProducts(Long id, Products products);

    void deleteProducts(Long id);


    List<CartOrders> getAllCartOrders();

    void saveCartOrders(CartOrders cartOrders);

    void updateCartOrders(Long id, CartOrders cartOrders);

    CartOrders getCartOrdersById(Long id);

    void deleteCartOrders(Long id);
}
