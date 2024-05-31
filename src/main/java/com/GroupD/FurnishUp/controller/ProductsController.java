package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/FurnishUp")
public class ProductsController {

    @Autowired
    private FurnishUpServiceImpl furnishUpService;

    @GetMapping
    public List<Products> findAll() {return furnishUpService.getAllProducts();}

    @PostMapping
    public void save(@RequestBody Products products) {furnishUpService.saveProducts(products);}

    @GetMapping("/{id}")
    public Products findOne(@PathVariable Long id) {
        return furnishUpService.getProductsById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Products products) {
        this.furnishUpService.updateProducts(id, products);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { //Path Variable annotation is used to specify id for the needed information
        this.furnishUpService.deleteProducts(id);
    }
}
