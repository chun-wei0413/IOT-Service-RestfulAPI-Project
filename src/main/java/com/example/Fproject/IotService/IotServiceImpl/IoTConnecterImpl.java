package com.example.Fproject.IotService.IotServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.Fproject.IotService.IoTConnecter;
import org.springframework.stereotype.Service;
//import com.pi4j.io.gpio.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class IoTConnecterImpl implements IoTConnecter {


    @Override
    public String powerOn(String url) {
        String requestUrl = url + "/on";
        return sendGetRequest(requestUrl);
    }

    @Override
    public String powerOff(String url) {
        String requestUrl = url + "/off";
        return sendGetRequest(requestUrl);
    }

    @Override
    public String getState(String url) {
        String requestUrl = url + "/state";
        return sendGetRequest(requestUrl);
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
                String line;
                while((line=in.readLine())!=null){
                    response.append(line);
                }
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

