package com.example.springrestful_digitalorders.Dtos;


import com.example.springrestful_digitalorders.entities.User;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private Long id;
    private String fullName;
    private boolean isAdmin;

    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .isAdmin(user.isAdmin())
                .build();

    }
}
