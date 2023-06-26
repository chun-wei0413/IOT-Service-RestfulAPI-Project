package com.example.Fproject.IotService;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.IotService.IoTGatewayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class IoTConnecterImpl implements IoTConnecter {
    @Autowired
    private DatabaseService databaseService;


    private String sendGetRequest(String requestUrl, String state) {
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
        // 建立回應的 JSON 字串
        //Gson gson = new Gson();
        //response.append(gson.toJson(new ApiResponse(state)));

        return response.toString();
    }

    @Override
    public String powerOn(String url) {
        return null;
    }

    @Override
    public String powerOff(String url) {
        return null;
    }

    @Override
    public String getState(String url) {
        return null;
    }

    // 具有回應結果的 API 回應類別
    private static class ApiResponse {
        private String state;

        public ApiResponse(String state) {
            this.state = state;
        }
    }
}
