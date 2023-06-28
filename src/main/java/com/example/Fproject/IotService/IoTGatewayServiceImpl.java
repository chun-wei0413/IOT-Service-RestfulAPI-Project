package com.example.Fproject.IotService;


import com.example.Fproject.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private IoTConnecter ioTConnecter;

    public IoTGatewayServiceImpl(DatabaseService databaseService, IoTConnecter ioTConnecter) {
        this.databaseService = databaseService;
        this.ioTConnecter = ioTConnecter;
    }

    @Override
    public String powerOn(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        return ioTConnecter.powerOn(url);
    }

    @Override
    public String powerOff(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        return ioTConnecter.powerOff(url);
    }

    @Override
    public String getState(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        return ioTConnecter.getState(url);
    }
    @Override
    public boolean addDevice(String url,String type,String pin,String userId) {
        return databaseService.addDevice(url, type, pin, userId);
    }

    @Override
    public boolean alterDevice(String userId,String password,String deviceId,String url) {
        databaseService.authentication(userId,password);
        databaseService.authorization(userId,deviceId);
        return databaseService.alterDevice(userId,deviceId,url);

    }

    @Override
    public boolean deleteDevice(String userId,String password,String deviceId) {
        databaseService.authentication(userId,password);
        databaseService.authorization(userId,deviceId);
        return databaseService.deleteDevice(userId,deviceId);
    }
    @Override
    public boolean registerUser(String userId,String password){
        return databaseService.registerUser(userId,password);
    }
    @Override
    public boolean deleteUser(String userId,String password){
        return databaseService.deleteUser(userId,password);
    }
}