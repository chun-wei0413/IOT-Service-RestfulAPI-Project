package com.example.Fproject.database.dao;

import com.example.Fproject.database.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface deviceRepository extends JpaRepository<Device, String>, JpaSpecificationExecutor<Device> {

}

