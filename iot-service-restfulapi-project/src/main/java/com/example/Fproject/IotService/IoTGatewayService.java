package com.example.Fproject.IotService;

import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.entity.Manager;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.List;

public interface IoTGatewayService {
	String powerOn(String userId,String deviceId,String password) throws MqttException;
	String powerOff(String userId,String deviceId,String password) throws MqttException;
	String getState(String userId,String deviceId,String password) throws MqttException, InterruptedException;
	String addDevice(String type,String pin,String userId);
	String alterDevice(String userId,String password,String deviceId,String url);
	String deleteDevice(String userId,String password,String deviceId);
	String registerUser(String userId,String password);
	String deleteUser(String userId,String password);
	String addRelationship(String userId,String deviceId,String password);
	List<Device.Data> queryDevice(String userId, String password);

	String addManager(String userId, String deviceId, String password);
	String deleteManager(String userId, String deviceId, String password);
	List<Manager.member> listManager(String userId, String deviceId, String password);
}
