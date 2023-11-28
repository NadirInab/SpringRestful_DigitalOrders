package com.example.springrestful_digitalorders.domain.user;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
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
