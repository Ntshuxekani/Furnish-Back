package com.GroupD.FurnishUp.service;

import com.GroupD.FurnishUp.entity.Users;
import com.GroupD.FurnishUp.repository.FurnishUpRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class FurnishUpServiceImpl implements FurnishUpService{

    @Autowired
    private FurnishUpRepo furnishUpRepo;

    @Override
    public List<Users> getAllUsers() {
        return furnishUpRepo.findAll();}

    public void saveUsers(Users users) {
        this.furnishUpRepo.save(users);
    }

    public Users getUsersById(Long id) {
        Optional<Users> optional = furnishUpRepo.findById(id);
        Users users;
        if(optional.isPresent()) {
            users = optional.get();
        }else { throw new RuntimeException("Users for the" + id + "is not found");}
        return users;
    }

//    @Override
//    public void softDeleteUsers(Long id) {
//        Optional<Users> usersOptional = furnishUpRepo.findById(id);
//        if(usersOptional.isPresent()){
//            Users users = usersOptional.get();
//            users.setDeleted(true);
//            furnishUpRepo.save(users);
//        }else {
//            throw new EntityNotFoundException("Not Found");
//        }
//    }

    @Override
    public void updateUsers(Long id, Users users) {
        Users userFromDB = furnishUpRepo.findById(id).get();
        userFromDB.setUsername(users.getUsername());
        userFromDB.setEmail(users.getEmail());
        userFromDB.setPassword(users.getPassword());
        furnishUpRepo.save(userFromDB);
    }

     @Override
 public void deleteUsers(Long id) {this.furnishUpRepo.deleteById(id);}
}
