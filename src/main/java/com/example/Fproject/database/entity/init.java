package com.example.Fproject.database.entity;
import com.example.Fproject.database.entity.User;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.dao.userRepository;
import com.example.Fproject.database.dao.deviceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class init {
    @Autowired
    private deviceRepository deviceRepository;
    @Autowired
    private userRepository userRepository;
    @PostConstruct
    public void init() {
            User user = new User();
            user.setUserId("fanjiang");
            Device device1 = new Device();
            device1.setDeviceId("001");
            Device device2 = new Device();
            device2.setDeviceId("002");
            Set<Device> devices = new HashSet<>();
            devices.add(device1);
            devices.add(device2);
            user.setDevice(devices);
            userRepository.save(user);
    }
}
