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
        device1.setType("light");

        Device device2 = new Device();
        device2.setDeviceId("002");
        device2.setPin("14");
        device2.setType("fan");

        Manager manager1 = new Manager();
        manager1.setManagerId("wqr002");

        Manager manager2 = new Manager();
        manager2.setManagerId("frank");


        Set<Device> deviceUser1 = user1.getDevice();
        Set<Device> deviceUser2 = user2.getDevice();
        /*
        Set<Manager> managerDevice1 = device1.getManager();
        Set<Manager> managerDevice2 = device2.getManager();
        */
        /*
        managerDevice1.add(manager1);
        managerDevice1.add(manager2);
        device1.setManager(managerDevice1);
        deviceRepository.save(device1);

        managerDevice2.add(manager1);
        managerDevice2.add(manager2);
        device2.setManager(managerDevice2);
        deviceRepository.save(device2);
        */

        device2.getManager().add(manager1);
        device2.getManager().add(manager2);
        deviceUser2.add(device2);
        user2.setDevice(deviceUser2);

        device1.getManager().add(manager1);
        device1.getManager().add(manager2);
        deviceUser1.add(device1);
        user1.setDevice(deviceUser1);
        userRepository.save(user1);
        userRepository.save(user2);
    }
}