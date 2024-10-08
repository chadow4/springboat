package com.julien.springboat.controller;


import com.julien.springboat.DTO.UserDTOWithArticle;
import com.julien.springboat.model.User;
import com.julien.springboat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserDTOWithArticle> user = Optional.ofNullable(userService.getUserById(id));
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
           return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}