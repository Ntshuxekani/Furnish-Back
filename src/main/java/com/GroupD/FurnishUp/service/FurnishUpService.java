package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.FurnishUpApplication;
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

    void updateProducts(Long id, Products products);

    Products getProductsById(Long id);

    void deleteProducts(Long id);
}
