package com.example.Fproject.database.dao;


import com.example.Fproject.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, String> {

}


