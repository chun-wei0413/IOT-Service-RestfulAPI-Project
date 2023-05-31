package com.example.Fproject.IotService;

//import java.util.UUID;

import com.example.Fproject.IotService.exception.UnauthorizedException;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public String powerOn(String key, String id) {
        if(!databaseService.authorization(key, id)) throw new UnauthorizedException();;
        return ioTConnecter.powerOn(databaseService.getUrl(id));

    }

    @Override
    public String powerOff(String key, String id) {
        if(!databaseService.authorization(key, id)) throw new UnauthorizedException();;
        return ioTConnecter.powerOff(databaseService.getUrl(id));
    }

    @Override
    public String getState(String key, String id) {
        if(!databaseService.authorization(key, id)) throw new UnauthorizedException();;
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
        return databaseService.alterDevice(id ,url);
    }

    @Override
    public boolean deleteDevice(String key,String id) {
        if(!databaseService.authorization(key, id)) return false;
        return databaseService.deleteDevice(id);
    }
}