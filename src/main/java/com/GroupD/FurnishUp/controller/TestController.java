package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")

public class TestController {
    @Autowired
    private FurnishUpServiceImpl furnishUpService;

    @GetMapping("/all/products")
  /*  public String allAccess() {
        return "Public Content.";
    }*/
    public List<Products> findAll() {return furnishUpService.getAllProducts();}

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('SUPPLIER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/supplier")
    @PreAuthorize("hasRole('SUPPLIER')")
    public String supplierAccess() {
        return "Supplier DashBoard.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin DashBoard.";
    }
}
