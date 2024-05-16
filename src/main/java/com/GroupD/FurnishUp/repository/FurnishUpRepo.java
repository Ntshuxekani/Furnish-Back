package com.GroupD.FurnishUp.repository;

import com.GroupD.FurnishUp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnishUpRepo extends JpaRepository <Users, Long>{
}
