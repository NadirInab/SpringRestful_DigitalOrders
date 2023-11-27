package com.example.springrestful_digitalorders.application.user;

import com.example.springrestful_digitalorders.domain.user.User;
import com.example.springrestful_digitalorders.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository ;

    public User save(User user){
        return userRepository.save(user) ;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
