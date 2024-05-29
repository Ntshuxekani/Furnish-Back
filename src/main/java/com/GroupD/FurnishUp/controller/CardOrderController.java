package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/FurnishUp/CartOrders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardOrderController {
    @Autowired
    private FurnishUpServiceImpl furnishUpService;

    @GetMapping
    public List<CartOrders> findAll() {return furnishUpService.getAllCartOrders();}

    @PostMapping
    public void save(@RequestBody CartOrders cartOrders) {furnishUpService.saveCartOrders(cartOrders);}

    @GetMapping("/{id}")
    public CartOrders findOne(@PathVariable Long id) {
        return furnishUpService.getCartOrdersById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CartOrders cartOrders) {
        this.furnishUpService.updateCartOrders(id, cartOrders);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { //Path Variable annotation is used to specify id for the needed information
        this.furnishUpService.deleteCartOrders(id);
    }
}
