package com.example.Fproject.IotService;

public interface IoTGatewayService {
	String powerOn(String userId,String deviceId,String password);
	String powerOff(String userId,String deviceId,String password);
	String getState(String userId,String deviceId,String password);
	boolean addDevice(String url,String type,String pin,String manager);
	boolean alterDevice(String key,String id,String url); 
	boolean deleteDevice(String key,String id);
}
