package com.GroupD.FurnishUp.repository;

import com.GroupD.FurnishUp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnishUpProd extends JpaRepository <Products, Long> {
}
