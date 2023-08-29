package com.example.Fproject.handler.handlerImpl;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.database.entity.Device;
import com.example.Fproject.handler.DeviceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceHandlerImpl implements DeviceHandler {

    @Autowired
    private IoTGatewayService ioTGatewayService;


    @Override
    public String alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean){
        if(alterDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(alterDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(alterDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(alterDeviceBean.getPin()==null) throw new RequestNotFoundException("url");
        return ioTGatewayService.alterDevice(alterDeviceBean.getUserId(),alterDeviceBean.getPassword(),alterDeviceBean.getDeviceId(),alterDeviceBean.getPin());
    }

    @Override
    public String deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean){
        if(deleteDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        if(deleteDeviceBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        return ioTGatewayService.deleteDevice(deleteDeviceBean.getUserId(),deleteDeviceBean.getPassword(),deleteDeviceBean.getDeviceId());
    }

    @Override
    public List<Device.Data> queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean){
        if(queryDeviceBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(queryDeviceBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.queryDevice(queryDeviceBean.getUserId(),queryDeviceBean.getPassword());
    }

    @Override
    public String addDevice(DeviceBean.AddDeviceBean addDeviceBean){
        if(addDeviceBean.getType()==null) throw new RequestNotFoundException("Type");
        if(addDeviceBean.getPin()==null) throw new RequestNotFoundException("Pin");
        if(addDeviceBean.getManager()==null) throw new RequestNotFoundException("Manager");
        return ioTGatewayService.addDevice(addDeviceBean.getType(),addDeviceBean.getPin(),addDeviceBean.getManager());
    }

}
