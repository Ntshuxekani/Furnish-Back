package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.FurnishUpProd;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnishUpServiceImpl implements FurnishUpService{

    @Autowired
    private FurnishUpRepo furnishUpRepo;
    @Autowired
    private FurnishUpProd furnishUpProd;

    @Override
    public List<Users> getAllUsers() {return furnishUpRepo.findAll();}

    public void saveUsers(Users users) {
        this.furnishUpRepo.save(users);
    }

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
    public List<Products> getAllProducts() {return furnishUpProd.findAll();}

    public void saveProducts(Products products) {
        this.furnishUpProd.save(products);
    }

    public Products getProductsById(Long id) {
        Optional<Products> optional = furnishUpProd.findById(id);
        Products products;
        if(optional.isPresent()) {
            products = optional.get();
        }else { throw new RuntimeException("Products for the" + id + "is not found");}
        return products;
    }

    @Override
    public void updateProducts(Long id, Products products) {
        Products productFromDB = furnishUpProd.findById(id).get();
        productFromDB.setTitle(products.getTitle());
        productFromDB.setPrice(products.getPrice());
        productFromDB.setD_price(products.getD_price());
        productFromDB.setDescription(products.getDescription());
        productFromDB.setImage(products.getImage());
        productFromDB.setCategory(products.getCategory());
        productFromDB.setQuantity(products.getQuantity());
        furnishUpProd.save(productFromDB);
    }

    @Override
    public void deleteProducts(Long id) {this.furnishUpProd.deleteById(id);}
}
