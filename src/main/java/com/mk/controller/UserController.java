package com.mk.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mk.entity.User;
import com.mk.exception.ResourceNotFound;
import com.mk.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
  //single user
    @PostMapping("/adduser")
    @Operation(
    		summary="this is for create user"
    		)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    
    //multiple user
    @PostMapping("/multipleusers")
    public List<User> createMultipleUser(@RequestBody  List<User> users){
        return userService.createMultipleUser(users);
    }
    
    //retrieving all users 
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    
    //retrieving one particular  user 

    @GetMapping("/user/{id}")

    @ApiResponse(
    			responseCode="200",
    			description="ok status"
    			
    			)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
    	
    	
        User user = userService.getUserById(id);
        if (user!= null) {
          // return ResponseEntity.notFound().build();
        	//throw new ResourceNotFound("resource not available");
        	return ResponseEntity.ok(user);
        }
        else
        {
        	throw new ResourceNotFound("resource not available");
        }
    }
    
    
    @GetMapping("/exists/{id}")
    public boolean userExist(@PathVariable Long id) {
        return userService.userExist(id);
    }

    
    
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id){
        User user1 = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        User updatedUser = userService.updateUser(user1);
        return ResponseEntity.ok(updatedUser);
    }
    
    
    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateParticularUserDetai(@RequestBody User user,@PathVariable Long id){
        User user1 = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        User updatedUser = userService.updateUser(user1);
        return ResponseEntity.ok(updatedUser);
    }
    
    
  
    

   

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        if (user == null)
            return ResponseEntity.notFound().build();
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }

    
    @DeleteMapping("/deleteAll")
    public void  deleteAllUser(){
       
        userService.deleteAllUser();
       
    }

    

    

}