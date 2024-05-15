package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo_db")
public class FurnishUpController {

    @Autowired
    private FurnishUpServiceImpl userService;

    @GetMapping
    public List<Users> findAll(){
        return  userService.getAllUsers();
    }

    @PostMapping
    public void save(@RequestBody Users users){
        userService.saveUsers(users);
    }

    @GetMapping("/{id}")
    public Users findOne(@PathVariable Long id){
       return userService.getUsersById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Users users){
        this.userService.usersUpdate(id, users);
    }

}
