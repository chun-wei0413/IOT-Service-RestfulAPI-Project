package com.example.Fproject.handler;

import com.example.Fproject.apibody.IotBean;

public interface IoTHandler {
    String getState(IotBean.GetStateBean getStateBean);
    String powerOff(IotBean.PowerOffBean powerOffBean);
    String powerOn(IotBean.PowerOnBean powerOnBean);
}
