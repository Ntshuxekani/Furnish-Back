package com.GroupD.FurnishUp.controller;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.service.FurnishUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/FurnishUp/customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FurnishUpController {

    @Autowired
    private FurnishUpServiceImpl furnishUpService;

    @GetMapping
    public List<Users> findAll() {return furnishUpService.getAllUsers();}

    @PostMapping
    public void save(@RequestBody Users users) {furnishUpService.saveUsers(users);}

    @GetMapping("/{id}")
    public Users findOne(@PathVariable Long id) {
        return furnishUpService.getUsersById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Users users) {
        this.furnishUpService.updateUsers(id, users);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { //Path Variable annotation is used to specify id for the needed information
        this.furnishUpService.deleteUsers(id);
    }
}
