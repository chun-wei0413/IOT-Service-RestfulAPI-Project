package com.example.Fproject.IotService;
import com.example.Fproject.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi4j.io.gpio.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class IoTConnecterImpl implements IoTConnecter {
    @Autowired
    private DatabaseService databaseService;
    private final GpioController gpio;
    private final GpioPinDigitalOutput led;

    public IoTConnecterImpl(DatabaseService databaseService) {
        this.databaseService = databaseService;
        gpio = GpioFactory.getInstance();
        //Pin ledPin = DatabaseService.pin;
        Pin ledPin = RaspiPin.GPIO_18;
        led = gpio.provisionDigitalOutputPin(ledPin, "LED", PinState.LOW);
    }

    @Override
    public String powerOn(String url) {
        String requestUrl = url + "/on";
        led.high(); // 開啟LED燈
        return sendGetRequest(requestUrl, "successful");
    }

    @Override
    public String powerOff(String url) {
        String requestUrl = url + "/off";
        led.low(); // 關閉LED燈
        return sendGetRequest(requestUrl, "successful");
    }

    @Override
    public String getState(String url) {
        String requestUrl = url + "/state";
        if (led.isHigh()) {
            return sendGetRequest(requestUrl, "on");
        }
        else {
            return sendGetRequest(requestUrl, "off");
        }
    }

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

    // 在程式結束時釋放 GPIO 資源
    public void shutdown() {
        gpio.shutdown();
    }

    // 具有回應結果的 API 回應類別
    private static class ApiResponse {
        private String state;

        public ApiResponse(String state) {
            this.state = state;
        }
    }
}

