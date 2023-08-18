package com.example.Fproject.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

@Configuration
public class MqttFactory {

    private static MqttClient client;
    public static final String ip = "140.136.151.74";
    public static final String port = "1883";
    /**
     *   获取客户端实例
     *   单例模式, 存在则返回, 不存在则初始化
     */
    @Bean
    public static MqttClient mqttClient() throws MqttException {
        if (client == null) {
            init();
        }
        return client;
    }

    /**
     *   初始化客户端
     */
    public static void init() throws MqttException {
            try{
            client = new MqttClient("tcp://" + ip + ":"+ port, "");
            // MQTT配置对象
            MqttConnectOptions options = new MqttConnectOptions();
            // 设置自动重连, 其它具体参数可以查看MqttConnectOptions
            options.setAutomaticReconnect(true);
            if (!client.isConnected()) {
                client.connect(options);
            }
            } catch (MqttException e) {
            LOGGER.error(String.format("MQTT: 连接消息服务器[%s]失败", "tcp://" + ip + ":"+ port));
        }
    }

}
