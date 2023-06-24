package com.example.Fproject.handler.handlerImpl;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.handler.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIHandlerImpl implements APIHandler {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private DatabaseService databaseService;
    @Override
    public String getState(IotBean.GetStateBean getStateBean){
        if(getStateBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(getStateBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        return ioTGatewayService.getState(getStateBean.getUserId(),getStateBean.getDeviceId(),getStateBean.getPassword());
    }
    @Override
    public String powerOff(IotBean.PowerOffBean powerOffBean){
        if(powerOffBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOffBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        return ioTGatewayService.powerOff(powerOffBean.getUserId(),powerOffBean.getDeviceId(),powerOffBean.getPassword());
    }
    @Override
    public String powerOn(IotBean.PowerOnBean powerOnBean){
        if(powerOnBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOnBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        return ioTGatewayService.powerOn(powerOnBean.getUserId(),powerOnBean.getDeviceId(),powerOnBean.getPassword());
    }
    public void deleteUser(UserBean.DeleteUserBean deleteUserBean){

    }
    public void authorUser(UserBean.AuthorUserBean authorUserBean){

    }
    public void registerUser(UserBean.RegisterUserBean registerUserBean){

    }
    public void alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean){

    }
    public void deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean){

    }
    public List<Device.DeviceData> getDeviceMembers (DeviceBean.QueryDeviceBean queryDeviceBean){
        return databaseService.getDeviceMembers(queryDeviceBean.getUserId());
    }
    public void addDevice(DeviceBean.AddDeviceBean addDeviceBean){

    }
}
