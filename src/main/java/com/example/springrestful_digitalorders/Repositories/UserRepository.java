package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}
