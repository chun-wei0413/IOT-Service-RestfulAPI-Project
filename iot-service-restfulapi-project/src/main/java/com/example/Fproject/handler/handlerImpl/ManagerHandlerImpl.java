package com.example.Fproject.handler.handlerImpl;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.ManagerBean;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.database.entity.Manager;
import com.example.Fproject.handler.ManagerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerHandlerImpl implements ManagerHandler{
    @Autowired
    private IoTGatewayService ioTGatewayService;

    @Override
    public String addManager(ManagerBean.AddManagerBean addManagerBean){
        if(addManagerBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(addManagerBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(addManagerBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.addManager(addManagerBean.getUserId(), addManagerBean.getDeviceId(),addManagerBean.getPassword());
    }
    @Override
    public String deleteManager(ManagerBean.DeleteManagerBean deleteManagerBean){
        if(deleteManagerBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteManagerBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(deleteManagerBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.deleteManager(deleteManagerBean.getUserId(), deleteManagerBean.getDeviceId(),deleteManagerBean.getPassword());
    }
    @Override
    public List<Manager.member> listManager(ManagerBean.ManagerListBean managerListBean){
        if(managerListBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(managerListBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(managerListBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.listManager(managerListBean.getUserId(), managerListBean.getDeviceId(),managerListBean.getPassword());
    }
}
