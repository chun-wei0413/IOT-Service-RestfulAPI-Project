package com.example.Fproject.IotService;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.IotService.IoTGatewayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi4j.io.gpio.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class IoTConnecterImpl implements IoTConnecter {
    @Autowired
    private DatabaseService databaseService;
    private IoTGatewayService ioTGatewayService;
    private final GpioController gpio;
    private final GpioPinDigitalOutput led;

    public IoTConnecterImpl(DatabaseService databaseService,IoTGatewayService ioTGatewayService) {
        this.databaseService = databaseService;
        this.ioTGatewayService = ioTGatewayService;
        gpio = GpioFactory.getInstance();
        //Pin ledPin = DatabaseService.pin;
        Pin ledPin = RaspiPin.GPIO_18;
        led = gpio.provisionDigitalOutputPin(ledPin, "LED", PinState.LOW);
    }

    @Override
    public String powerOn(String url) {
        String requestUrl = url + "/devices/on";
        led.high(); // 開啟LED燈
        return sendGetRequest(requestUrl, "successful");
    }

    @Override
    public String powerOff(String url) {
        String requestUrl = url + "/devices/off";
        led.low(); // 關閉LED燈
        return sendGetRequest(requestUrl, "successful");
    }

    @Override
    public String getState(String url) {
        String requestUrl = url + "/devices/state";
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response.append(objectMapper.writeValueAsString(new ApiResponse(state)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    // 在程式結束時釋放 GPIO 資源
    //public void shutdown() {gpio.shutdown();}

    // 具有回應結果的 API 回應類別
    private static class ApiResponse {
        private String state;

        public ApiResponse(String state) {
            this.state = state;
        }
    }
}

