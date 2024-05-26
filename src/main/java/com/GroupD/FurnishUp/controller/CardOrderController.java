package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.CartOrders;
import com.GroupD.FurnishUp.entity.Products;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/FurnishUp/CartOrders")
public class CardOrderController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody CartOrders.AddToCartRequest request) {
        cartService.addToCart(request.getProductId(), request.getQuantity());
    }

    @PostMapping("/removeFromCart")
    public void removeFromCart(@RequestBody CartOrders.RemoveFromCartRequest request) {
        cartService.removeFromCart(request.getProductId());
    }

    @GetMapping("/cartItems")
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }
}
