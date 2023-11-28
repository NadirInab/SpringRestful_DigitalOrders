package com.example.springrestful_digitalorders.application.user;

import com.example.springrestful_digitalorders.domain.user.User;
import com.example.springrestful_digitalorders.domain.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User save(User user) ;

    public List<User> findAll() ;

    public UserDto findById(Long id) ;
}
