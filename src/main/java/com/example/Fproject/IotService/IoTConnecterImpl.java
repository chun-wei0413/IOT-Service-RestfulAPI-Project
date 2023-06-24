package com.example.Fproject.IotService;
import org.springframework.stereotype.Service;
import com.pi4j.io.gpio.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class IoTConnecterImpl implements IoTConnecter {
    private final GpioController gpio;
    private final GpioPinDigitalOutput led;

    public IoTConnecterImpl() {
        //gpio = GpioFactory.getInstance();
        //Pin ledPin = RaspiPin.GPIO_18;
        //led = gpio.provisionDigitalOutputPin(ledPin, "LED", PinState.LOW);
    }

    @Override
    public String powerOn(String ngrokUrl) {
        String requestUrl = ngrokUrl + "/on";
        //led.high(); // 開啟LED燈
        return sendGetRequest(requestUrl, "ssssss");
    }

    @Override
    public String powerOff(String ngrokUrl) {
        String requestUrl = ngrokUrl + "/off";
        led.low(); // 關閉LED燈
        return sendGetRequest(requestUrl, "ssssss");
    }

    @Override
    public String getState(String ngrokUrl) {
        String requestUrl = ngrokUrl + "/state";
        return sendGetRequest(requestUrl, "ssssss");
    }

    private String sendGetRequest(String requestUrl, String password) {
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
        //response.append(gson.toJson(new ApiResponse(password)));

        return response.toString();
    }

    // 在程式結束時釋放 GPIO 資源
    public void shutdown() {
        //gpio.shutdown();
    }

    // 具有回應結果的 API 回應類別
    private static class ApiResponse {
        private String password;

        public ApiResponse(String password) {
            this.password = password;
        }
    }
}

//6.24.2

