package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.CardOrderRepo;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import com.GroupD.FurnishUp.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public List<CartOrders> getAllCartOrders() {return cardOrderRepo.findAll();}

    @Override
    public void saveCartOrders(CartOrders cartOrders) {
        this.cardOrderRepo.save(cartOrders);
    }

    @Override
    public CartOrders getCartOrdersById(Long id) {
        Optional<CartOrders> optional = cardOrderRepo.findById(id);
        CartOrders cartOrders;
        if(optional.isPresent()) {
            cartOrders = optional.get();
        }else { throw new RuntimeException("CartOrders for the" + id + "is not found");}
        return cartOrders;
    }

    @Override
    public void updateCartOrders(Long id, CartOrders cartOrders) {
        CartOrders cartOrderFromDB = cardOrderRepo.findById(id).get();
        cartOrderFromDB.setPrice(cartOrders.getPrice());
        cartOrderFromDB.setQuantity(cartOrders.getQuantity());
        cartOrderFromDB.setProduct_id(cartOrders.getProduct_id());
        cardOrderRepo.save(cartOrderFromDB);
    }

    @Override
    public void deleteCartOrders(Long id) {this.cardOrderRepo.deleteById(id);}
}
