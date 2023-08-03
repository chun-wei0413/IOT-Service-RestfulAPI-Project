package com.example.Fproject.database.serviceImpl;

import com.example.Fproject.database.DeviceService;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.dao.*;
import com.example.Fproject.database.entity.Manager;
import com.example.Fproject.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DeviceServiceImpl implements DeviceService  {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private deviceRepository deviceRepository;
    @Autowired
    private managerRepository managerRepository;
    @Override
    public boolean isManager(String userId,String deviceId){
        Device device = deviceRepository.findById(deviceId).orElse(null);
        Set<Manager> managers=device.getManager();
        for(Manager manager:managers){
            if(manager.getManager().equals(userId)){
                return true;
            }
        }
        return false;
    }
}
