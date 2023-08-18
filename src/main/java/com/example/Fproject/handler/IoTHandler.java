package com.example.Fproject.handler;

import com.example.Fproject.apibody.IotBean;
import org.eclipse.paho.client.mqttv3.MqttException;

public interface IoTHandler {
    String getState(IotBean.GetStateBean getStateBean) throws MqttException, InterruptedException;
    String powerOff(IotBean.PowerOffBean powerOffBean) throws MqttException;
    String powerOn(IotBean.PowerOnBean powerOnBean) throws MqttException;
}
