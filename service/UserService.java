package com.example.crud.service;

import com.example.crud.dao.UserRepository;
import com.example.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public User getUserById(int id){
         return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User updateUser(User user){

        User oldUser = null;
        Optional<User> optionalUser = this.userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            this.userRepository.save(oldUser);
        }else{
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(int id){
        this.userRepository.deleteById(id);
        return "User got deleted";
    }

}
