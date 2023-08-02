package com.example.Fproject.database.dao;


import com.example.Fproject.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface userRepository extends JpaRepository<User, String> {

}


