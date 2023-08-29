package com.example.Fproject.IotService.IotServiceImpl;


import com.example.Fproject.IotService.IoTConnecter;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.entity.Manager;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private IoTConnecter ioTConnecter;


    @Override
    public String powerOn(String userId, String deviceId, String password) throws MqttException {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                return ioTConnecter.powerOn(deviceId);
            }else{
                return "permission failed";
            }

        }
        return "authentication fail";
    }

    @Override
    public String powerOff(String userId, String deviceId, String password) throws MqttException {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                return ioTConnecter.powerOff(deviceId);
            }else{
                return "permission failed";
            }

        }
        return "authentication fail";
    }

    @Override
    public String getState(String userId, String deviceId, String password) throws MqttException, InterruptedException {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                return ioTConnecter.getState(deviceId);
            }
            else{
                return "permission failed";
            }
        }
        return "authentication fail";
    }
    @Override
    public String addDevice(String type,String pin,String userId) {
        if(databaseService.addDevice(type, pin, userId)){
            return "Successful Addition";
        }
        return "Unsuccessful Addition";
    }

    @Override
    public String alterDevice(String userId,String password,String deviceId,String pin) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.alterDevice(userId,deviceId,pin)){
                return "Successful Modification";
            }
            else{
                return "Failed Modification";
            }
        }
        return "authentication fail";
    }

    @Override
    public String deleteDevice(String userId,String password,String deviceId) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.deleteDevice(userId,deviceId)){
                return "Successful Deletion";
            }
            else{
                return "Failed Deletion";
            }
        }
        return "authentication fail";
    }
    @Override
    public String registerUser(String userId,String password){
        if(databaseService.registerUser(userId,password)){
            return "Successful Registration";
        }
        return "Failed Registration";
    }
    @Override
    public String deleteUser(String userId,String password){
        if(databaseService.authentication(userId,password)){
            if(databaseService.deleteUser(userId)){
                return "Successful Deletion";
            }
            else{
                return "Failed Deletion";
            }
        }
        return "authentication fail";
    }
    @Override
    public String addRelationship(String userId, String deviceId, String password){
        if(databaseService.authentication(userId,password)){
            if(databaseService.addRelationship(userId,deviceId)){
                return "Successful Authorization";
            }
            else{
                return "Failed Authorization";
            }
        }
        return "authentication fail";
    }
    @Override
    public List<Device.Data> queryDevice(String userId,String deviceId){
            return databaseService.queryDeviceMember(userId);
    }

    @Override
    public String addManager(String userId, String deviceId,String password){
        if(databaseService.authentication(userId,password)){
            if(databaseService.addManager(userId,deviceId)){
                return "Successful Addition";
            }
            else{
                return "Failed Addition";
            }
        }
        return "authentication fail";
    }
    @Override
    public String deleteManager(String userId, String deviceId,String password){
        if(databaseService.authentication(userId,password)){
            if(databaseService.deleteManager(userId,deviceId)){
                return "Successful Deletion";
            }
            else{
                return "Failed Deletion";
            }
        }
        return "authentication fail";
    }
    @Override
    public List<Manager.member> listManager(String userId, String deviceId,String password){
        return databaseService.listManager(deviceId);
    }
}