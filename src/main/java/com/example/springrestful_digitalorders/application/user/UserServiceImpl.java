package com.example.springrestful_digitalorders.application.user;

import com.example.springrestful_digitalorders.domain.user.User;
import com.example.springrestful_digitalorders.domain.user.UserDto;
import com.example.springrestful_digitalorders.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository ;

    public User save(User user){
        return userRepository.save(user) ;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()){
                return UserDto.toDto(optionalUser.get()) ;
            }else{
                return null ;
            }
    }
}
