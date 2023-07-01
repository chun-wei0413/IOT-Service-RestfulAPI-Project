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
            User user1 = new User();
            user1.setUserId("wqr002");
            user1.setPassword("12345");
            User user2 = new User();
            user2.setUserId("frank");
            user2.setPassword("666666");

            Device device1 = new Device();
            device1.setDeviceId("801");
            device1.setPin("14");
            device1.setUrl("http://d65f-122-116-105-235.ngrok-free.app");
            device1.setManager("wqr002");
            device1.setType("light");

            Device device2 = new Device();
            device2.setDeviceId("002");
            device2.setPin("14");
            device2.setUrl("http://d65f-122-116-105-235.ngrok-free.app");
            device2.setManager("frank");
            device2.setType("fan");

            Set<Device> deviceswqr = user1.getDevice();
            Set<Device> devicesfrank = user2.getDevice();
            deviceswqr.add(device1);
            user1.setDevice(deviceswqr);
            userRepository.save(user1);
            devicesfrank.add(device2);
            user2.setDevice(devicesfrank);
            userRepository.save(user2);

    }
}
