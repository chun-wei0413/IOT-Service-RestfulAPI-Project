package com.example.Fproject.database.serviceImpl;

import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DeviceService;
import com.example.Fproject.database.dao.*;
import com.example.Fproject.database.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private deviceRepository deviceRepository;
    @Autowired
    private userRepository userRepository;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private managerRepository managerRepository;


    @Override
    public boolean authorization(String userId, String deviceId) {
        User user = userRepository.findById(userId).orElse(null);
        Set<Device> devices = user.getDevice();
        for (Device device : devices) {
            if (device.getDeviceId().equals(deviceId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean authentication(String userId, String password) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addDevice(String url, String type, String pin, String userId) {
        String deviceId = generateRandomId();
        User user = userRepository.findById(userId).orElse(null);
        Set<Device> devices = user.getDevice();
        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setType(type);
        device.setPin(pin);
        devices.add(device);
        user.setDevice(devices);

        Set<Manager> managers = device.getManager();
        Manager manager = new Manager();
        manager.setManagerId(userId);
        manager.setDevice(device);
        managers.add(manager);
        device.setManager(managers);//device 儲存 manager
        try {
            userRepository.save(user);
            deviceRepository.save(device);
            return true;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;

        }

    }

    @Override
    public boolean alterDevice(String userId, String deviceId, String url) {
        Device device = deviceRepository.findById(deviceId).orElse(null);
        Set<User> user = device.getUser();
        if (deviceService.isManager(userId, deviceId)) {
            device.setUser(user);
            deviceRepository.save(device);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDevice(String userId, String deviceId) {
        Device device = deviceRepository.findById(deviceId).orElse(null);
        if (deviceService.isManager(userId, deviceId)) {
            device.setUser(null);
            deviceRepository.delete(device);
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUser(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;
        }

    }

    public boolean deleteUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        try {
            user.setDevice(null);
            userRepository.delete(user);
            return true;
        }catch(Exception e){
            System.out.println("Error!!!  " + e.getMessage());
            return false;
        }
    }

    public String getUrl(String deviceId){
        Device device=deviceRepository.findById(deviceId).orElse(null);
        if(device!=null){
            return null;
        }else{
            return null;
        }
    }
    public boolean addRelationship(String userId,String deviceId){
        User user=userRepository.findById(userId).orElse(null);
        Device device=deviceRepository.findById(deviceId).orElse(null);
        Set<Device> devices = user.getDevice();
        devices.add(device);
        user.setDevice(devices);
        try{
            userRepository.save(user);
            return true;

        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
            return false;
        }
    }
    public List<Device.Data> queryDeviceMember(String userId){
        User user=userRepository.findById(userId).orElse(null);
        Set<Device> devices=user.getDevice();
        List<Device.Data> members = new ArrayList<>();
        for(Device device : devices){
            members.add(device.toData());
        }
        return members;
    }
    private String generateRandomId(){
        Random random=new Random();
        int id;
        boolean duplicate;
        String idString;

        do{
            id=random.nextInt(1000);
            //return 0-999的整數作為id
            idString=String.valueOf(id);
            duplicate=deviceRepository.existsById(idString);//判斷id是否重複
        }while(duplicate);

        return idString;

    }
}