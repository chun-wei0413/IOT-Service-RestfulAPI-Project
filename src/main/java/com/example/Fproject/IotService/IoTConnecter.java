package com.example.Fproject.IotService;

public interface IoTConnecter {
	String powerOn(String url);
	String powerOff(String url);
	String getState(String url);
}
