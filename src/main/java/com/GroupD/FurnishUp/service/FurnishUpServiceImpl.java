package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import com.GroupD.FurnishUp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnishUpServiceImpl implements FurnishUpService{

    @Autowired
    private FurnishUpRepo furnishUpRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Products> getAllProducts() {return productRepo.findAll();}

    public void saveProducts(Products products) {
        this.productRepo.save(products);
    }

    public Products getProductsById(Long id) {
        Optional<Products> optional = productRepo.findById(id);
        Products products;
        if(optional.isPresent()) {
            products = optional.get();
        }else { throw new RuntimeException("Products for the" + id + "is not found");}
        return products;
    }

    @Override
    public void updateProducts(Long id, Products products) {
        Products products1FromDB = productRepo.findById(id).get();
        products1FromDB.setProductName(products.getProductName());
        products1FromDB.setDescription(products.getDescription());
        products1FromDB.setImage(products.getImage());
        products1FromDB.setCategory(products.getCategory());
        products1FromDB.setPrice(products.getPrice());
        products1FromDB.setDiscountPrice(products.getDiscountPrice());
        productRepo.save(products1FromDB);
    }

    @Override
    public void deleteProducts(Long id) {this.productRepo.deleteById(id);}



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

}
