package com.example.Fproject.database.dao;

import com.example.Fproject.database.entity.User;
import com.example.Fproject.database.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface userdeviceRepository extends JpaRepository<UserDevice, String>, JpaSpecificationExecutor<UserDevice>{
}