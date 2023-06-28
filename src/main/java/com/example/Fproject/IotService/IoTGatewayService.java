package com.example.Fproject.IotService;

public interface IoTGatewayService {
	String powerOn(String userId,String deviceId,String password);
	String powerOff(String userId,String deviceId,String password);
	String getState(String userId,String deviceId,String password);
	boolean addDevice(String url,String type,String pin,String userId);
	boolean alterDevice(String userId,String password,String deviceId,String url);
	boolean deleteDevice(String userId,String password,String deviceId);
}
