package com.example.Fproject.IotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IoTConnecterImpl implements IoTConnecter {
    private static final String USER_AGENT = "Mozilla/5.0";
    
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
            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                in.close();
            } 
            else {
                response.append("GET request failed with response code: " + responseCode);
            }
        } 
        //發生例外狀況時，將錯誤訊息附加在response字串後面返回，存儲從IoT裝置接收到的數據或錯誤訊息。
        catch (IOException e) {
            response.append("Exception occurred while sending GET request: " + e.getMessage());
        }
        return response.toString();
    }
}
