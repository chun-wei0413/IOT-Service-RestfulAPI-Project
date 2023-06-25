package com.example.Fproject.database;

import com.example.Fproject.database.entity.device;

public interface DatabaseService {
	boolean authorization(String userId,String deviceId,String password);
	boolean addDevice(String url,String type,String pin,String manager);
	boolean alterDevice(String userId,String password,String deviceId,String url);
	boolean deleteDevice(String userId,String deviceId,String password);
	boolean registerUser(String userId,String password);
	device queryDevice(String userId, String password);

}
