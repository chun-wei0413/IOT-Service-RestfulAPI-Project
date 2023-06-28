package com.example.Fproject.handler.handlerImpl;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.handler.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIHandlerImpl implements APIHandler {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Override
    public String getState(IotBean.GetStateBean getStateBean){
        if(getStateBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(getStateBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(getStateBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.getState(getStateBean.getUserId(),getStateBean.getDeviceId(),getStateBean.getPassword());
    }
    @Override
    public String powerOff(IotBean.PowerOffBean powerOffBean){
        if(powerOffBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOffBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(powerOffBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.powerOff(powerOffBean.getUserId(),powerOffBean.getDeviceId(),powerOffBean.getPassword());
    }
    @Override
    public String powerOn(IotBean.PowerOnBean powerOnBean){
        if(powerOnBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(powerOnBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(powerOnBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.powerOn(powerOnBean.getUserId(),powerOnBean.getDeviceId(),powerOnBean.getPassword());
    }
    public void deleteUser(UserBean.DeleteUserBean deleteUserBean){
        if(deleteUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        ioTGatewayService.deleteUser(deleteUserBean.getUserId(),deleteUserBean.getPassword());
    }
    public void authorUser(UserBean.AuthorUserBean authorUserBean){

    }
    public void registerUser(UserBean.RegisterUserBean registerUserBean){
        if(registerUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(registerUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        ioTGatewayService.registerUser(registerUserBean.getUserId(),registerUserBean.getPassword());

    }
    public void alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean){
        if(alterDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(alterDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(alterDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(alterDeviceBean.getUrl()==null) throw new RequestNotFoundException("url");
        ioTGatewayService.alterDevice(alterDeviceBean.getUserId(),alterDeviceBean.getPassword(),alterDeviceBean.getDeviceId(),alterDeviceBean.getUrl());
    }
    public void deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean){
        if(deleteDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(deleteDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        ioTGatewayService.deleteDevice(deleteDeviceBean.getUserId(),deleteDeviceBean.getPassword(),deleteDeviceBean.getDeviceId());
    }
    public void queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean){

    }
    public void addDevice(DeviceBean.AddDeviceBean addDeviceBean){
        if(addDeviceBean.getUrl()==null) throw new RequestNotFoundException("url");
        if(addDeviceBean.getType()==null) throw new RequestNotFoundException("Type");
        if(addDeviceBean.getPin()==null) throw new RequestNotFoundException("Pin");
        if(addDeviceBean.getManager()==null) throw new RequestNotFoundException("Manager");
        ioTGatewayService.addDevice(addDeviceBean.getUrl(),addDeviceBean.getType(),addDeviceBean.getPin(),addDeviceBean.getManager());
    }
}
