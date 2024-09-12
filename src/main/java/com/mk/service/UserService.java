package com.mk.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mk.entity.User;
import com.mk.repository.UserRepository;

@Service

public class UserService {



    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public List<User> createMultipleUser(List<User> users) {
        return userRepository.saveAll(users);
    }
    @Cacheable(value="order")

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    @Cacheable(value="order" ,key="#id")

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public boolean userExist( Long id) {
        return userRepository.existsById(id);
    }

	

    
    
    public User updateUser(User user1) {
        return userRepository.save(user1);
    }

    
    
    
    public void updatePartiluar(User user) {
        userRepository.save(user);
    }
  
    @CacheEvict(value="order" ,key="#id")

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    
    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    
    
}