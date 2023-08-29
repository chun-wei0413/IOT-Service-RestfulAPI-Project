package com.example.Fproject.database.dao;

import com.example.Fproject.database.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface deviceRepository extends JpaRepository<Device, String> {

}

