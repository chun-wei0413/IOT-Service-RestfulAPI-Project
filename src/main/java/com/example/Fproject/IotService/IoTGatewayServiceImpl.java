package com.example.Fproject.IotService;

import com.example.Fproject.controller.DeviceController;
import com.example.Fproject.controller.IotController;
import com.example.Fproject.IotService.IoTConnecter;
import com.example.Fproject.IotService.IoTConnecterImpl;
import com.example.Fproject.controller.exception.DataNotFoundException;
import com.example.Fproject.controller.exception.IotExceptionHandler;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class IoTGatewayServiceImpl implements IoTGatewayService {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private IoTConnecter ioTConnecter;
    @Autowired
    private IotController iotController;
    @Autowired
    private DeviceController deviceController;



    @Override
    public String powerOn(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        ioTConnecter.powerOn(url);
        String requestUrl = url + "/on";
        return sendGetRequest(requestUrl);
    }

    @Override
    public String powerOff(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        ioTConnecter.powerOn(url);
        String requestUrl = url + "/off";
        return sendGetRequest(requestUrl);
    }

    @Override
    public String getState(String userId, String deviceId, String password) {
        databaseService.authorization(userId,password);
        databaseService.authentication(deviceId,password);
        String url = databaseService.getUrl(deviceId);
        ioTConnecter.powerOn(url);
        String requestUrl = url + "/state";
        return sendGetRequest(requestUrl);
    }

    @Override
    public boolean addDevice(String url,String type,String pin,String manager) {

        databaseService.addDevice(url, type, pin, manager);
        return true;
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
    private String sendGetRequest(String requestUrl) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            }
            else {
                response.append("GET request failed with response code: " + responseCode);
            }
        }
        catch (IOException e) {
            response.append("Exception occurred while sending GET request: " + e.getMessage());
        }

        return response.toString();
    }
}