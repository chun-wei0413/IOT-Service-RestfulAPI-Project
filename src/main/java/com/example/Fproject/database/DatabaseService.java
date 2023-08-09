package com.example.Fproject.database;

import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.entity.Manager;

import java.util.List;

public interface DatabaseService {
    boolean authorization(String userId,String deviceId);
    boolean authentication(String userId,String password);
    boolean addDevice(String type,String pin,String userId);
    boolean alterDevice(String userId,String deviceId,String pin);
    boolean deleteDevice(String userId,String deviceId);
    boolean registerUser(String userId,String password);
    boolean deleteUser(String userId);
    boolean addRelationship(String userId, String deviceId);
    List<Device.Data> queryDeviceMember(String userId);
    String getUrl(String deviceId);
    boolean addManager(String userId, String deviceId);
    boolean deleteManager(String userId, String deviceId);
    List<Manager.member> listManager(String deviceId);
}

