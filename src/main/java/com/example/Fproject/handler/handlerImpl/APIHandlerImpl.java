package com.example.Fproject.handler.handlerImpl;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.handler.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Fproject.database.entity.*;

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
    public String deleteUser(UserBean.DeleteUserBean deleteUserBean){
        if(deleteUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.deleteUser(deleteUserBean.getUserId(),deleteUserBean.getPassword());
    }
    public String authorUser(UserBean.AuthorUserBean authorUserBean){
        if(authorUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(authorUserBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(authorUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.addRelationship(authorUserBean.getUserId(),authorUserBean.getDeviceId(),authorUserBean.getPassword());
    }
    public String registerUser(UserBean.RegisterUserBean registerUserBean){
        if(registerUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(registerUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.registerUser(registerUserBean.getUserId(),registerUserBean.getPassword());

    }
    public String alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean){
        if(alterDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(alterDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(alterDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(alterDeviceBean.getUrl()==null) throw new RequestNotFoundException("url");
        return ioTGatewayService.alterDevice(alterDeviceBean.getUserId(),alterDeviceBean.getPassword(),alterDeviceBean.getDeviceId(),alterDeviceBean.getUrl());
    }
    public String deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean){
        if(deleteDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(deleteDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        return ioTGatewayService.deleteDevice(deleteDeviceBean.getUserId(),deleteDeviceBean.getPassword(),deleteDeviceBean.getDeviceId());
    }
    public List<Device.Data> queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean){
        if(queryDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(queryDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.queryDevice(queryDeviceBean.getUserId(),queryDeviceBean.getPassword());
    }
    public String addDevice(DeviceBean.AddDeviceBean addDeviceBean){
        if(addDeviceBean.getUrl()==null) throw new RequestNotFoundException("url");
        if(addDeviceBean.getType()==null) throw new RequestNotFoundException("Type");
        if(addDeviceBean.getPin()==null) throw new RequestNotFoundException("Pin");
        if(addDeviceBean.getManager()==null) throw new RequestNotFoundException("Manager");
        return ioTGatewayService.addDevice(addDeviceBean.getUrl(),addDeviceBean.getType(),addDeviceBean.getPin(),addDeviceBean.getManager());
    }
}
