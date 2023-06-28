package com.example.Fproject.database;

//import com.example.Fproject.database.entity.device;
public interface DatabaseService {
    boolean authorization(String userId,String deviceId);
    boolean authentication(String userId,String password);
    boolean addDevice(String url,String type,String pin,String userId);
    boolean alterDevice(String userId,String deviceId,String url);
    boolean deleteDevice(String deviceId,String userId);
    boolean registerUser(String userId,String password);
    boolean deleteUser(String userId,String password);
    String getUrl(String deviceId);

}

