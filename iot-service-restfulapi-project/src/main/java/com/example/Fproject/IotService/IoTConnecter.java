package com.example.Fproject.IotService;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IoTConnecter {
	String powerOn(String deviceId) throws MqttException;
	String powerOff(String deviceId) throws MqttException;
	String getState(String deviceId) throws MqttException, InterruptedException;
}
