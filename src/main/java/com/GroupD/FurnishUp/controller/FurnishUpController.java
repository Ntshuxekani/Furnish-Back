package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class FurnishUpController {

    @Autowired
    private FurnishUpServiceImpl furnishUpService;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        return new  ResponseEntity<List<Users>>(furnishUpService.getAllUsers(),HttpStatus.ACCEPTED);}

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users users) {
       Users savedUser = furnishUpService.saveUsers(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findOne(@PathVariable Long id) {
        furnishUpService.getUsersById(id).setDeleted(true);
        if (furnishUpService.getUsersById(id).isDeleted()){
            return new  ResponseEntity<>(furnishUpService.getUsersById(id), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(furnishUpService.getUsersById(id), HttpStatus.FOUND);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users users) {
       Users updatedUser = furnishUpService.updateUsers(id, users);
        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> delete(@PathVariable Long id) { //Path Variable annotation is used to specify id for the needed information
        Users deletedUser =  furnishUpService.deleteUsers(id);
        return new ResponseEntity<>(deletedUser,HttpStatus.ACCEPTED);
    }
}
