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
    private userdeviceRepository userdeviceRepository;
    @Autowired
    private managerRepository managerRepository;

    @Override
    public boolean authorization(String userId, String deviceId) {
        //user有無操作device權限
        /*List<UserDevice> users = new ArrayList<>();
        users = userdeviceRepository.findAll();
        boolean flag = false;
        for(UserDevice userDevice : users){
            if(userDevice.getUser().equals(userId)&&userDevice.getDevice().equals(deviceId)){
                flag = true;
                break;
            }
        }
        return flag;*/
        UserDevice userDevice = userdeviceRepository.findById(userId).orElse(null);
        if(userDevice.getDevice().getDeviceId().equals(deviceId)){
            return true;
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
        //新增device
        String deviceId = generateRandomId();
        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setType(type);
        device.setPin(pin);
        //使用新增它的user
        User user = userRepository.findById(userId).orElse(null);
        //新增userdevice
        UserDevice userDevice = new UserDevice();
        userDevice.setDevice(device);
        userDevice.setUser(user);
        //新增manager
        Manager manager = new Manager();
        manager.setManagerId(userId);
        manager.setDevice(device);

        try {
            //儲存userdevice
            userdeviceRepository.save(userDevice);
            //儲存device
            deviceRepository.save(device);
            //儲存manager
            managerRepository.save(manager);
            return true;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;

        }

    }

    /*----------------------------------先他媽別動------------------------------------*/
    @Override
    public boolean alterDevice(String userId, String deviceId, String url) {
        /*Device device = deviceRepository.findById(deviceId).orElse(null);
       // Set<User> user = device.getUser();
        if (deviceService.isManager(userId, deviceId)) {
            //device.setUrl(url);
            //device.setUser(user);
            deviceRepository.save(device);
            return true;
        }*/
        return false;
    }
    /*------------------------------------------------------------------------------*/
    @Override
    public boolean deleteDevice(String userId, String deviceId) {
        Device device = deviceRepository.findById(deviceId).orElse(null);
        try {
            deviceRepository.delete(device);
            return true;
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
            return false;
        }
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
            userRepository.delete(user);
            return true;
        }catch(Exception e){
            System.out.println("Error!!!  " + e.getMessage());
            return false;
        }
    }
    /*----------------------------------先他媽別動------------------------------------*/
    public String getUrl(String deviceId){
        /*Device device=deviceRepository.findById(deviceId).orElse(null);
        if(device!=null){
            return device.getUrl();
        }else{
            return null;
        }*/
        return null;
    }
    /*----------------------------------先他媽別動------------------------------------*/
    public boolean addRelationship(String userId,String deviceId){
        User user = userRepository.findById(userId).orElse(null);
        Device device = deviceRepository.findById(deviceId).orElse(null);
        UserDevice userDevice = new UserDevice();
        userDevice.setDevice(device);
        userDevice.setUser(user);
        try{
            userdeviceRepository.save(userDevice);
            return true;

        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
            return false;
        }
    }
    public List<Device.Data> queryDeviceMember(String userId){
        User user=userRepository.findById(userId).orElse(null);
        Set<UserDevice> userDevices=user.getUserDevices();
        List<Device> devices = new ArrayList<>();
        for(UserDevice userDevice : userDevices){
            devices.add(userDevice.getDevice());
        }
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