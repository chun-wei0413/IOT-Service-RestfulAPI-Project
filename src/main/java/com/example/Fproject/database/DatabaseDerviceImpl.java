package com.example.Fproject.database;

import com.example.Fproject.database.dao.userRepository;
import com.example.Fproject.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DatabaseDerviceImpl implements DatabaseService {
    @Autowired
    private userRepository UserRepository;

    @Override
    public void saveUser(){

    }
    @Override
    public void getuserpass(){

    }
}
