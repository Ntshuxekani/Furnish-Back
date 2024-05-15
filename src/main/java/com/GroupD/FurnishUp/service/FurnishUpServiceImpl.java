package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnishUpServiceImpl implements FurnishUpService {

    @Autowired
    private FurnishUpRepo furnishUpRepo;

    @Override
    public List<Users> getAllUsers() {
        return furnishUpRepo.findAll();
    }

    @Override
    public void saveUsers(Users users) {
       this.furnishUpRepo.save(users);
    }

    @Override
    public void usersUpdate(Long id, Users users) {
        Users usersFromDb = furnishUpRepo.findById(id).get();
        usersFromDb.setUsername(users.getUsername());
        usersFromDb.setEmail(users.getEmail());
        usersFromDb.setPassword(users.getPassword());
        furnishUpRepo.save(usersFromDb);
    }

    @Override
    public Users getUsersById(Long id) {
        Optional<Users> optional = furnishUpRepo.findById(id);
        Users users;
        if(optional.isPresent()){
            users = optional.get();
        }
        else {
            throw new RuntimeException("User with the id: " + id + " is not found!");
        }

        return users;
    }

    @Override
    public void deleteUsers(Long id) {
      this.furnishUpRepo.deleteById(id);
    }

}
