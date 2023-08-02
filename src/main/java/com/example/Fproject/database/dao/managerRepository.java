package com.example.Fproject.database.dao;

import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface managerRepository extends JpaRepository<Manager, String>{
}