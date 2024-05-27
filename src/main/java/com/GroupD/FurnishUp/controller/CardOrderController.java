package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.service.FurnishUpService;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/FurnishUp/CartOrders")
public class CardOrderController {
    @Autowired
    private FurnishUpService furnishUpService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody CartOrders.AddToCartRequest request) {
        furnishUpService.addToCart(request.getProduct_id(), request.getQuantity());
    }

    @PostMapping("/removeFromCart")
    public void removeFromCart(@RequestBody CartOrders.RemoveFromCartRequest request) {
        furnishUpService.removeFromCart(request.getProduct_id());
    }

    @GetMapping("/cartItems")
    public List<CartOrders> getCartOrders() {
        return furnishUpService.getCartOrders();
    }
}
