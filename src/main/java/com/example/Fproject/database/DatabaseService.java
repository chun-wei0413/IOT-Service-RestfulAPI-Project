package com.example.Fproject.database;

public interface DatabaseService {
	boolean authorization(String userId,String deviceId,String password);
	boolean addDevice(String url,String type,String pin,String manager);
	boolean alterDevice(String userId,String password,String deviceId,String url);
	boolean deleteDevice(String userId,String deviceId,String password);
	boolean registerUser(String userId,String password);
	String queryDevice(String userId,String password);
	boolean deviceOn(String userId,String deviceId,String password);
	boolean deviceOff(String userId,String deviceId,String password);
	String deviceState(String userId,String deviceId,String password);

}
