package com.example.Fproject.IotService;

public interface IoTGatewayService {
	String powerOn(String key,String id); 
	String powerOff(String key,String id); 
	String getState(String key,String id); 
	String[] addDevice(String url); 
	boolean alterDevice(String key,String id,String url); 
	boolean deleteDevice(String key,String id);
}
