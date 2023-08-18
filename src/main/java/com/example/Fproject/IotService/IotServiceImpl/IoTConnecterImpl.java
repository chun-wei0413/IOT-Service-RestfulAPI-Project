package com.example.Fproject.IotService.IotServiceImpl;
import com.example.Fproject.IotService.IoTConnecter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

import com.example.Fproject.mqtt.*;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

@Service
public class IoTConnecterImpl implements IoTConnecter {


    @Autowired
    private MqttClient mqttClient;
    @Autowired
    private MqttFactory mqttFactory;
    @Autowired
    private MessageListener messageListener;
    @Override
    public String powerOn(String deviceId) throws MqttException {
        send(deviceId+"/command","off");
        return "Turned on";
    }

    @Override
    public String powerOff(String deviceId) throws MqttException {
        send(deviceId+"/command","on");
        return "Turned off";
    }

    @Override
    public String getState(String deviceId) throws MqttException, InterruptedException {
        String stateTopic = "/response/"+ deviceId + "/state";
        // 訂閱主題並設置 MessageListener
        subscribe(stateTopic, messageListener);
        // 發布取得狀態的指令
        send(deviceId + "/command", "state");

        // 返回收到的訊息
        return "requesting State";
    }
    public static void send(String topic, Object data) throws MqttException {
        // 获取客户端实例
        MqttClient client = MqttFactory.mqttClient();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 转换消息为json字符串
            String json = mapper.writeValueAsString(data);
            client.publish(topic, new MqttMessage(json.getBytes(StandardCharsets.UTF_8)));
        } catch (JsonProcessingException e) {
            LOGGER.error(String.format("MQTT: 主题[%s]发送消息转换json失败", topic));
        } catch (MqttException e) {
            LOGGER.error(String.format("MQTT: 主题[%s]发送消息失败", topic));
        }
    }

    public static void subscribe(String topic, IMqttMessageListener listener) throws MqttException {
        MqttClient client = MqttFactory.mqttClient();
        try {
            client.subscribe(topic, listener);
        } catch (MqttException e) {
            LOGGER.error(String.format("MQTT: 订阅主题[%s]失败", topic));
        }
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

