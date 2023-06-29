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
            user.setUserId("wqr002");
            user.setPassword("12345");
            //userRepository.save(user);

            Device device1 = new Device();
            device1.setDeviceId("801");
            device1.setPin("14");
            device1.setUrl("http://d65f-122-116-105-235.ngrok-free.app");
            device1.setManager("wqr002");
            device1.setType("light");
            Device device2 = new Device();
            device2.setDeviceId("002");
            device2.setPin("14");
            device2.setUrl("hihi");
            device2.setManager("wqr002");
            device2.setType("fan");
            Set<Device> devices = new HashSet<>();
            devices.add(device1);
            devices.add(device2);
            user.setDevice(devices);
            userRepository.save(user);



    }
}
