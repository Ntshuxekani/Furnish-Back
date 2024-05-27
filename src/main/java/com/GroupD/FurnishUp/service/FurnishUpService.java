package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Users;

import java.util.List;

public interface FurnishUpService {
    List<Users> getAllUsers();

    Users saveUsers(Users users);

    Users updateUsers(Long id, Users users);

    Users getUsersById(Long id);
   // Users  softDeleteUsers(Long id);
    Users deleteUsers(Long id);

}
