package com.example.Fproject.database.serviceImpl;

import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DeviceService;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.dao.*;
import com.example.Fproject.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Fproject.database.dao.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService  {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private deviceRepository deviceRepository;
    @Override
    public List<Device.DeviceData> getDeviceMembers(String userId){
        List<User> users = getAllDeviceMembers();
        List<Device.DeviceData> deviceData = new ArrayList<>();
        for(User user: users)
            if(user.getUserId().equals(userId)){
                user.getDevice()
            }
    }
    @Override
    public List<User> getAllDeviceMembers(){
        return userRepository.findAll();
    }
}
