package com.example.Fproject.IotService;


import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private IoTConnecter ioTConnecter;


    @Override
    public String powerOn(String userId, String deviceId, String password) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                String url = databaseService.getUrl(deviceId);
                return ioTConnecter.powerOn(url);
            }else{
                return "permission failed";
            }

        }
        return "authentication fail";
    }

    @Override
    public String powerOff(String userId, String deviceId, String password) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                String url = databaseService.getUrl(deviceId);
                return ioTConnecter.powerOff(url);
            }else{
                return "permission failed";
            }

        }
        return "authentication fail";
    }

    @Override
    public String getState(String userId, String deviceId, String password) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.authorization(userId,deviceId)){
                String url = databaseService.getUrl(deviceId);
                return ioTConnecter.getState(url);
            }
            else{
                return "permission failed";
            }
        }
        return "authentication fail";
    }
    @Override
    public String addDevice(String url,String type,String pin,String userId) {
        if(databaseService.addDevice(url, type, pin, userId)){
            return "Successful Addition";
        }
        return "Unsuccessful Addition";
    }

    @Override
    public String alterDevice(String userId,String password,String deviceId,String url) {
        if(databaseService.authentication(userId,password)){
            if(databaseService.alterDevice(userId,deviceId,url)){
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
    public List<Device.Data> queryDevice(String userId, String password){
            return databaseService.queryDeviceMember(userId);
    }
}