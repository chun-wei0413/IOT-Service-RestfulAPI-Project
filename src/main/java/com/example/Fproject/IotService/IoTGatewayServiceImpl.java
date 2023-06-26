package com.example.Fproject.IotService;


import com.example.Fproject.controller.IotController;
import com.example.Fproject.IotService.IoTConnecter;
import com.example.Fproject.IotService.IoTConnecterImpl;

import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    private IoTConnecter ioTConnecter;
    private IotController iotController;




    @Override
    public String powerOn(String key, String id) {
        return null;
    }

    @Override
    public String powerOff(String key, String id) {
        return null;
    }

    @Override
    public String getState(String key, String id) {
        return null;
    }

    @Override
    public String[] addDevice(String url) {
        return new String[0];
    }

    @Override
    public boolean alterDevice(String key, String id, String url) {
        //if(!databaseService.authorization(key, id)) return false;
        //return databaseService.alterDevice(id,url);
        return true;
    }

    @Override
    public boolean deleteDevice(String key,String id) {
        //if(!databaseService.authorization(key, id)) return false;
        //return databaseService.deleteDevice(id);
        return true;
    }
}