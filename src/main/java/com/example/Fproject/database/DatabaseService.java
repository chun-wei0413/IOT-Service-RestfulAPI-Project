package com.example.Fproject.database;

import com.example.Fproject.database.entity.Device;

import java.util.List;

public interface DatabaseService {
    boolean authorization(String userId,String deviceId);
    boolean authentication(String userId,String password);
    boolean addDevice(String url,String type,String pin,String userId);
    boolean alterDevice(String userId,String deviceId,String url);
    boolean deleteDevice(String userId,String deviceId);
    boolean registerUser(String userId,String password);
    boolean deleteUser(String userId);
    boolean addRelationship(String userId, String deviceId);
    List<Device.Data> queryDeviceMember(String userId);
    String getUrl(String deviceId);

}

