package com.example.springrestful_digitalorders.Controllers.impl;

import com.example.springrestful_digitalorders.Controllers.UserController;
import com.example.springrestful_digitalorders.Services.UserService;
import com.example.springrestful_digitalorders.entities.User;
import com.example.springrestful_digitalorders.Dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {


    private final UserService userService ;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            User savedUser = userService.save(user);

            return ResponseEntity.status(HttpStatus.OK).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        try {
            List<User> users = userService.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable long id) {
        try {
            UserDto user = userService.findById(id);

            if (user != null) {

                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

