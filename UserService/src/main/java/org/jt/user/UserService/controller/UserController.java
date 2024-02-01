package org.jt.user.UserService.controller;

import org.jt.user.UserService.entities.User;
import org.jt.user.UserService.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //create user on database
    @PostMapping
    public ResponseEntity<User> createUsers(@RequestBody User user){
        User user1=userService.saveUsers(user);

        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get allusers
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> user=userService.getAllUsers();
        return ResponseEntity.ok(user);
    }
    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User>getSingleUser(@PathVariable String userId){
        User users=userService.getUser(userId);
        return ResponseEntity.ok(users);
    }

}
