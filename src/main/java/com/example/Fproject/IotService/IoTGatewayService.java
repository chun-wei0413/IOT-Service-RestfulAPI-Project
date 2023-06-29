package com.example.Fproject.IotService;

import java.util.List;

public interface IoTGatewayService {
	String powerOn(String userId,String deviceId,String password);
	String powerOff(String userId,String deviceId,String password);
	String getState(String userId,String deviceId,String password);
	String addDevice(String url,String type,String pin,String userId);
	String alterDevice(String userId,String password,String deviceId,String url);
	String deleteDevice(String userId,String password,String deviceId);
	String registerUser(String userId,String password);
	String deleteUser(String userId,String password);
	String addRelationship(String userId,String deviceId,String password);
	List<String> queryDevice(String userId, String password);
}
