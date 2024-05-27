package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.CardOrderRepo;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import com.GroupD.FurnishUp.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FurnishUpServiceImpl implements FurnishUpService{

    @Autowired
    private FurnishUpRepo furnishUpRepo;

    @Autowired
    private ProdRepo prodRepo;

    @Autowired
    private CardOrderRepo cardOrderRepo;

    @Override
    public List<Users> getAllUsers() {return furnishUpRepo.findAll();}

    @Override
    public void saveUsers(Users users) {
        this.furnishUpRepo.save(users);
    }

    @Override
    public Users getUsersById(Long id) {
        Optional<Users> optional = furnishUpRepo.findById(id);
        Users users;
        if(optional.isPresent()) {
            users = optional.get();
        }else { throw new RuntimeException("Users for the" + id + "is not found");}
        return users;
    }

    @Override
    public void updateUsers(Long id, Users users) {
        Users userFromDB = furnishUpRepo.findById(id).get();
        userFromDB.setUsername(users.getUsername());
        userFromDB.setEmail(users.getEmail());
        userFromDB.setPassword(users.getPassword());
        userFromDB.setRole(users.getRole());
        furnishUpRepo.save(userFromDB);
    }

    @Override
    public void deleteUsers(Long id) {this.furnishUpRepo.deleteById(id);}



    @Override
    public List<Products> getAllProducts() {return prodRepo.findAll();}


    @Override
    public void saveProducts(Products products) {
        this.prodRepo.save(products);
    }

    @Override
    public Products getProductsById(Long id) {
        Optional<Products> optional = prodRepo.findById(id);
        Products products;
        if(optional.isPresent()) {
            products = optional.get();
        }else { throw new RuntimeException("Products for the" + id + "is not found");}
        return products;
    }


    @Override
    public void updateProducts(Long id, Products products) {
        Products productFromDB = prodRepo.findById(id).get();
        productFromDB.setPrice(products.getPrice());
        productFromDB.setDescription(products.getDescription());
        productFromDB.setD_price(products.getD_price());
        productFromDB.setTitle(products.getTitle());
        productFromDB.setImage(products.getImage());
        productFromDB.setCategory(products.getCategory());
        productFromDB.setQuantity(products.getQuantity());
        prodRepo.save(productFromDB);
    }


    @Override
    public void deleteProducts(Long id) {this.prodRepo.deleteById(id);}



    private List<CartOrders> cartOrders = new ArrayList<>();

    @Override
    public void addToCart(Long product_id, Long quantity) {
        // Add logic to add items to the cart
        // This can include checking if the item already exists in the cart
        // If it exists, update the quantity, otherwise add a new item to the cart
    }

    @Override
    public void removeFromCart(Long product_id) {
        // Add logic to remove items from the cart based on productId
    }

    @Override
    public List<CartOrders> getCartOrders() {
        // Return the list of cart orders
        return cartOrders;
    }
}
