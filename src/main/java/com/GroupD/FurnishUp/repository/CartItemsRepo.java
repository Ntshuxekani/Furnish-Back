package com.GroupD.FurnishUp.repository;

import com.GroupD.FurnishUp.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepo extends JpaRepository <CartItems, Long> {
}
