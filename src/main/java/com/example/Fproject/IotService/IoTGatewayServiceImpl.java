package com.example.Fproject.IotService;

import com.example.Fproject.controller.DeviceController;
import com.example.Fproject.controller.IotController;
import com.example.Fproject.IotService.IoTConnecter;
import com.example.Fproject.IotService.IoTConnecterImpl;
import com.example.Fproject.controller.exception.DataNotFoundException;
import com.example.Fproject.controller.exception.IotExceptionHandler;
import com.example.Fproject.database.entity.device;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    private device Device;
    private IoTConnecter ioTConnecter;
    private IotController iotController;
    private DeviceController deviceController;

    public IoTGatewayServiceImpl(DatabaseService databaseService, IoTConnecter ioTConnecter,IotController iotController,DeviceController deviceController,device Device) {
        this.databaseService = databaseService;
        this.ioTConnecter = ioTConnecter;
        this.iotController = iotController;
        this.deviceController = deviceController;
        this.Device = Device;

    }

    @Override
    public String powerOn(String userId, String deviceId, String password) {
        if(databaseService.authorization(userId,deviceId,password)) {
            String url = device(url);
            return url;
        }
        else return "fall";
    }

    @Override
    public String powerOff(String userId, String deviceId, String password) {
        if(databaseService.authorization(userId,deviceId,password)) {
            String url = device(url);
            return url;
        }
        else return "fall";
    }

    @Override
    public String getState(String userId, String deviceId, String password) {
        if(databaseService.authorization(userId,deviceId,password)) {
            String url = device(url);
            return url;
        }
        else return "fall";
    }

    @Override
    public String[] addDevice(String url,String type,String pin,String manager) {
        String[] response = new String[1];
        response[0] = databaseService.addDevice(url, type, pin, manager)[0];
        return response;
    }

    @Override
    public boolean alterDevice(String key, String id, String url) {
        if(!databaseService.authorization(key, id)) return false;
        return databaseService.alterDevice(id,url);
    }

    @Override
    public boolean deleteDevice(String key,String id) {
        if(!databaseService.authorization(key, id)) return false;
        return databaseService.deleteDevice(id);
    }
}