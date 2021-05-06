package com.ipsas.WebService.Services;

import com.ipsas.WebService.Exceptions.UserNotFoundException;
import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User E){
        return userRepo.save(E);
    }

    public List<User> addUsers(List<User> userList){

        return userRepo.saveAll(userList);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User findOneById(Long id){
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id : "+id+" is not found !" ));
    }

    public User updateUser(User E){
        return userRepo.save(E);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }


    public User findOneByUsername(String e) {
        return this.userRepo.findUsersByUsername(e);
    }
}
