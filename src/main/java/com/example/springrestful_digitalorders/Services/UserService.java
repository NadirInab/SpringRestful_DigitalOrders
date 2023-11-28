package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.User;
import com.example.springrestful_digitalorders.Dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User save(User user) ;

    public List<User> findAll() ;

    public UserDto findById(Long id) ;
}
