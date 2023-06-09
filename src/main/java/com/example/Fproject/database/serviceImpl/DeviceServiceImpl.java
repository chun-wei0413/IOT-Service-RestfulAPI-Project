package com.example.Fproject.database.serviceImpl;

import com.example.Fproject.database.DeviceService;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.dao.*;
import com.example.Fproject.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService  {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private deviceRepository deviceRepository;

    @Override
    public boolean isManager(String userId,String deviceId){
        Device device=deviceRepository.findById(deviceId).orElse(null);
        if(device!=null&&device.getManager().equals(userId)){
            return true;
        }else{
            return false;
        }
    }
}
