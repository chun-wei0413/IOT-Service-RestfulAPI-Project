package com.example.Fproject.handler.handlerImpl;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.handler.IoTHandler;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoTHandlerImpl implements IoTHandler {
    @Autowired
    private IoTGatewayService ioTGatewayService;

    @Override
    public String getState(IotBean.GetStateBean getStateBean) throws MqttException, InterruptedException {
        if(getStateBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(getStateBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(getStateBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.getState(getStateBean.getUserId(),getStateBean.getDeviceId(),getStateBean.getPassword());
    }
    @Override
    public String powerOff(IotBean.PowerOffBean powerOffBean) throws MqttException {
        if(powerOffBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOffBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(powerOffBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.powerOff(powerOffBean.getUserId(),powerOffBean.getDeviceId(),powerOffBean.getPassword());
    }
    @Override
    public String powerOn(IotBean.PowerOnBean powerOnBean) throws MqttException {
        if(powerOnBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOnBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(powerOnBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.powerOn(powerOnBean.getUserId(),powerOnBean.getDeviceId(),powerOnBean.getPassword());
    }
}
