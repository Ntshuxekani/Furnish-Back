package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Users;

import java.util.List;

public interface FurnishUpService {

    List<Users> getAllUsers();
    void saveUsers(Users users);
    void usersUpdate(Long id, Users users);
    Users getUsersById(Long id);
    void deleteUsers(Long id);
}
