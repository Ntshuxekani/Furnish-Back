package com.GroupD.FurnishUp.repository;

import com.GroupD.FurnishUp.entity.CartOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardOrderRepo extends JpaRepository <CartOrders, Long> {
}
