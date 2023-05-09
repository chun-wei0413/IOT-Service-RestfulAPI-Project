package com.example.Fproject.IotService;

//import java.util.UUID;

import com.example.Fproject.database.DatabaseService;

public class IoTGatewayServiceImpl implements IoTGatewayService {
    private DatabaseService databaseService;
    private IoTConnecter ioTConnecter;

    public IoTGatewayServiceImpl(DatabaseService databaseService, IoTConnecter ioTConnecter) {
        this.databaseService = databaseService;
        this.ioTConnecter = ioTConnecter;
    }

    @Override
    public String powerOn(String key, String id) {
        if(!databaseService.authorization(key, id)) return null;
        return ioTConnecter.powerOn(databaseService.getUrl(id));
    }

    @Override
    public String powerOff(String key, String id) {
        if(!databaseService.authorization(key, id)) return null;
        return ioTConnecter.powerOff(databaseService.getUrl(id));
    }

    @Override
    public String getState(String key, String id) {
        if(!databaseService.authorization(key, id)) return null;
        return ioTConnecter.getState(databaseService.getUrl(id));
    }

    @Override
    public String[] addDevice(String url) {
        String[] response = new String[1];
        //response[0] = UUID.randomUUID().toString();
        response[0] = databaseService.addDevice(url)[0];
        return response;
    }

    @Override
    public boolean alterDevice(String key, String id, String url) {
        if(!databaseService.authorization(key, id)) return false;
        return databaseService.alterDevice(url);
    }

    @Override
    public boolean deleteDevice(String key,String id) {
        if(!databaseService.authorization(key, id)) return false;
        return databaseService.deleteDevice(id);
    }
}